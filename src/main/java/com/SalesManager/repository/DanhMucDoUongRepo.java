package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.DanhMucNuocUongEntity;
import com.SalesManager.RowMapper.DanhMucDoUongMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class DanhMucDoUongRepo implements CrudRepository<DanhMucNuocUongEntity>{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(DanhMucNuocUongEntity Object) {
        // TODO Auto-generated method stub
        return 0;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int update(DanhMucNuocUongEntity Object) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public DanhMucNuocUongEntity findById(long id) {
        String sql = "SELECT * FROM danh_muc_nuoc_uong where MA_DM_NUOC = ?";
        return jdbcTemplate.queryForObject(sql, new DanhMucDoUongMapper(), id);
    }

    @Override
    public List<DanhMucNuocUongEntity> findAll() {
        String sql = "SELECT * FROM danh_muc_nuoc_uong ";
        return jdbcTemplate.query(sql, new DanhMucDoUongMapper());
    }
    
}
