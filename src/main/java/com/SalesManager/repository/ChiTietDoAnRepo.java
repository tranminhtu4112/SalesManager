
package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.ChiTietDoAnEntity;
import com.SalesManager.RowMapper.ChiTietDoAnMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChiTietDoAnRepo implements CrudRepository<ChiTietDoAnEntity> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(ChiTietDoAnEntity Object) {
        String sql = "INSERT INTO sales_manager_db.chi_tiet_do_an (MA_PHIEU_DH, MA_DO_AN,DON_GIA, SO_LUONG, THANH_TIEN) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, Object.getMaPhieuDatHang(),
                Object.getMaDoAn(),
                Object.getDonGia(),
                Object.getSoLuong(),
                Object.getThanhTien());
    }

    @Override
    public int update(ChiTietDoAnEntity Object) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ChiTietDoAnEntity findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<ChiTietDoAnEntity> findByMaPhieuDH(long maPhieuDatHang) {
        String sql = "SELECT * FROM chi_tiet_do_an where MA_PHIEU_DH = ?";
        return jdbcTemplate.query(sql, new ChiTietDoAnMapper(), maPhieuDatHang);
    }

    @Override
    public List<ChiTietDoAnEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}