package com.SalesManager.controller;

import java.security.Principal;

import com.SalesManager.Entity.NhanVienEntity;
import com.SalesManager.Service.NhanVienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaNhanPageController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("canhan-page")
    public String caNhanPage(Model model, Principal principal) {

        NhanVienEntity nhanVienEntity = nhanVienService.findBySoDienThoai(principal.getName());
        model.addAttribute("tenNhanVien", nhanVienEntity.getHoTen());
        nhanVienEntity.setPassword("password");
        model.addAttribute("nhanVien", nhanVienEntity);
        return "profile";
    }
}
