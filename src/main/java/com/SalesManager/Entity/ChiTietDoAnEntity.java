package com.SalesManager.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChiTietDoAnEntity {

      private long maPhieuDatHang;
      private long maDoAn;
      private double donGia;
      private int soLuong;
      private double thanhTien;

      private PhieuDatHangEntity phieuDatHang;
      private DoAnKemEntity doAnKem;
}
