/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acerstore.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 *
 * @author PC
 */
public class DangNhap extends javax.swing.JFrame {

    /**
     * Creates new form DangNhap
     */
    public DangNhap() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLeft = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        lblExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        lblExit.setBackground(new java.awt.Color(255, 255, 255));
        lblExit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setText("X");
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRightLayout.createSequentialGroup()
                .addGap(0, 379, Short.MAX_VALUE)
                .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        this.setSize(920, 440);
        this.setLocationRelativeTo(null);
        this.add(pnlContainer);
        pnlContainer.setSize(getWidth(), getHeight());
        pnlContainer.setBackground(new Color(255, 255, 255));
        pnlLeft.setBackground(new Color(255, 255, 255));
        pnlRight.setBackground(new Color(21, 110, 71));

        pack();
        setImage();
        titleForm();
        userName();
        passWord();
        savePassword();
        rules();
        forgetPassword();
        exitForm();
        logIn();
        support();
    }// </editor-fold>//GEN-END:initComponents

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }
    JPanel pnlContainer = new JPanel();
    JLabel lblUserName = new JLabel();
    JLabel lblDangNhap = new JLabel();
    JLabel lblLoiChao = new JLabel();
    JLabel lblImageUS = new JLabel();
    JLabel lblImagePW_show = new JLabel();
    JLabel lblImagePW_hide = new JLabel();
    JLabel lblPassWord = new JLabel();
    JLabel lblForgetPassword = new JLabel();
    JLabel lblRules = new JLabel();
    JLabel lblRules_ = new JLabel();
    JLabel lblHoTro = new JLabel();
    JLabel lblMe = new JLabel();
    JTextField txtUserName = new JTextField();
    JPasswordField txtPassWord = new JPasswordField();
    JCheckBox chkSavePassword = new JCheckBox();
    JButton btnLogin = new JButton();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblImage;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    // End of variables declaration//GEN-END:variables

    private void titleForm() {
        lblDangNhap.setText("Đăng nhập");
        lblDangNhap.setSize(200, 45);
        lblDangNhap.setLocation(120, 40);
        lblDangNhap.setForeground(new Color(255, 255, 255));
        lblDangNhap.setFont(new Font("Segoe UI", 0, 32));
        lblLoiChao.setText("Xin chào! Bắt đầu nào");
        lblLoiChao.setSize(120, 20);
        lblLoiChao.setLocation(137, 87);
        lblLoiChao.setForeground(new Color(255, 255, 255));
        lblLoiChao.setFont(new Font("Segoe UI", 0, 13));
        pnlRight.add(lblDangNhap);
        pnlRight.add(lblLoiChao);
    }

    private void userName() {
        //Label
        lblUserName.setText("Tên tài khoản");
        lblUserName.setSize(75, 18);
        lblUserName.setLocation(30, 120);
        lblUserName.setForeground(new Color(255, 255, 255));
        lblUserName.setFont(new Font("Segoe UI", 0, 13));
        
        //TextField
        txtUserName.setSize(300, 30);
        txtUserName.setLocation(35, 145);
        txtUserName.setBackground(new Color(0, 0, 0, 0));
        txtUserName.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
        txtUserName.setForeground(new Color(255, 255, 255));
        txtUserName.setSelectionColor(new Color(255, 255, 255));
        txtUserName.setSelectedTextColor(pnlRight.getBackground());
        txtUserName.setFont(new Font("Segoe UI", 0, 14));
        
        //Ico
        lblImageUS.setSize(24, 24);
        lblImageUS.setLocation(360, 155);
        
        //Show
        pnlRight.add(lblUserName);
        pnlRight.add(txtUserName);
        pnlRight.add(lblImageUS);
    }

    private void passWord() {
        //Label
        lblPassWord.setText("Mật khẩu");
        lblPassWord.setSize(65, 18);
        lblPassWord.setLocation(30, 190);
        lblPassWord.setForeground(new Color(255, 255, 255));
        lblPassWord.setFont(new Font("Segoe UI", 0, 13));

        //PasswordField
        txtPassWord.setSize(300, 30);
        txtPassWord.setLocation(35, 215);
        txtPassWord.setBackground(new Color(0, 0, 0, 0));
        txtPassWord.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
        txtPassWord.setForeground(new Color(255, 255, 255));
        txtPassWord.setFont(new Font("Segoe UI", 0, 14));
        txtPassWord.setSelectionColor(new Color(255, 255, 255));
        txtPassWord.setSelectedTextColor(pnlRight.getBackground());
        txtPassWord.setEchoChar((char) 8226);

        //Mouse click
        lblImagePW_show.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPassword(e);
            }
        });

        lblImagePW_hide.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hidePassword(e);
            }
        });

        //Ico
        lblImagePW_hide.setSize(24, 24);
        lblImagePW_hide.setLocation(360, 225);
        lblImagePW_show.setSize(24, 24);
        lblImagePW_show.setLocation(360, 225);
        lblImagePW_show.setEnabled(false);

        //Show
        pnlRight.add(lblPassWord);
        pnlRight.add(txtPassWord);
        pnlRight.add(lblImagePW_hide);
        pnlRight.add(lblImagePW_show);
    }

    private void exitForm() {
        lblExit.setOpaque(true);
        lblExit.setBackground(pnlRight.getBackground());
        lblExit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                lblExit.setBackground(new Color(255, 255, 255));
                lblExit.setForeground(pnlRight.getBackground());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblExit.setBackground(pnlRight.getBackground());
                lblExit.setForeground(new Color(255, 255, 255));
            }
        });
    }

    private void rules() {
        String text = "Việc bạn sử dụng ứng dụng này đồng nghĩa bạn đồng ý với";
        String text_ = "điều khoản sử dụng của chúng tôi.";
        lblRules.setText(text);
        lblRules_.setText(text_);
        lblRules.setFont(new Font("Segoe UI", 0, 11));
        lblRules_.setFont(new Font("Segoe UI", 0, 11));
        lblRules.setSize(350, 20);
        lblRules_.setSize(200, 20);
        lblRules.setForeground(pnlRight.getBackground());
        lblRules_.setForeground(pnlRight.getBackground());
        lblRules.setLocation(95, 350);
        lblRules_.setLocation(150, 370);
        pnlLeft.add(lblRules);
        pnlLeft.add(lblRules_);
    }

    private void forgetPassword() {
        lblForgetPassword.setText("Quên mật khẩu?");
        lblForgetPassword.setSize(140, 50);
        lblForgetPassword.setLocation(300, 252);
        lblForgetPassword.setForeground(Color.decode("#d1fae5"));
        pnlRight.add(lblForgetPassword);
        lblForgetPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                forgetPasswordClick(e);
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblForgetPassword.setForeground(Color.decode("#ffffff"));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblForgetPassword.setForeground(Color.decode("#d1fae5"));
                super.mouseExited(e);
            }
        });
    }

    private void savePassword() {
        chkSavePassword.setText("Nhớ mật khẩu");
        chkSavePassword.setSize(140, 22);
        chkSavePassword.setLocation(35, 265);
        chkSavePassword.setForeground(Color.decode("#d1fae5"));
        pnlRight.add(chkSavePassword);
    }

    private void setImage() {
        URL url = getClass().getResource("/com/acerstore/app/icon/Login.png");
        URL url1 = getClass().getResource("/com/acerstore/app/icon/female_user_24px.png");
        URL url2 = getClass().getResource("/com/acerstore/app/icon/eye_24px.png");
        URL url3 = getClass().getResource("/com/acerstore/app/icon/invisible_24px.png");
        lblImage.setIcon(new ImageIcon(url));
        lblImageUS.setIcon(new ImageIcon(url1));
        lblImagePW_show.setIcon(new ImageIcon(url2));
        lblImagePW_hide.setIcon(new ImageIcon(url3));
    }

    private void hidePassword(java.awt.event.MouseEvent evt) {
        txtPassWord.setEchoChar((char) 0);
        lblImagePW_hide.setVisible(false);
        lblImagePW_hide.setEnabled(false);
        lblImagePW_show.setEnabled(true);
    }

    private void showPassword(java.awt.event.MouseEvent evt) {
        txtPassWord.setEchoChar((char) 8226);
        lblImagePW_hide.setVisible(true);
        lblImagePW_hide.setEnabled(true);
        lblImagePW_show.setEnabled(false);
    }

    private void logIn() {
        btnLogin.setText("ĐĂNG NHẬP");
        btnLogin.setSize(350, 40);
        btnLogin.setLocation(35, 310);
        btnLogin.setFont(new Font("Segoe UI", 1, 14));
        btnLogin.setForeground(pnlRight.getBackground());
        btnLogin.setBackground(new Color(255, 255, 255));
//      btnLogin.setBorder(new LineBorder(Color.WHITE));
        pnlRight.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logInActionPerformed(e);
            }
        });
    }

    private void logInActionPerformed(java.awt.event.ActionEvent evt) {
        check();
    }

    private void support() {
        lblHoTro.setText("Liên hệ bộ phận hỗ trợ?");
        lblHoTro.setSize(125, 20);
        lblHoTro.setLocation(120, 360);
        lblHoTro.setForeground(Color.decode("#d1fae5"));
        pnlRight.add(lblHoTro);

        lblMe.setText("Tại đây");
        lblMe.setSize(100, 20);
        lblMe.setLocation(245, 360);
        lblMe.setForeground(Color.decode("#ffffff"));
        pnlRight.add(lblMe);

        //Click
        lblMe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                supportClick(e);
                super.mouseClicked(e);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblMe.setForeground(Color.decode("#d1fae5"));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblMe.setForeground(Color.decode("#ffffff"));
                super.mouseExited(e);
            }
        });
    }

    private void supportClick(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(this, "Tính năng đang phát triển");
    }

    private void forgetPasswordClick(java.awt.event.MouseEvent evt) {
        String paragraph = "Vui lòng liên hệ bộ phận hỗ trợ để được xử lý vấn đề này. Xin cảm ơn!"
                + "\n                                Hotline: 1234.5678.900";
        JOptionPane.showMessageDialog(this, paragraph);
    }

    private void check() {
        String user = txtUserName.getText();
        String pass = String.copyValueOf(txtPassWord.getPassword());
        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không đươợc phép bỏ trống tên đăng nhập");
            txtUserName.requestFocus();
        } else if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được phép bỏ trống mật khẩu");
            txtPassWord.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
        }
    }
}
