
package com.SalesManager.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SalesManager.Entity.ChiTietThanhToanEntity;

import org.springframework.jdbc.core.RowMapper;

public class ChiTietThanhToanMapper implements RowMapper<ChiTietThanhToanEntity>{

    @Override
    public ChiTietThanhToanEntity mapRow(ResultSet rs, int index) throws SQLException {
        ChiTietThanhToanEntity chiTietThanhToanEntity = new ChiTietThanhToanEntity();
        chiTietThanhToanEntity.setMaKhachHang(rs.getLong(1));
        chiTietThanhToanEntity.setMaPhieuDatHang(rs.getLong(2));
        chiTietThanhToanEntity.setThoiDiemThanhToan(rs.getDate(3));
        return chiTietThanhToanEntity;
    }
    
}