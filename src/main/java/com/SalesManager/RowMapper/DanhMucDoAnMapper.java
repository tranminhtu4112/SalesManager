package com.SalesManager.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SalesManager.Entity.DanhMucDoAnEntity;

import org.springframework.jdbc.core.RowMapper;

public class DanhMucDoAnMapper implements RowMapper<DanhMucDoAnEntity>{

      @Override
      public DanhMucDoAnEntity mapRow(ResultSet rs, int index) throws SQLException {
            DanhMucDoAnEntity danhMucDoAn = new DanhMucDoAnEntity();
            danhMucDoAn.setMaDanhMucDoAn(rs.getLong(1));
            danhMucDoAn.setTenDanhMuc(rs.getString(2));
            return danhMucDoAn;
      }

}
