package com.SalesManager.controller.api;

import com.SalesManager.repository.DanhMucDoUongRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class DanhMucDoUongController {

      @Autowired
      private DanhMucDoUongRepo danhMucDoUongRepo;

      @GetMapping("/danhMucDoUong")
      public ResponseEntity<?> findAll() {
            return ResponseEntity.ok(danhMucDoUongRepo.findAll());
      }

}
