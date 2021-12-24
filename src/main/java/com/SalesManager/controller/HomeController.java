package com.SalesManager.controller;

import com.SalesManager.Entity.ChiTietThanhToanEntity;
import com.SalesManager.Entity.NhanVienEntity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

      @GetMapping(value = {"/home", "/"})
      public ResponseEntity<?> home () {
            return ResponseEntity.ok("Hello Minh Tu");
      }
}
