package com.SalesManager.controller.api;

import javax.websocket.server.PathParam;

import com.SalesManager.Entity.KhachHangEntity;
import com.SalesManager.Service.KhachHangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KhachHangController {

      @Autowired
      private KhachHangService khachHangService;

      @PostMapping("/khachHang")
      public ResponseEntity<?> themkhachHang(@ModelAttribute KhachHangEntity khachHang) {
            try {
                  khachHangService.save(khachHang);
                  return ResponseEntity.ok("success");
            } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed");
            }
      }

      @GetMapping("/khachHangSearch")
      public ResponseEntity<?> getBySdtKhachHang(@PathParam("soDienThoai") String soDienThoai) {
            return ResponseEntity.ok(khachHangService.findByTenKhachHang(soDienThoai));
      }

      @GetMapping("/khachHang")
      public ResponseEntity<?> findAll() {
            return ResponseEntity.ok(khachHangService.findAll());
      }

}
