package com.SalesManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NhanVienPageController {

    @GetMapping("nhanvien-page")
    public String nhanVienPage() {
        return "nhanvien-table";
    }
}
