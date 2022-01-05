package com.SalesManager.controller.api;

import java.io.IOException;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.SalesManager.Entity.DoAnKemEntity;
import com.SalesManager.Service.DoAnKemService;
import com.SalesManager.Utils.UploadFile;
import com.SalesManager.repository.DoAnKemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class DoAnKemController {

    @Autowired
    private DoAnKemRepo doAnKemRepo;
    @Autowired
    private DoAnKemService doAnKemService;
    @Autowired
    private UploadFile uploadFile;

    @PostMapping("/doAnKem")
    public ResponseEntity<?> themDoAnKem(@ModelAttribute DoAnKemEntity doAnKem) throws IOException {

        doAnKem.setHinhAnh(uploadFile.getPathUploadFile(doAnKem.getFileImage(), "doankem"));
        try {
            doAnKemRepo.save(doAnKem);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed");
        }
    }
    @GetMapping("/doAnKem/{id}")
    public ResponseEntity<?> getDoAnKemById(@PathVariable("id") Optional<Long> id) {
        if(id.isPresent())
            return ResponseEntity.ok(doAnKemService.findById(id.get()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("failed");
    }
    @GetMapping("/doAnKem")
    public ResponseEntity<?> getDoAnKem() {
        return ResponseEntity.ok(doAnKemService.findAll());
    }
    @GetMapping("/doAnKemSearch")
    public ResponseEntity<?> getByTenDoAnKem (@PathParam("tenDoAnKem") String tenDoAnKem){
        return ResponseEntity.ok(doAnKemService.findByTenDoAnKem(tenDoAnKem));
    }
}
