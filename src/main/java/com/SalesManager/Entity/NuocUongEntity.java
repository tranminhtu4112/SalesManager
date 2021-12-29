package com.SalesManager.Entity;
import org.springframework.web.multipart.MultipartFile;

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
public class NuocUongEntity {

      private long maNuoc;
	private long maDanhMucNuoc;
	private String tenNuocUong;
	private double donGia;
	private String donViTinh;
	private int soLuongTon;
	private String hinhAnh;
	private MultipartFile fileImage;

	private DanhMucNuocUongEntity danhMucNuocUong;
}
