package com.SalesManager.controller.api;

import com.SalesManager.Service.PhieuDatHangService;
import com.SalesManager.Service.ThongTinDonHangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DonHangController {

    @Autowired
    private ThongTinDonHangService thongTinDonHangService;
    @Autowired
    private PhieuDatHangService phieuDatHangService;

    @GetMapping("/donHangs")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(thongTinDonHangService.findAll());
    }

    @GetMapping("/donHangs/{maDatHang}")
    public ResponseEntity<?> findByMaDH(@PathVariable("maDatHang") long maDatHang) {
        return ResponseEntity.ok(thongTinDonHangService.findByMaDH(maDatHang));
    }

    @GetMapping("/donHangs/trangthai")
    public ResponseEntity<?> findByStatus(@RequestParam("status") int status) {
        return ResponseEntity.ok(thongTinDonHangService.findByStatus(status));
    }

    @PostMapping("/donhang/trangthai")
    public ResponseEntity<?> updateStatus(@RequestParam("maPhieuDatHang") long maPhieuDatHang,
            @RequestParam("status") int status) {
                return ResponseEntity.ok(phieuDatHangService.updateStatus(maPhieuDatHang, status));
    }

}
