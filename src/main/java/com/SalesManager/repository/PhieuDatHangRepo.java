
package com.SalesManager.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.SalesManager.Entity.PhieuDatHangEntity;
import com.SalesManager.RowMapper.PhieuDatHangMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PhieuDatHangRepo implements CrudRepository<PhieuDatHangEntity> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(PhieuDatHangEntity Object) {
        Date Date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        String sql = "INSERT INTO sales_manager_db.phieu_dat_hang (MA_PHIEU_DH, MA_NV, NGAY_GIO_DAT, NGAY_GIO_GIAO, TONG_TIEN, TRANG_THAI) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                Object.getMaPhieuDatHang(),
                Object.getMaNhanVien(),
                sdf.format(Object.getNgayGioDat()),
                sdf.format(Object.getNgayGioGiao()),
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
        String sql = "SELECT * FROM phieu_dat_hang where MA_PHIEU_DH = ?";
        return jdbcTemplate.queryForObject(sql, new PhieuDatHangMapper(), id);
    }

    @Override
    public List<PhieuDatHangEntity> findAll() {
        String sql = "SELECT * FROM phieu_dat_hang";
        return jdbcTemplate.query(sql, new PhieuDatHangMapper());
    }

    public List<PhieuDatHangEntity> findByStatus(int status) {
        String sql = "SELECT * FROM phieu_dat_hang where TRANG_THAI = ?";
        return jdbcTemplate.query(sql, new PhieuDatHangMapper(), status);
    }

    public int updateStatus(long maPhieuDatHang, int status) {
        String sql = "UPDATE phieu_dat_hang SET TRANG_THAI = ? WHERE (MA_PHIEU_DH = ?)";
        return jdbcTemplate.update(sql, status, maPhieuDatHang);
    }

}