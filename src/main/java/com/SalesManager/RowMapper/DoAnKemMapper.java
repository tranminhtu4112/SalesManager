package com.SalesManager.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SalesManager.Entity.DoAnKemEntity;

import org.springframework.jdbc.core.RowMapper;

public class DoAnKemMapper implements RowMapper<DoAnKemEntity>{

      @Override
      public DoAnKemEntity mapRow(ResultSet rs, int index) throws SQLException {
            DoAnKemEntity doAnKemEntity = new DoAnKemEntity();
            doAnKemEntity.setMaDoAn(rs.getLong(1));
            doAnKemEntity.setMaDanhMucDoAn(rs.getLong(2));
            doAnKemEntity.setTenDoAn(rs.getString(3));
            doAnKemEntity.setDonGia(rs.getLong(4));
            doAnKemEntity.setDonViTinh(rs.getString(5));
            doAnKemEntity.setSoLuongTon(rs.getInt(6));
            doAnKemEntity.setHinhAnh(rs.getString(7));
            return doAnKemEntity;
      }

}
