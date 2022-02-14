package com.SalesManager.controller.api;

import com.SalesManager.Entity.DanhMucNuocUongEntity;
import com.SalesManager.repository.DanhMucDoUongRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class DanhMucDoUongController {

      @Autowired
      private DanhMucDoUongRepo danhMucDoUongRepo;

      @PostMapping("/danhMucDoUong")
      public ResponseEntity<?> save(@RequestParam("tenDanhMucDoUong") String tenDanhMucDoUong) {
            return ResponseEntity.ok(danhMucDoUongRepo.save(new DanhMucNuocUongEntity(0l, tenDanhMucDoUong)));
      }

      @GetMapping("/danhMucDoUong")
      public ResponseEntity<?> findAll() {
            return ResponseEntity.ok(danhMucDoUongRepo.findAll());
      }

}
