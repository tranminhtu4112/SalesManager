package com.SalesManager.Entity;

import java.util.Date;

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
public class PhieuDatHangEntity {

    private long maPhieuDatHang;
	private long maNhanVien;
	private Date ngayGioDat;
	private Date ngayGioGiao;
	private double tongTien;
	private int trangThai;
	
	private NhanVienEntity nhanVien;

}
