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

      public long maNhanVien;
	private String hoTen;
	private String diaChi;
	public String soDienThoai;
	public String email;
	public boolean gioiTinh;
}
