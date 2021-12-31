
package com.SalesManager.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SalesManager.Entity.PhieuDatHangEntity;

import org.springframework.jdbc.core.RowMapper;

public class PhieuDatHangMapper implements RowMapper<PhieuDatHangEntity>{

    @Override
    public PhieuDatHangEntity mapRow(ResultSet rs, int index) throws SQLException {
        PhieuDatHangEntity phieuDatHangEntity = new PhieuDatHangEntity();
        phieuDatHangEntity.setMaPhieuDatHang(rs.getLong(1));
        phieuDatHangEntity.setMaNhanVien(rs.getLong(2));
        phieuDatHangEntity.setNgayGioDat(rs.getDate(3));
        phieuDatHangEntity.setNgayGioGiao(rs.getDate(4));
        phieuDatHangEntity.setTongTien(rs.getDouble(5));
        phieuDatHangEntity.setTrangThai(rs.getInt(6));
        return phieuDatHangEntity;
    }
    
}