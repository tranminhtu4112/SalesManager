package com.SalesManager.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SalesManager.Entity.DanhMucNuocUongEntity;

import org.springframework.jdbc.core.RowMapper;

public class DanhMucDoUongMapper implements RowMapper<DanhMucNuocUongEntity>{

    @Override
    public DanhMucNuocUongEntity mapRow(ResultSet rs, int index) throws SQLException {
        DanhMucNuocUongEntity danhMucNuocUong = new DanhMucNuocUongEntity();
        danhMucNuocUong.setMaDanhMucNuoc(rs.getLong(1));
        danhMucNuocUong.setTenDanhMuc(rs.getString(2));
        return danhMucNuocUong;
  }
    
}
