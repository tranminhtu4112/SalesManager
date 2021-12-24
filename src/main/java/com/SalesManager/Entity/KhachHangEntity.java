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
public class KhachHangEntity {

      private long maKhachHang;
	private String hoTen;
	private String diaChi;
	private String soDienThoai;
	private String email;

}
