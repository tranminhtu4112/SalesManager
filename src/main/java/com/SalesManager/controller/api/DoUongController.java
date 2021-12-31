package com.SalesManager.controller.api;

import java.io.IOException;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.SalesManager.Entity.NuocUongEntity;
import com.SalesManager.Service.DoUongService;
import com.SalesManager.Utils.UploadFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoUongController {
      @Autowired
      private DoUongService doUongService;
      @Autowired
      private UploadFile uploadFile;

      @PostMapping("/doUong")
      public ResponseEntity<?> themDoUong(@ModelAttribute NuocUongEntity doUong) throws IOException {

            doUong.setHinhAnh(uploadFile.getPathUploadFile(doUong.getFileImage(), "douong"));
            try {
                  doUongService.save(doUong);
                  return ResponseEntity.ok("success");
            } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed");
            }
      }

      @GetMapping("/doUong")
      public ResponseEntity<?> getDoUong() {
            return ResponseEntity.ok(doUongService.findAll());
      }

      @GetMapping("/doUong/{id}")
      public ResponseEntity<?> getDoUongById(@PathVariable("id") Optional<Long> id) {
            if (id.isPresent())
                  return ResponseEntity.ok(doUongService.findById(id.get()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("failed");
      }

      @GetMapping("/doUongSearch")
      public ResponseEntity<?> getByTenDoUong(@PathParam("tenDoUong") String tenDoUong) {
            return ResponseEntity.ok(doUongService.findByTenNuocUong(tenDoUong));
      }
}
