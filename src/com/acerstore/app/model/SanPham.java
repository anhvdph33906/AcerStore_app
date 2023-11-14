package com.acerstore.app.model;

import javax.management.ObjectName;

public class SanPham {
    private String maSP;
    private String tenSP;

    public SanPham() {}

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Object[] toDataRow() {
        return new Object[]{maSP, tenSP};
    }
}
