/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import com.acerstore.app.controller.DBConnect;
import com.acerstore.app.model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDAO extends AcerDAO<NhanVien, String>{
    
    String INSERT_SQL = "INSERT INTO NhanVien(MaNV, Ten, MatKhau, SoDT, VaiTro) VALUES(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien SET Ten=?, MatKhau=?, SoDT=?, VaiTro = ? WHERE MaNV=?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV=?";

    @Override
    public void insert(NhanVien entity) {
        DBConnect.executeUpdate(INSERT_SQL, entity.getMaNV(), entity.getTen(), entity.getMatKhau(), entity.getSoDienThoai(), entity.isVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        DBConnect.executeUpdate(UPDATE_SQL, entity.getTen(), entity.getMatKhau(), entity.getSoDienThoai(), entity.isVaiTro(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        DBConnect.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTen(rs.getString("Ten"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setSoDienThoai(rs.getInt("SoDT"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
