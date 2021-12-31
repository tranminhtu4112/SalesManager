
package com.SalesManager.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SalesManager.Entity.ChiTietDoAnEntity;

import org.springframework.jdbc.core.RowMapper;

public class ChiTietDoAnMapper implements RowMapper<ChiTietDoAnEntity>{

    @Override
    public ChiTietDoAnEntity mapRow(ResultSet rs, int index) throws SQLException {
       ChiTietDoAnEntity chiTietDoAnEntity = new ChiTietDoAnEntity();
       chiTietDoAnEntity.setMaPhieuDatHang(rs.getLong(1));
       chiTietDoAnEntity.setMaDoAn(rs.getLong(2));
       chiTietDoAnEntity.setDonGia(rs.getDouble(3));
       chiTietDoAnEntity.setSoLuong(rs.getInt(4));
       chiTietDoAnEntity.setThanhTien(rs.getDouble(5));;
        return chiTietDoAnEntity;
    }
    
}