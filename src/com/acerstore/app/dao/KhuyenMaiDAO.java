/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import com.acerstore.app.controller.DBConnect;
import com.acerstore.app.model.KhuyenMai;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhuyenMaiDAO extends AcerDAO<KhuyenMai, String>{
    
    final String INSERT_SQL = "insert into Khuyenmai(MaKM, TenKM, KieuKM, TriGia, TGBD, TGKT, TrangThai) values (?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "update KhuyenMai set TenKM = ?, KieuKM = ?, TriGia = ?, TGBD = ?, TGKT = ?, TrangThai = ? where MaKM = ?";
    final String SELECT_ALL_SQL = "select * from KhuyenMai";
    final String SELECT_BY_ID_SQL = "select * from KhuyenMai where MaKM = ?";

    @Override
    public void insert(KhuyenMai entity) {
        DBConnect.executeUpdate(INSERT_SQL, entity.getMaKM(), entity.getTenKM(), entity.getKieuKM(), entity.getTriGia(), entity.getThoiGianBatDau(), entity.getThoiGianKetThuc(), entity.isTrangThai());
    }

    @Override
    public void update(KhuyenMai entity) {
        DBConnect.executeUpdate(UPDATE_SQL, entity.getTenKM(), entity.getKieuKM(), entity.getTriGia(), entity.getThoiGianBatDau(), entity.getThoiGianKetThuc(), entity.isTrangThai(), entity.getMaKM());
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhuyenMai> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhuyenMai selectById(String id) {
        List<KhuyenMai> list = selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList();
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            while(rs.next()){
                KhuyenMai entity = new KhuyenMai();
                entity.setMaKM(rs.getString("MaKM"));
                entity.setTenKM(rs.getString("TenKM"));
                entity.setKieuKM(rs.getString("KieuKM"));
                entity.setTriGia(rs.getDouble("TriGia"));
                entity.setThoiGianBatDau(rs.getDate("TGBD"));
                entity.setThoiGianKetThuc(rs.getDate("TGKT"));
                entity.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }  
}
