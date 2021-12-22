package com.SalesManager.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

      @GetMapping(value = {"/home", "/"})
      public ResponseEntity<?> home () {
            return ResponseEntity.ok("Hello Minh Tu");
      }
}
