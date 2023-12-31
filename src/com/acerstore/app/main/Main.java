package com.acerstore.app.main;

import com.acerstore.app.menu.MenuEvent;
import java.awt.Component;
import com.acerstore.app.view.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setForm();
        menu.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0) {
                    trangChu.setVisible(true);
                    banHang.setVisible(false);
                    hoaDon.setVisible(false);
                    khachHang.setVisible(false);
                    khuyenMai.setVisible(false);
                    nhanVien.setVisible(false);
                    sanPham.setVisible(false);
                    thongKe.setVisible(false);
                }
                if (index == 1) {
                    trangChu.setVisible(false);
                    banHang.setVisible(true);
                    hoaDon.setVisible(false);
                    khachHang.setVisible(false);
                    khuyenMai.setVisible(false);
                    nhanVien.setVisible(false);
                    sanPham.setVisible(false);
                    thongKe.setVisible(false);
                }
                if (index == 2) {
                    trangChu.setVisible(false);
                    banHang.setVisible(false);
                    hoaDon.setVisible(true);
                    khachHang.setVisible(false);
                    khuyenMai.setVisible(false);
                    nhanVien.setVisible(false);
                    sanPham.setVisible(false);
                    thongKe.setVisible(false);
                }
                if (index == 3) {
                    trangChu.setVisible(false);
                    banHang.setVisible(false);
                    hoaDon.setVisible(false);
                    khachHang.setVisible(false);
                    khuyenMai.setVisible(false);
                    nhanVien.setVisible(false);
                    sanPham.setVisible(true);
                    thongKe.setVisible(false);
                }
                if (index == 4) {
                    trangChu.setVisible(false);
                    banHang.setVisible(false);
                    hoaDon.setVisible(false);
                    khachHang.setVisible(false);
                    khuyenMai.setVisible(true);
                    nhanVien.setVisible(false);
                    sanPham.setVisible(false);
                    thongKe.setVisible(false);
                }
                if (index == 5) {
                    trangChu.setVisible(false);
                    banHang.setVisible(false);
                    hoaDon.setVisible(false);
                    khachHang.setVisible(true);
                    khuyenMai.setVisible(false);
                    nhanVien.setVisible(false);
                    sanPham.setVisible(false);
                    thongKe.setVisible(false);
                }
                if (index == 6) {
                    trangChu.setVisible(false);
                    banHang.setVisible(false);
                    hoaDon.setVisible(false);
                    khachHang.setVisible(false);
                    khuyenMai.setVisible(false);
                    nhanVien.setVisible(true);
                    sanPham.setVisible(false);
                    thongKe.setVisible(false);
                }
                if (index == 7 && subIndex == 1) {
                    trangChu.setVisible(false);
                    banHang.setVisible(false);
                    hoaDon.setVisible(false);
                    khachHang.setVisible(false);
                    khuyenMai.setVisible(false);
                    nhanVien.setVisible(false);
                    sanPham.setVisible(false);
                    thongKe.setVisible(true);
                }
                if (index == 8 && subIndex == 1) {
                    int rs = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn đăng xuất tài khoản?",
                            "Acer Store - Đăng xuất", JOptionPane.YES_NO_OPTION);
                    if (rs == JOptionPane.YES_OPTION) {
                        setVisible(false);
                        new DangNhap().setVisible(true);
                    }

                }
                if (index == 10) {
                    int exit = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thoát?",
                            "Acer Store - Thoát", JOptionPane.YES_NO_OPTION);
                    if (exit == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            }
        });
    }

    private void showForm(Component com) {
        pnlContainer.removeAll();
        pnlContainer.add(com);
        pnlContainer.repaint();
        pnlContainer.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();
        scrollPane1 = new com.acerstore.app.swing.ScrollPane();
        menu = new com.acerstore.app.menu.Menu();
        header = new com.acerstore.app.view.Header();
        pnlControl = new javax.swing.JPanel();
        trangChu = new com.acerstore.app.view.TrangChu();
        nhanVien = new com.acerstore.app.view.NhanVien();
        hoaDon = new com.acerstore.app.view.HoaDon();
        khachHang = new com.acerstore.app.view.KhachHang();
        khuyenMai = new com.acerstore.app.view.KhuyenMai();
        thongKe = new com.acerstore.app.view.ThongKe();
        banHang = new com.acerstore.app.view.BanHang();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1536, 816));

        pnlContainer.setBackground(new java.awt.Color(245, 245, 245));
        pnlContainer.setPreferredSize(new java.awt.Dimension(1536, 81));

        scrollPane1.setBorder(null);
        scrollPane1.setViewportView(menu);

        pnlControl.setBackground(new java.awt.Color(255, 255, 255));
        pnlControl.setPreferredSize(new java.awt.Dimension(1272, 757));
        pnlControl.setLayout(new java.awt.CardLayout());
        pnlControl.add(trangChu, "card9");
        pnlControl.add(nhanVien, "card4");
        pnlControl.add(hoaDon, "card5");
        pnlControl.add(khachHang, "card6");
        pnlControl.add(khuyenMai, "card7");
        pnlControl.add(thongKe, "card9");
        pnlControl.add(banHang, "card9");

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE))
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addComponent(pnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.acerstore.app.view.BanHang banHang;
    private com.acerstore.app.view.Header header;
    private com.acerstore.app.view.HoaDon hoaDon;
    private com.acerstore.app.view.KhachHang khachHang;
    private com.acerstore.app.view.KhuyenMai khuyenMai;
    private com.acerstore.app.menu.Menu menu;
    private com.acerstore.app.view.NhanVien nhanVien;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlControl;
    private com.acerstore.app.swing.ScrollPane scrollPane1;
    private com.acerstore.app.view.ThongKe thongKe;
    private com.acerstore.app.view.TrangChu trangChu;
    // End of variables declaration//GEN-END:variables

    private void setForm() {
        this.setLocationRelativeTo(null);
    }
}
