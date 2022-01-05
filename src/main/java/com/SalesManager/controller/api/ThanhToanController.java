package com.SalesManager.controller.api;

import com.SalesManager.Entity.ChiTietDoAnEntity;
import com.SalesManager.Entity.ChiTietGoiNuocEntity;
import com.SalesManager.Entity.ChiTietThanhToanEntity;
import com.SalesManager.Entity.DoAnKemEntity;
import com.SalesManager.Entity.ItemOrderMapRequest;
import com.SalesManager.Entity.KhachHangEntity;
import com.SalesManager.Entity.NuocUongEntity;
import com.SalesManager.Entity.PhieuDatHangEntity;
import com.SalesManager.Service.ChiTietDoAnService;
import com.SalesManager.Service.ChiTietDoUongService;
import com.SalesManager.Service.ChiTietThanhToanService;
import com.SalesManager.Service.KhachHangService;
import com.SalesManager.Service.PhieuDatHangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ThanhToanController {

    @Autowired
    private ChiTietDoAnService chiTietDoAnService;
    @Autowired
    private ChiTietDoUongService chiTietDoUongService;
    @Autowired
    private PhieuDatHangService phieuDatHangService;
    @Autowired
    private ChiTietThanhToanService chiTietThanhToanService;
    @Autowired
    private KhachHangService khachHangService;

    @PostMapping("/thanhtoan")
    public ResponseEntity<?> thanhtoan(@RequestBody ItemOrderMapRequest itemOrder,
            @RequestParam("maDatHang") String maPhieuDatHang) {
        double donGiaDoAnKem = 0d, donGiaDoUong = 0d;

        try {
            PhieuDatHangEntity phieuDatHang = new PhieuDatHangEntity();
            phieuDatHang.setMaPhieuDatHang(Long.parseLong(maPhieuDatHang));
            phieuDatHang.setMaNhanVien(itemOrder.getMaNhanVien());
            phieuDatHang.setNgayGioDat(itemOrder.getNgayDat());
            phieuDatHang.setNgayGioGiao(itemOrder.getNgayGiao());
            phieuDatHang.setTongTien(itemOrder.getTongTien());
            phieuDatHang.setTrangThai(itemOrder.getTrangThai());
            phieuDatHangService.save(phieuDatHang);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("failed");
        }
        try {
            for (DoAnKemEntity doAnKem : itemOrder.getListDoAnKem()) {
                donGiaDoAnKem += doAnKem.getDonGia();
                ChiTietDoAnEntity chiTietDoAn = new ChiTietDoAnEntity();
                chiTietDoAn.setMaPhieuDatHang(Long.parseLong(maPhieuDatHang));
                chiTietDoAn.setMaDoAn(doAnKem.getMaDoAn());
                chiTietDoAn.setDonGia(doAnKem.getDonGia());
                chiTietDoAn.setSoLuong(1);
                chiTietDoAn.setThanhTien(doAnKem.getDonGia() * 1);
                chiTietDoAnService.save(chiTietDoAn);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("failed");
        }

        try {
            for (NuocUongEntity doUong : itemOrder.getListDoUong()) {
                donGiaDoUong += doUong.getDonGia();
                ChiTietGoiNuocEntity chiTietGoiNuoc = new ChiTietGoiNuocEntity();
                chiTietGoiNuoc.setMaPhieuDatHang(Long.parseLong(maPhieuDatHang));
                chiTietGoiNuoc.setMaNuoc(doUong.getMaNuoc());
                chiTietGoiNuoc.setDioGia(doUong.getDonGia());
                chiTietGoiNuoc.setSoLuong(1);
                chiTietGoiNuoc.setThanhTien(doUong.getDonGia() * 1);
                chiTietDoUongService.save(chiTietGoiNuoc);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("failed");
        }

        try {
            if (itemOrder.getIsNewKhachHang().equals("true"))
                khachHangService.save(itemOrder.getKhachHang());

            KhachHangEntity khachHang = khachHangService.findByTenKhachHang(itemOrder.getKhachHang().getSoDienThoai())
                    .get(0);

            ChiTietThanhToanEntity chiTietThanhToan = new ChiTietThanhToanEntity();

            chiTietThanhToan.setMaKhachHang(khachHang.getMaKhachHang());
            chiTietThanhToan.setMaPhieuDatHang(Long.parseLong(maPhieuDatHang));
            chiTietThanhToan.setThoiDiemThanhToan(itemOrder.getNgayGiao());
            chiTietThanhToanService.save(chiTietThanhToan);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("failed");
        }

        return ResponseEntity.ok("success");
    }
}
