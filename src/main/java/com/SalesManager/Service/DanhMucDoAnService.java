package com.SalesManager.Service;

import com.SalesManager.Entity.DanhMucDoAnEntity;
import com.SalesManager.repository.DanhMucDoAnRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DanhMucDoAnService {

    @Autowired
    private DanhMucDoAnRepo danhMucDoAnRepo;

    public int save(DanhMucDoAnEntity Object) {
        return danhMucDoAnRepo.save(Object);
    }
}
