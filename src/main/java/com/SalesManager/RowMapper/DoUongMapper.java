package com.SalesManager.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SalesManager.Entity.NuocUongEntity;

import org.springframework.jdbc.core.RowMapper;

public class DoUongMapper implements RowMapper<NuocUongEntity>{

    @Override
    public NuocUongEntity mapRow(ResultSet rs, int index) throws SQLException {
        NuocUongEntity nuocUongEntity = new NuocUongEntity();
        nuocUongEntity.setMaNuoc(rs.getLong(1));
        nuocUongEntity.setMaDanhMucNuoc(rs.getLong(2));
        nuocUongEntity.setTenNuocUong(rs.getString(3));
        nuocUongEntity.setDonGia(rs.getLong(4));
        nuocUongEntity.setDonViTinh(rs.getString(5));
        nuocUongEntity.setSoLuongTon(rs.getInt(6));
        nuocUongEntity.setHinhAnh(rs.getString(7));
        return nuocUongEntity;
    }

    
}
