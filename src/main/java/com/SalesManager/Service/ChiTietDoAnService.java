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
    @Autowired
    private DoAnKemService doAnKemService;

    public int save(ChiTietDoAnEntity Object) {
        return chiTietDoAnRepo.save(Object);
    }
    public List<ChiTietDoAnEntity> findByMaPhieuDH(long maPhieuDatHang) {
        List<ChiTietDoAnEntity> lsCtda = chiTietDoAnRepo.findByMaPhieuDH(maPhieuDatHang);
        for (int i = 0; i < lsCtda.size(); i++)
            lsCtda.get(i).setDoAnKem(doAnKemService.findById(lsCtda.get(i).getMaDoAn()));
        return lsCtda;
    }
    public ChiTietDoAnEntity findById(long id) {
        ChiTietDoAnEntity ctda = chiTietDoAnRepo.findById(id);
        ctda.setDoAnKem(doAnKemService.findById(ctda.getMaDoAn()));
        return ctda;
    }

    public List<ChiTietDoAnEntity> findAll() {
        return chiTietDoAnRepo.findAll();
    }
}
