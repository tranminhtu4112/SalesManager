package com.SalesManager.controller;

import com.SalesManager.Entity.DoAnKemEntity;
import com.SalesManager.repository.DoAnKemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoAnKemController {

      @Autowired
      private DoAnKemRepo doAnKemRepo;
      @PostMapping("/themDoAnKem")
      public ResponseEntity<?> themDoAnKem(@RequestBody DoAnKemEntity doAnKem) {
            return ResponseEntity.ok("index: " + doAnKemRepo.save(doAnKem));
      }
}
