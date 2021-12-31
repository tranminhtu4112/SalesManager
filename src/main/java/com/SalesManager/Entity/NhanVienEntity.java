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
public class NhanVienEntity {

    private long maNhanVien;
	private String hoTen;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private int gioiTinh;
	private String password;
	private String hinhAnh;
}
