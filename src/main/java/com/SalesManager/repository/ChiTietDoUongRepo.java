
package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.ChiTietGoiNuocEntity;
import com.SalesManager.RowMapper.ChiTietDoUongMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChiTietDoUongRepo implements CrudRepository<ChiTietGoiNuocEntity> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(ChiTietGoiNuocEntity Object) {
        String sql = "INSERT INTO sales_manager_db.chi_tiet_goi_nuoc (MA_PHIEU_DH, MA_NUOC, DON_GIA, SO_LUONG, THANH_TIEN) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, Object.getMaPhieuDatHang(),
                Object.getMaNuoc(),
                Object.getDioGia(),
                Object.getSoLuong(),
                Object.getThanhTien());
    }

    @Override
    public int update(ChiTietGoiNuocEntity Object) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ChiTietGoiNuocEntity findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<ChiTietGoiNuocEntity> findByMaPhieuDH(long maPhieuDatHhang) {
        String sql = "SELECT * FROM chi_tiet_goi_nuoc where MA_PHIEU_DH = ?";
        return jdbcTemplate.query(sql, new ChiTietDoUongMapper(), maPhieuDatHhang);
    }

    @Override
    public List<ChiTietGoiNuocEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}