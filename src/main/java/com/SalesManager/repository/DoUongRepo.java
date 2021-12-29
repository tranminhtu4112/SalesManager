package com.SalesManager.repository;

import java.util.List;

import com.SalesManager.Entity.NuocUongEntity;
import com.SalesManager.RowMapper.DoUongMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DoUongRepo implements CrudRepository<NuocUongEntity>{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int save(NuocUongEntity Object) {
        String sql = "INSERT INTO sales_manager_db.nuoc_uong (MA_DM_NUOC, TEN_NUOC_UONG, DON_GIA, DON_VI_TINH, SO_LUONG_TON, HINH_ANH) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, Object.getDanhMucNuocUong(),
                Object.getTenNuocUong(),
                Object.getDonGia(),
                Object.getDonViTinh(),
                Object.getSoLuongTon(),
                Object.getHinhAnh());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int update(NuocUongEntity Object) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public NuocUongEntity findById(long id) {
        String sql = "SELECT * FROM nuoc_uong where MA_NUOC = ?";
        return jdbcTemplate.queryForObject(sql, new DoUongMapper(), id);
    }

    @Override
    public List<NuocUongEntity> findAll() {
        String sql = "SELECT * FROM nuoc_uong";
        return jdbcTemplate.query(sql, new DoUongMapper());
    }
    
}
