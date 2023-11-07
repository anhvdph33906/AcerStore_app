/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String maNV, ten, matKhau;
    private int soDienThoai;
    private boolean vaiTro;

    public NhanVien() {
    }

    public NhanVien(String maNV, String ten, String matKhau, int soDienThoai, boolean vaiTro) {
        this.maNV = maNV;
        this.ten = ten;
        this.matKhau = matKhau;
        this.soDienThoai = soDienThoai;
        this.vaiTro = vaiTro;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", ten=" + ten + ", matKhau=" + matKhau + ", soDienThoai=" + soDienThoai + ", vaiTro=" + vaiTro + '}';
    }
    
    
}
