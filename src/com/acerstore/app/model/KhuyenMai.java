/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhuyenMai {
    private String maKM, tenKM;
    private Date thoiGianBatDau, thoiGianKetThuc;
    private double triGia;
    private String kieuKM;
    private boolean trangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, Date thoiGianBatDau, Date thoiGianKetThuc, double triGia, String kieuKM, boolean trangThai) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.triGia = triGia;
        this.kieuKM = kieuKM;
        this.trangThai = trangThai;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public double getTriGia() {
        return triGia;
    }

    public void setTriGia(double triGia) {
        this.triGia = triGia;
    }

    public String getKieuKM() {
        return kieuKM;
    }

    public void setKieuKM(String kieuKM) {
        this.kieuKM = kieuKM;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "maKM=" + maKM + ", tenKM=" + tenKM + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc=" + thoiGianKetThuc + ", triGia=" + triGia + ", kieuKM=" + kieuKM + ", trangThai=" + trangThai + '}';
    }
    
}
