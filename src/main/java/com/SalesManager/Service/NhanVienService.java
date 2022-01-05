package com.SalesManager.Service;

import java.util.List;

import com.SalesManager.Entity.NhanVienEntity;
import com.SalesManager.repository.NhanVienRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepo nhanVienRepo;
    public NhanVienEntity findBySoDienThoai(String sdt) {
        return nhanVienRepo.findBySoDienThoai(sdt);
    }
    public List<NhanVienEntity> findAll() {
        return nhanVienRepo.findAll();
    }
    public NhanVienEntity findById(long id) {
        return nhanVienRepo.findById(id);
    }

}
