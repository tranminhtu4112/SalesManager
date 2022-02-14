package com.SalesManager.Service;

import com.SalesManager.Entity.DanhMucNuocUongEntity;
import com.SalesManager.repository.DanhMucDoUongRepo;

import org.springframework.stereotype.Service;

@Service
public class DanhMucDoUongService {

    private DanhMucDoUongRepo danhMucDoUongRepo;

    public int save(DanhMucNuocUongEntity Object) {
        return danhMucDoUongRepo.save(Object);
    }
}
