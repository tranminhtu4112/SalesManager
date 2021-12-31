package com.SalesManager.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SalesManager.Entity.NhanVienEntity;

import org.springframework.jdbc.core.RowMapper;

public class NhanVienMapper implements RowMapper<NhanVienEntity>{

    @Override
    public NhanVienEntity mapRow(ResultSet rs, int index) throws SQLException {
        NhanVienEntity nhanVienEntity = new NhanVienEntity();
        nhanVienEntity.setMaNhanVien(rs.getLong(1));
        nhanVienEntity.setHoTen(rs.getString(2));
        nhanVienEntity.setDiaChi(rs.getString(3));
        nhanVienEntity.setSoDienThoai(rs.getString(4));
        nhanVienEntity.setEmail(rs.getString(5));
        nhanVienEntity.setGioiTinh(rs.getInt(6));
        nhanVienEntity.setPassword(rs.getString(7));
        nhanVienEntity.setHinhAnh(rs.getString(8));
        return nhanVienEntity;
    }
    
}
