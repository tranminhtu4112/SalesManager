package com.SalesManager.controller.api;

import com.SalesManager.Entity.DanhMucDoAnEntity;
import com.SalesManager.repository.DanhMucDoAnRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class DanhMucDoAnController {

      @Autowired
      private DanhMucDoAnRepo danhMucDoAnRepo;

      @PostMapping("/danhMucDoAn")
      public ResponseEntity<?> save(@RequestParam("tenDanhMucDoAn") String tenDanhMucDoAn) {
            return ResponseEntity.ok(danhMucDoAnRepo.save(new DanhMucDoAnEntity(0l, tenDanhMucDoAn)));
      }

      @GetMapping("/danhMucDoAn")
      public ResponseEntity<?> findAll() {
            return ResponseEntity.ok(danhMucDoAnRepo.findAll());
      }
}
