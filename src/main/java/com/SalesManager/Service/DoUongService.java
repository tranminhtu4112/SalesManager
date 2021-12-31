package com.SalesManager.Service;

import java.util.List;

import com.SalesManager.Entity.NuocUongEntity;
import com.SalesManager.repository.DanhMucDoUongRepo;
import com.SalesManager.repository.DoUongRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoUongService {

      @Autowired
      private DoUongRepo doUongRepo;
      @Autowired
      private DanhMucDoUongRepo danhMucDoUongRepo;

      public int save(NuocUongEntity Object) {
            return doUongRepo.save(Object);
      }
      public List<NuocUongEntity> findAll() {
            List<NuocUongEntity> listNuocUong = doUongRepo.findAll();
            for (int i = 0; i < listNuocUong.size(); i++)
                  listNuocUong.get(i)
                              .setDanhMucNuocUong(danhMucDoUongRepo.findById(listNuocUong.get(i).getMaDanhMucNuoc()));
            return listNuocUong;
      }

      public List<NuocUongEntity> findByTenNuocUong(String tenNuocUong) {
            List<NuocUongEntity> listNuocUong = doUongRepo.findByTenDoUong(tenNuocUong);
            for (int i = 0; i < listNuocUong.size(); i++)
                  listNuocUong.get(i)
                              .setDanhMucNuocUong(danhMucDoUongRepo.findById(listNuocUong.get(i).getMaDanhMucNuoc()));
            return listNuocUong;
      }

      public NuocUongEntity findById(long id) {
            NuocUongEntity nuocUong = doUongRepo.findById(id);
            nuocUong.setDanhMucNuocUong(danhMucDoUongRepo.findById(nuocUong.getMaDanhMucNuoc()));
            return nuocUong;
      }
}
