package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.DanhMucDoAnEntity;
import com.SalesManager.RowMapper.DanhMucDoAnMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DanhMucDoAnRepo implements CrudRepository<DanhMucDoAnEntity>{

      @Autowired
      private JdbcTemplate jdbcTemplate;

      @Override
      public int save(DanhMucDoAnEntity Object) {
            String sql = "INSERT INTO danh_muc_do_an (TEN_DM) VALUES (?)";
            return jdbcTemplate.update(sql, Object.getTenDanhMuc());
      }

      @Override
      public int update(DanhMucDoAnEntity Object) {
            // TODO Auto-generated method stub
            return 0;
      }

      @Override
      public int delete(long id) {
            // TODO Auto-generated method stub
            return 0;
      }

      @Override
      public DanhMucDoAnEntity findById(long id) {
            String sql = "SELECT * FROM danh_muc_do_an where MA_DM_DO_AN = ?";
            return jdbcTemplate.queryForObject(sql, new DanhMucDoAnMapper(), id);
      }

      @Override
      public List<DanhMucDoAnEntity> findAll() {
            String sql = "SELECT * FROM danh_muc_do_an";
            return jdbcTemplate.query(sql, new DanhMucDoAnMapper());
      }

}
