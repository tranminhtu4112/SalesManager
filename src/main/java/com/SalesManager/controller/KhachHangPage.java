package com.SalesManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KhachHangPage {

    @GetMapping("/khachhang-page")
    public String khachHangGage (){
        return "khachhang-table";
    }
}
