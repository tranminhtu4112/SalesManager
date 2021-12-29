package com.SalesManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThanhToanController {

      @GetMapping("/thanhtoan")
      public String thanhtoanPage() {
            return "thanhtoan";
      }
}
