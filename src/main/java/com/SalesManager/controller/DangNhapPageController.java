package com.SalesManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DangNhapPageController {

    @GetMapping("/dangnhap")
    public String dangNhapPage() {
        return "dangnhap";
    }
}
