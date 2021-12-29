package com.SalesManager.controller.api;

import javax.websocket.server.PathParam;

import com.SalesManager.Service.KhachHangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KhachHangController {

      @Autowired
      private KhachHangService khachHangService;

      @GetMapping("/khachHangSearch")
      public ResponseEntity<?> getBySdtKhachHang (@PathParam("soDienThoai") String soDienThoai) {
            return ResponseEntity.ok(khachHangService.findByTenKhachHang(soDienThoai));
      }
}
