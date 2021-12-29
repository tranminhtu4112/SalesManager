package com.SalesManager.controller.api;

import com.SalesManager.repository.DanhMucDoAnRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DanhMucDoAnController {

      @Autowired
      private DanhMucDoAnRepo danhMucDoAnRepo;

      @GetMapping("/danhMucDoAn")
      public ResponseEntity<?> findAll() {
            return ResponseEntity.ok(danhMucDoAnRepo.findAll());
      }
}
