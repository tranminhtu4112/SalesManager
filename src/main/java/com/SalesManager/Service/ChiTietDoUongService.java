package com.SalesManager.Service;

import java.util.List;

import com.SalesManager.Entity.ChiTietGoiNuocEntity;
import com.SalesManager.repository.ChiTietDoUongRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietDoUongService {

    @Autowired
    private ChiTietDoUongRepo chiTietDoUongRepo;
    @Autowired
    private DoUongService doUongService;

    public int save(ChiTietGoiNuocEntity Object) {
        return chiTietDoUongRepo.save(Object);
    }
    public List<ChiTietGoiNuocEntity> findByMaPhieuDH(long maPhieuDatHhang) {
        List<ChiTietGoiNuocEntity> lsCtgn =  chiTietDoUongRepo.findByMaPhieuDH(maPhieuDatHhang);
        for (int i = 0; i < lsCtgn.size(); i++)
        lsCtgn.get(i).setNuocUong(doUongService.findById(lsCtgn.get(i).getMaNuoc()));
        return lsCtgn;
    }
}
