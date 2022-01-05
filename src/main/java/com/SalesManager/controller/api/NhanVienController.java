package com.SalesManager.controller.api;

import com.SalesManager.Service.NhanVienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/nhanVien")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(nhanVienService.findAll());
    }
}
