package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.DoAnKemEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DoAnKemRepo implements CrudRepository<DoAnKemEntity> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(DoAnKemEntity object) {
        String sql = "INSERT INTO sales_manager_db.do_an_kem (MA_DM_DO_AN, TEN_DO_AN, DON_GIA, DON_VI_TINH, SO_LUONG_TON) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, object.getMaDanhMucDoAn(),
                object.getTenDoAn(),
                object.getDonGia(),
                object.getDonViTinh(),
                object.getSoLuongTon());
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DoAnKemEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
