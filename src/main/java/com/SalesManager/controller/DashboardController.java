package com.SalesManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

      @GetMapping(value = {"/home", "/"})
      public String dashboardPage() {
            return "dashboard";
      }
}
