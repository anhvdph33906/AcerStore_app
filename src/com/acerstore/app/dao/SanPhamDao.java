package com.acerstore.app.dao;
import com.acerstore.app.database.DBConnect;
import com.acerstore.app.model.SanPham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SanPhamDAO extends AcerDAO<SanPham, String> {
    String SELECT_ALL_SQL = "SELECT MaSP, TenSP FROM SanPham";

    @Override
    public void insert(SanPham e) {

    }

    @Override
    public void update(SanPham e) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<SanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SanPham selectById(String id) {
        return null;
    }

    @Override
    public List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> lstSanPham = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            while(rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                lstSanPham.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstSanPham;
    }
}
