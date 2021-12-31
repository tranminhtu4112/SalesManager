package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.NhanVienEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class NhanVienRepo implements CrudRepository<NhanVienEntity>{
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<NhanVienEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
