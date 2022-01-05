package com.SalesManager.Service;

import java.util.List;

import com.SalesManager.Entity.ChiTietDoAnEntity;
import com.SalesManager.repository.ChiTietDoAnRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietDoAnService {

    @Autowired
    private ChiTietDoAnRepo chiTietDoAnRepo;

    public int save(ChiTietDoAnEntity Object) {
        return chiTietDoAnRepo.save(Object);
    }
    public List<ChiTietDoAnEntity> findByMaPhieuDH(long maPhieuDatHang) {
        return chiTietDoAnRepo.findByMaPhieuDH(maPhieuDatHang);
    }
    public ChiTietDoAnEntity findById(long id) {
        return chiTietDoAnRepo.findById(id);
    }

    public List<ChiTietDoAnEntity> findAll() {
        return chiTietDoAnRepo.findAll();
    }
}
