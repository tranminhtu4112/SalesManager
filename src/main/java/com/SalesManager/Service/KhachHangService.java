package com.SalesManager.Service;

import java.util.List;

import com.SalesManager.Entity.KhachHangEntity;
import com.SalesManager.repository.KhachHangRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangService {

      @Autowired
      private KhachHangRepo khachHangRepo;

      public List<KhachHangEntity> findByTenKhachHang(String soDienThoai) {
            return khachHangRepo.findByTenKhachHang(soDienThoai);
      }

      public int save(KhachHangEntity Object) {
            return khachHangRepo.save(Object);
      }
      public List<KhachHangEntity> findAll() {
            return khachHangRepo.findAll();
      }

}
