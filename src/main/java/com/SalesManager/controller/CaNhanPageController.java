package com.SalesManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaNhanPageController {

    @GetMapping("canhan-page")
    public String caNhanPage() {
        return "profile";
    }
}
