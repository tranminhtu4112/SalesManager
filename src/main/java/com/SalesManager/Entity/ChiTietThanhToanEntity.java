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
public class ChiTietThanhToanEntity {

      private long maKhachHang;
	private long maPhieuDatHang;
	private Date thoiDiemThanhToan;

	private KhachHangEntity khachHang;
	private PhieuDatHangEntity phieuDatHang;
}
