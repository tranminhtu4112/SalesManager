package com.SalesManager.controller.api;

import java.security.Principal;

import com.SalesManager.Service.NhanVienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPrincipalController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/getprincipal")
    public ResponseEntity <?> getPrincipal (Principal principal){
        return ResponseEntity.ok(nhanVienService.findBySoDienThoai(principal.getName()));
    }
}
