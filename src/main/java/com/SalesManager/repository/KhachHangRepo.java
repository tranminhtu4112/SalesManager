package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.KhachHangEntity;
import com.SalesManager.RowMapper.KhachHangMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class KhachHangRepo implements CrudRepository<KhachHangEntity> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(KhachHangEntity Object) {
        String sql = "INSERT INTO khach_hang (HO_TEN, DIA_CHI, SO_DIEN_THOAI, EMAIL) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                Object.getHoTen(),
                Object.getDiaChi(),
                Object.getSoDienThoai(),
                Object.getEmail());
    }

    @Override
    public int update(KhachHangEntity Object) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public KhachHangEntity findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<KhachHangEntity> findAll() {
        String sql = "SELECT * FROM khach_hang";
        return jdbcTemplate.query(sql, new KhachHangMapper());
    }

    public List<KhachHangEntity> findByTenKhachHang(String soDienThoai) {
        String sql = "SELECT * FROM khach_hang where SO_DIEN_THOAI like ?;";
        return jdbcTemplate.query(sql, new KhachHangMapper(), soDienThoai + "%");
    }

}
