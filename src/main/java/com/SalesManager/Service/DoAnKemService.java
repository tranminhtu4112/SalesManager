package com.SalesManager.Service;

import java.util.List;

import com.SalesManager.Entity.DanhMucDoAnEntity;
import com.SalesManager.Entity.DoAnKemEntity;
import com.SalesManager.repository.DanhMucDoAnRepo;
import com.SalesManager.repository.DoAnKemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoAnKemService {

      @Autowired
      private DoAnKemRepo doAnKemRepo;
      @Autowired
      private DanhMucDoAnRepo danhMucDoAnRepo;

      public int save(DanhMucDoAnEntity Object) {
            return danhMucDoAnRepo.save(Object);
      }
      public List<DoAnKemEntity> findAll() {
            List<DoAnKemEntity> listDoAnKem = doAnKemRepo.findAll();
            for (int i = 0; i < listDoAnKem.size(); i++)
                  listDoAnKem.get(i).setDanhMucDoAn(danhMucDoAnRepo.findById(listDoAnKem.get(i).getMaDanhMucDoAn()));
            return listDoAnKem;
      }
      public List<DoAnKemEntity> findByTenDoAnKem(String tenDoAnKem) {
            List<DoAnKemEntity> listDoAnKem = doAnKemRepo.findByTenDoAnKem(tenDoAnKem);
            for (int i = 0; i < listDoAnKem.size(); i++)
                  listDoAnKem.get(i).setDanhMucDoAn(danhMucDoAnRepo.findById(listDoAnKem.get(i).getMaDanhMucDoAn()));
            return listDoAnKem;
      }
      public DoAnKemEntity findById(long id) {
            DoAnKemEntity doAnKem = doAnKemRepo.findById(id);
            doAnKem.setDanhMucDoAn(danhMucDoAnRepo.findById(doAnKem.getMaDanhMucDoAn()));
            return doAnKem;
      }
}
