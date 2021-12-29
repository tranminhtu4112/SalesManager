package com.SalesManager.Utils;

import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class StringUtils {

      public String getNameInFullName(String fullName) {
		String[] name = fullName.split(" ");
		return name[name.length-1];
	}
	public String convertPathImage(String pathImage) {
		return pathImage.replace('\\', '/');
	}
	public String getFormatCurrency(Double price) {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return formatter.format(price);
	}
	public String removeAccent(String nvarchar) {
		String temp = Normalizer.normalize(nvarchar, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("");
	}
	public String getKeyCode(String nvarchar) {
		return this.removeAccent(nvarchar).replace(" ", "").toLowerCase();
	}
	public String reverseDate(String dateString) {
		String temp[] = dateString.split("-");
		return temp[2] + "-" + temp[1]+ "-" + temp[0];
	}
}
