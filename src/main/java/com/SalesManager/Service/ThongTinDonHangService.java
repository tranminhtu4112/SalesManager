package com.SalesManager.Service;

import java.util.ArrayList;
import java.util.List;

import com.SalesManager.Entity.ChiTietThanhToanEntity;
import com.SalesManager.Entity.PhieuDatHangEntity;
import com.SalesManager.Entity.ThongTinDonHangMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThongTinDonHangService {

    @Autowired
    private PhieuDatHangService phieuDatHangService;
    @Autowired
    private ChiTietThanhToanService chiTietThanhToanService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private ChiTietDoAnService chiTietDoAnService;
    @Autowired
    private ChiTietDoUongService chiTietDoUongService;

    public List<ThongTinDonHangMap> findAll() {

        List<ThongTinDonHangMap> lsThongTinDonHang = new ArrayList<>();
        List<PhieuDatHangEntity> lsPDH = phieuDatHangService.findAll();
        for (PhieuDatHangEntity pdh : lsPDH) {
            ThongTinDonHangMap ttdh = new ThongTinDonHangMap();
            ttdh.setPhieuDatHang(pdh);
            ChiTietThanhToanEntity cttt = chiTietThanhToanService.findByMaPhieuDH(pdh.getMaPhieuDatHang());
            ttdh.setChiTietThanhToan(cttt);
            ttdh.setKhachHang(khachHangService.findById(cttt.getMaKhachHang()));
            ttdh.setChiTietDoAn(chiTietDoAnService.findByMaPhieuDH(pdh.getMaPhieuDatHang()));
            ttdh.setChiTietGoiNuoc(chiTietDoUongService.findByMaPhieuDH(pdh.getMaPhieuDatHang()));
            lsThongTinDonHang.add(ttdh);
        }
        return lsThongTinDonHang;
    }

    public ThongTinDonHangMap findByMaDH(long maDatHang) {

        PhieuDatHangEntity pdh = phieuDatHangService.findById(maDatHang);
        ThongTinDonHangMap ttdh = new ThongTinDonHangMap();
        ttdh.setPhieuDatHang(pdh);
        ChiTietThanhToanEntity cttt = chiTietThanhToanService.findByMaPhieuDH(pdh.getMaPhieuDatHang());
        ttdh.setChiTietThanhToan(cttt);
        ttdh.setKhachHang(khachHangService.findById(cttt.getMaKhachHang()));
        ttdh.setChiTietDoAn(chiTietDoAnService.findByMaPhieuDH(pdh.getMaPhieuDatHang()));
        ttdh.setChiTietGoiNuoc(chiTietDoUongService.findByMaPhieuDH(pdh.getMaPhieuDatHang()));
        return ttdh;
    }

    public List<ThongTinDonHangMap> findByStatus(int status) {

        List<ThongTinDonHangMap> lsThongTinDonHang = new ArrayList<>();
        List<PhieuDatHangEntity> lsPDH = phieuDatHangService.findByStatus(status);
        for (PhieuDatHangEntity pdh : lsPDH) {
            ThongTinDonHangMap ttdh = new ThongTinDonHangMap();
            ttdh.setPhieuDatHang(pdh);
            ChiTietThanhToanEntity cttt = chiTietThanhToanService.findByMaPhieuDH(pdh.getMaPhieuDatHang());
            ttdh.setChiTietThanhToan(cttt);
            ttdh.setKhachHang(khachHangService.findById(cttt.getMaKhachHang()));
            ttdh.setChiTietDoAn(chiTietDoAnService.findByMaPhieuDH(pdh.getMaPhieuDatHang()));
            ttdh.setChiTietGoiNuoc(chiTietDoUongService.findByMaPhieuDH(pdh.getMaPhieuDatHang()));
            lsThongTinDonHang.add(ttdh);
        }
        return lsThongTinDonHang;
    }
}
