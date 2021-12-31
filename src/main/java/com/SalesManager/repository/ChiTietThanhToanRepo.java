
package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.ChiTietThanhToanEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class ChiTietThanhToanRepo implements CrudRepository<ChiTietThanhToanEntity>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(ChiTietThanhToanEntity Object) {
        String sql = "INSERT INTO sales_manager_db.chi_tiet_thanh_toan (MA_KH, MA_PHIEU_DH,THOI_DIEM_TT) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, Object.getMaKhachHang(),
                Object.getMaPhieuDatHang(),
                Object.getThoiDiemThanhToan());
    }

    @Override
    public int update(ChiTietThanhToanEntity Object) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ChiTietThanhToanEntity findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ChiTietThanhToanEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}