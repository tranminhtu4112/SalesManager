package com.SalesManager.Entity;

import java.util.Date;
import java.util.List;

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
public class ItemOrderMapRequest {

    private long maNhanVien;
    private List<DoAnKemEntity> listDoAnKem;
    private List<NuocUongEntity> listDoUong;
    private Date ngayDat;
    private Date ngayGiao;
    private double tongTien;
    private int trangThai;
    private String isNewKhachHang;
    private KhachHangEntity khachHang;
}
