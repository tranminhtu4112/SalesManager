package com.SalesManager.Service;

import java.util.List;

import com.SalesManager.Entity.PhieuDatHangEntity;
import com.SalesManager.repository.PhieuDatHangRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhieuDatHangService {

    @Autowired
    private PhieuDatHangRepo phieuDatHangRepo;

    public int save(PhieuDatHangEntity Object) {
        return phieuDatHangRepo.save(Object);
    }
    public PhieuDatHangEntity findById(long maPhieuDatHang) {
        return phieuDatHangRepo.findById(maPhieuDatHang);
    }

    public List<PhieuDatHangEntity> findAll() {
        return phieuDatHangRepo.findAll();
    }

    public List<PhieuDatHangEntity> findByStatus(int status) {
        return phieuDatHangRepo.findByStatus(status);
    }
}
