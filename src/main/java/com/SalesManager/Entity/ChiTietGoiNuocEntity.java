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
public class ChiTietGoiNuocEntity {

    private long maPhieuDatHang;
	private long maNuoc;
	private double dioGia;
	private int soLuong;
	private double thanhTien;


	private PhieuDatHangEntity phieuDatHang;
	private  NuocUongEntity nuocUong;
}

