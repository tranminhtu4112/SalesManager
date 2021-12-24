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
            // TODO Auto-generated method stub
            return 0;
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
            // TODO Auto-generated method stub
            return null;
      }

      @Override
      public List<DanhMucDoAnEntity> findAll() {
            String sql = "SELECT * FROM sales_manager_db.danh_muc_do_an";
            return jdbcTemplate.query(sql, new DanhMucDoAnMapper());
      }

}
