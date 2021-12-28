package com.SalesManager.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import com.SalesManager.Entity.DoAnKemEntity;
import com.SalesManager.RowMapper.DoAnKemMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DoAnKemRepo implements CrudRepository<DoAnKemEntity> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(DoAnKemEntity object) {
        String sql = "INSERT INTO sales_manager_db.do_an_kem (MA_DM_DO_AN, TEN_DO_AN, DON_GIA, DON_VI_TINH, SO_LUONG_TON, HINH_ANH) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, object.getMaDanhMucDoAn(),
                object.getTenDoAn(),
                object.getDonGia(),
                object.getDonViTinh(),
                object.getSoLuongTon(),
                object.getHinhAnh());
    }

    @Override
    public int update(DoAnKemEntity Object) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public DoAnKemEntity findById(long id) {
        String sql = "SELECT * FROM do_an_kem where MA_DO_AN = ?";
        return jdbcTemplate.queryForObject(sql, new DoAnKemMapper(), id);
    }

    @Override
    public List<DoAnKemEntity> findAll() {
        String sql = "SELECT * FROM do_an_kem";
        return jdbcTemplate.query(sql, new DoAnKemMapper());
    }
    public List<DoAnKemEntity> findByTenDoAnKem(String tenDoAnKem) {
        String sql = "SELECT * FROM do_an_kem where TEN_DO_AN like ?";
        return jdbcTemplate.query(sql, new DoAnKemMapper(), tenDoAnKem+ "%");
    }

}
