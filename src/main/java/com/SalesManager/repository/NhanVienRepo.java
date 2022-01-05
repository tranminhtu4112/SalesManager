package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.NhanVienEntity;
import com.SalesManager.RowMapper.NhanVienMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NhanVienRepo implements CrudRepository<NhanVienEntity> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(NhanVienEntity Object) {
        String sql = "INSERT INTO nhan_vien (HO_TEN, DIA_CHI, SO_DIEN_THOAI, EMAIL, GIOI_TINH, PASSWORD, HINHANH) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                Object.getHoTen(),
                Object.getDiaChi(),
                Object.getSoDienThoai(),
                Object.getEmail(),
                Object.getGioiTinh(),
                Object.getPassword(),
                Object.getHinhAnh());
    }

    @Override
    public int update(NhanVienEntity Object) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public NhanVienEntity findById(long id) {
        String sql = "SELECT * FROM nhan_vien where MA_NV = ?";
        return jdbcTemplate.queryForObject(sql, new NhanVienMapper(), id);
    }

    @Override
    public List<NhanVienEntity> findAll() {
        String sql = "SELECT * FROM nhan_vien";
        return jdbcTemplate.query(sql, new NhanVienMapper());
    }

    public NhanVienEntity findBySoDienThoai(String sdt) {
        String sql = "SELECT * FROM nhan_vien where SO_DIEN_THOAI = ?";
        return jdbcTemplate.queryForObject(sql, new NhanVienMapper(), sdt);
    }
}
