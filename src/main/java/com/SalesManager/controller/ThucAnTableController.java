package com.SalesManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThucAnTableController {

      @GetMapping("/thucan")
      public String thucAnController(){
            return"thucan-table";
      }
}
