package com.SalesManager.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SalesManager.Entity.KhachHangEntity;

import org.springframework.jdbc.core.RowMapper;

public class KhachHangMapper implements RowMapper<KhachHangEntity>{

      @Override
      public KhachHangEntity mapRow(ResultSet rs, int index) throws SQLException {
            KhachHangEntity khachHang = new KhachHangEntity();
            khachHang.setMaKhachHang(rs.getLong(1));
            khachHang.setHoTen(rs.getString(2));
            khachHang.setDiaChi(rs.getString(3));
            khachHang.setSoDienThoai(rs.getString(4));
            khachHang.setEmail(rs.getString(5));
            return khachHang;
      }

}
