
package com.SalesManager.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SalesManager.Entity.ChiTietGoiNuocEntity;

import org.springframework.jdbc.core.RowMapper;

public class ChiTietDoUongMapper implements RowMapper<ChiTietGoiNuocEntity>{

    @Override
    public ChiTietGoiNuocEntity mapRow(ResultSet rs, int index) throws SQLException {
        ChiTietGoiNuocEntity chiTietGoiNuocEntity = new ChiTietGoiNuocEntity();
        chiTietGoiNuocEntity.setMaPhieuDatHang(rs.getLong(1));
        chiTietGoiNuocEntity.setMaNuoc(rs.getLong(2));
        chiTietGoiNuocEntity.setDioGia(rs.getDouble(3));
        chiTietGoiNuocEntity.setSoLuong(rs.getInt(4));
        chiTietGoiNuocEntity.setThanhTien(rs.getDouble(5));
        return chiTietGoiNuocEntity;
    }
    
}