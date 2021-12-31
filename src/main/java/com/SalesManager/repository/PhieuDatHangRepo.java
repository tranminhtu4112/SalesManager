
package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.PhieuDatHangEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class PhieuDatHangRepo implements CrudRepository<PhieuDatHangEntity>{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(PhieuDatHangEntity Object) {
        String sql = "INSERT INTO sales_manager_db.phieu_dat_hang ( MA_NV, NGAY_GIO_DAT, NGAY_GIO_GIAO, TONG_TIEN, TRANG_THAI) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, Object.getMaNhanVien(),
                Object.getNgayGioDat(),
                Object.getNgayGioGiao(),
                Object.getTongTien(),
                Object.getTrangThai());
    }

    @Override
    public int update(PhieuDatHangEntity Object) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public PhieuDatHangEntity findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PhieuDatHangEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}