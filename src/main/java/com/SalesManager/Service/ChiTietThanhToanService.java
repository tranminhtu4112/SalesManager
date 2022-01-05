package com.SalesManager.Service;

import java.util.List;

import com.SalesManager.Entity.ChiTietThanhToanEntity;
import com.SalesManager.repository.ChiTietThanhToanRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietThanhToanService {

    @Autowired
    private ChiTietThanhToanRepo chiTietThanhToanRepo;

    public int save(ChiTietThanhToanEntity Object) {
        return chiTietThanhToanRepo.save(Object);
    }

    public ChiTietThanhToanEntity findByMaPhieuDH(long maPhieuDatHang) {
        return chiTietThanhToanRepo.findByMaPhieuDH(maPhieuDatHang);
    }
}
