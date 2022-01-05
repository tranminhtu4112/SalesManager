package com.SalesManager.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SalesManager.Service.NhanVienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardPageController {

      @Autowired
      private NhanVienService nhanVienService;

      @GetMapping(value = { "/dashboard", "/" })
      public String dashboardPage(Model model, Principal principal) {
            model.addAttribute("tenNhanVien", nhanVienService.findBySoDienThoai(principal.getName()).getHoTen());
            return "dashboard";
      }
      @GetMapping(value = { "/logout" })
      public String logout(HttpServletRequest request, HttpServletResponse response) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null){
               new SecurityContextLogoutHandler().logout(request, response, auth);
            }
            return "redirect:/dangnhap";
      }
}
