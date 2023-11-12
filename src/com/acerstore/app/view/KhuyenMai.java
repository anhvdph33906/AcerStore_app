/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.acerstore.app.view;

import com.acerstore.app.dao.KhuyenMaiDAO;
import com.acerstore.app.model.KhuyenMaiModel;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class KhuyenMai extends javax.swing.JPanel {

    KhuyenMaiDAO dao = new KhuyenMaiDAO();
    int rows = -1;

    public KhuyenMai() {
        initComponents();
        this.fillTableKhuyenMai(null);
    }

    DefaultTableModel model = new DefaultTableModel();

    public void fillTableKhuyenMai(String keyword) {
        model = (DefaultTableModel) tblKhuyenMai.getModel();
        model.setRowCount(0);
        try {
            List<KhuyenMaiModel> list;
            if (keyword != null) {
                list = dao.selectByKeyword(keyword);
            } else {
                list = dao.selectAll();
            }
            for (KhuyenMaiModel km : list) {
                Object[] row = {
                    km.getMaKM(),
                    km.getTenKM(),
                    km.getKieuKM(),
                    km.getTriGia(),
                    km.getThoiGianBatDau(),
                    km.getThoiGianKetThuc(),
                    km.getTrangThai()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi");
        }
    }

    void SetFormKhuyenMai(KhuyenMaiModel km) {
        txtMaKM.setText(km.getMaKM());
        txtTenKM.setText(km.getTenKM());
        cboKieuKM.setSelectedItem(km.getKieuKM());
        txtGia.setText(String.valueOf(km.getTriGia()));
        dcsBatDau.setDate(km.getThoiGianBatDau());
        dcsKetThuc.setDate(km.getThoiGianKetThuc());
    }

    void edit() {
        String maKM = (String) tblKhuyenMai.getValueAt(this.rows, 0);
        tblKhuyenMai.setRowSelectionInterval(rows, rows);
        KhuyenMaiModel km = dao.selectById(maKM);
        this.SetFormKhuyenMai(km);
    }

//    void edit1() {
//        String maSP = (String) tblSanPham.getValueAt(this.rows, 0);
//        tblSanPham.setRowSelectionInterval(rows, rows);
//        KhuyenMaiModel km = dao.selectById(maSP);
//        this.SetFormKhuyenMai(km);
//    }
    void first() {
        this.rows = 0;
        this.edit();
    }

//    void first1() {
//        this.rows = 0;
//        this.edit();
//    }
    void prev() {
        if (this.rows > 0) {
            this.rows--;
            this.edit();
        }
    }

//    void prev1() {
//        if (this.rows > 0) {
//            this.rows--;
//            this.edit();
//        }
//    }
    void next() {
        if (this.rows < tblKhuyenMai.getRowCount() - 1) {
            this.rows++;
            this.edit();
        }else{
            this.rows = 0;
            this.edit();
        }
    }

//    void next1() {
//        if (this.rows < tblKhuyenMai.getRowCount() - 1) {
//            this.rows++;
//            this.edit();
//        }
//    }
    void last() {
        this.rows = tblKhuyenMai.getRowCount() - 1;
        this.edit();
    }

//    void last1() {
//        this.rows = tblKhuyenMai.getRowCount() - 1;
//        this.edit();
//    }
    boolean checkDulieu() {
        if (txtMaKM.getText().isEmpty()) {
            txtMaKM.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã KM");
            return false;
        }
        if (txtTenKM.getText().isEmpty()) {
            txtTenKM.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên KM");
            return false;
        }
        if (txtGia.getText().isEmpty()) {
            txtGia.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá");
            return false;
        }
        try {
            if (Double.parseDouble(txtGia.getText()) < 0) {
                txtGia.requestFocus();
                JOptionPane.showMessageDialog(this, "Giá trị không được âm");
                return false;
            }
        } catch (Exception e) {
            txtGia.requestFocus();
            JOptionPane.showMessageDialog(this, "Sai định dạng");
            return false;
        }
        if (dcsBatDau.getDate() == null) {
            dcsBatDau.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu");
            return false;
        }
        if (dcsKetThuc.getDate() == null) {
            dcsKetThuc.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày kết thúc");
            return false;
        }
        return true;
    }

    KhuyenMaiModel getFormKhuyenMai() {
        KhuyenMaiModel km = new KhuyenMaiModel();
        km.setMaKM(txtMaKM.getText());
        km.setTenKM(txtTenKM.getText());
        km.setKieuKM(String.valueOf(cboKieuKM.getSelectedItem()));
        km.setThoiGianBatDau(dcsBatDau.getDate());
        km.setThoiGianKetThuc(dcsKetThuc.getDate());
        km.setTriGia(Double.parseDouble(txtGia.getText()));
        Date selectDateBD = dcsBatDau.getDate();
        Date selectDateKT = dcsKetThuc.getDate();
        Date currentDate = new Date();
        if (currentDate.after(selectDateKT)) {
            km.setTrangThai("Ngừng áp dụng");
        } else if (currentDate.before(selectDateBD)) {
            km.setTrangThai("Sắp diễn ra");
        } else {
            km.setTrangThai("Đang áp dụng");
        }
        return km;
    }

    void ClearForm() {
        txtMaKM.setText("");
        txtTenKM.setText("");
        cboKieuKM.setSelectedIndex(-1);
        txtGia.setText("");
        dcsBatDau.setDate(null);
        dcsKetThuc.setDate(null);
    }

    void Search() {
        this.fillTableKhuyenMai(txtTim.getText());
        this.ClearForm();
        this.rows = -1;
    }

    void insert() {
        if (checkDulieu()) {
            KhuyenMaiModel km = getFormKhuyenMai();
            try {
                dao.insert(km);
                this.fillTableKhuyenMai(null);
                this.ClearForm();
                JOptionPane.showMessageDialog(this, "Thêm mới khuyến mãi thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Thêm mới khuyến mãi thất bại!");
            }
        }
    }

    void update() {
        if (checkDulieu()) {
            KhuyenMaiModel km = getFormKhuyenMai();
            try {
                dao.update(km);
                this.fillTableKhuyenMai(null);
                this.ClearForm();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtTenKM = new javax.swing.JTextField();
        cboKieuKM = new javax.swing.JComboBox<>();
        txtGia = new javax.swing.JTextField();
        dcsBatDau = new com.toedter.calendar.JDateChooser();
        dcsKetThuc = new com.toedter.calendar.JDateChooser();
        btnThemKhuyenMai = new javax.swing.JButton();
        btnCapNhatKhuyenMai = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtTimSanPham = new javax.swing.JTextField();
        ckbTatCa = new javax.swing.JCheckBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnPrev1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnFirst1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1272, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/acerstore/app/icon/sale (2).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã khuyến mãi: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên khuyến mãi: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Thời gian kết thúc: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Kiểu khuyến mãi: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Thời gian bắt đầu: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Trị giá: ");

        cboKieuKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm theo %", "Giảm theo số tiền" }));
        cboKieuKM.setSelectedIndex(-1);

        btnThemKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemKhuyenMai.setText("Thêm");
        btnThemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhuyenMaiActionPerformed(evt);
            }
        });

        btnCapNhatKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCapNhatKhuyenMai.setText("Cập nhật");
        btnCapNhatKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatKhuyenMaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcsBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(dcsKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(btnThemKhuyenMai)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCapNhatKhuyenMai))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboKieuKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboKieuKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(dcsBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(dcsKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKhuyenMai)
                    .addComponent(btnCapNhatKhuyenMai))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Tìm sản phẩm: ");

        txtTimSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimSanPhamActionPerformed(evt);
            }
        });
        txtTimSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimSanPhamKeyReleased(evt);
            }
        });

        ckbTatCa.setText("Tất cả");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Giá ", "Số lượng", "Trạng thái"
            }
        ));
        jScrollPane6.setViewportView(tblSanPham);

        btnPrev1.setText("<-");
        btnPrev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev1ActionPerformed(evt);
            }
        });

        btnNext1.setText("->");
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        btnFirst1.setText("<<");
        btnFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst1ActionPerformed(evt);
            }
        });

        btnLast1.setText(">>");
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ckbTatCa)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFirst1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(ckbTatCa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Tìm khuyến mãi: ");

        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKeyReleased(evt);
            }
        });

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên KM", "Kiểu KM", "Trị giá", "Bắt đầu", "Kết thúc", "Trạng thái"
            }
        ));
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tblKhuyenMai);

        btnPrev.setText("<-");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText("->");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnFirst.setText("<<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnLast.setText(">>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhuyenMaiActionPerformed
        // TODO add your handling code here:
        this.insert();
    }//GEN-LAST:event_btnThemKhuyenMaiActionPerformed

    private void btnCapNhatKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatKhuyenMaiActionPerformed
        // TODO add your handling code here:
        this.update();
    }//GEN-LAST:event_btnCapNhatKhuyenMaiActionPerformed

    private void txtTimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyReleased
        // TODO add your handling code here:
        this.Search();
    }//GEN-LAST:event_txtTimKeyReleased

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void tblKhuyenMaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.rows = tblKhuyenMai.rowAtPoint(evt.getPoint());
            edit();
        }
    }//GEN-LAST:event_tblKhuyenMaiMousePressed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtTimSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimSanPhamActionPerformed

    private void btnPrev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev1ActionPerformed
        // TODO add your handling code here:
//        prev1();
    }//GEN-LAST:event_btnPrev1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
//        next1();
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        // TODO add your handling code here:
//        first1();
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        // TODO add your handling code here:
//        last1();
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void txtTimSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimSanPhamKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimSanPhamKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatKhuyenMai;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnPrev1;
    private javax.swing.JButton btnThemKhuyenMai;
    private javax.swing.JComboBox<String> cboKieuKM;
    private javax.swing.JCheckBox ckbTatCa;
    private com.toedter.calendar.JDateChooser dcsBatDau;
    private com.toedter.calendar.JDateChooser dcsKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTimSanPham;
    // End of variables declaration//GEN-END:variables
}
