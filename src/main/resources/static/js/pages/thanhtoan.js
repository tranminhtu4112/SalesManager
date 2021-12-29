const inputThucAn = document.querySelector("#input-thucan");
const tableDoAnKemSearch = document.querySelector("#table-doankemsearch");
const tableDoAnKemOrder = document.querySelector("#table-doankemorder");
const url_search_thuc_an = "http://localhost:8080/doAnKemSearch?tenDoAnKem=";

var doAnKemOrder = [];

function formatPrice(params) {
  return new Intl.NumberFormat("vi-VN", {
    style: "currency",
    currency: "VND",
  }).format(params);
}

inputThucAn.addEventListener("keyup", (event) => {
  if (event.target.value == "") tableDoAnKemSearch.innerHTML = "";
  else renderSeachDoAn(event.target.value);
});
function renderSeachDoAn(tenDoAnKem) {
  var tblDoAnSearch = "";
  var i = 0;
  fetch(url_search_thuc_an + tenDoAnKem, { method: "GET" })
    .then((resp) => resp.json())
    .then((data) => {
      data.forEach((ele) => {
        i++;
        tblDoAnSearch += `<tr style="cursor: pointer;" class="hover-item" onClick="orderDoAn(${
          ele.maDoAn
        })">
                                        <td>${i}</td>
                                        <td>
                                        <img style="height: 50px;width: 50px;"
                                                src="${ele.hinhAnh}"
                                                alt="">
                                        </td>
                                        <td>${ele.tenDoAn}</td>
                                        <td>${formatPrice(ele.donGia)}</td>
                                        <td>VND</td>
                                    </tr>`;
      });
      if (tblDoAnSearch == "")
        tableDoAnKemSearch.innerHTML = "Không tìm thấy kết quả";
      else tableDoAnKemSearch.innerHTML = tblDoAnSearch;
    });
}
function orderDoAn(maDoAn) {
  tableDoAnKemSearch.innerHTML = "";
  inputThucAn.value = "";
  fetch("http://localhost:8080/doAnKem/" + maDoAn, { method: "GET" })
    .then((resp) => resp.json())
    .then((data) => {
      doAnKemOrder.push(data);
      renderDoAnKem();
    });
}
function renderDoAnKem() {
  var tr = "",
    i = 0;
  doAnKemOrder.forEach((ele) => {
    i++;
    tr += `<tr>
                  <td>${i}</td>
                  <td>${ele.danhMucDoAn.tenDanhMuc}</td>
                  <td>
                      <img class="hinh1" style="height: 50px;width: 50px;"
                          src="${ele.hinhAnh}"
                          alt="">
                  </td>
                  <td>${ele.tenDoAn}</td>
                  <td>${formatPrice(ele.donGia)}</td>
                  <td>VNĐ</td>
                  <td><i style="cursor: pointer;" class=" far fa-trash-alt" onClick="xoaDoAnKem(${
                    ele.maDoAn
                  })"></i></td>
              </tr>`;
  });
  tableDoAnKemOrder.innerHTML = tr;
}
function xoaDoAnKem(maDoAn) {
  for (let index = 0; index < doAnKemOrder.length; index++) {
    if (doAnKemOrder[index].maDoAn == maDoAn) {
      doAnKemOrder.splice(index, 1);
      break;
    }
  }
  renderDoAnKem();
}
/**
 *   form thanh toán
 */

const checkNewKhachHan = document.querySelector("#checkNewKhachHang");
const tableKhachHanngSearch = document.querySelector("#table-khachhanngsearch");
const hoTenKhachHang = document.querySelector("#hotenkhachhang");
const manhanvien = document.querySelector("#manhanvien");
const sdtkhachhang = document.querySelector("#sdtkhachhang");
const emailKhanhHang = document.querySelector("#emailKhanhHang");
const diachikhachhang = document.querySelector("#diachikhachhang");
const ngaydat = document.querySelector("#ngaydat");
const ngaygiao = document.querySelector("#ngaygiao");
const tongtien = document.querySelector("#tongtien");
const trangthai = document.querySelector("#trangthai");

let isNewKhachHang = false;

var today = new Date();
var dd = String(today.getDate()).padStart(2, "0");
var mm = String(today.getMonth() + 1).padStart(2, "0");
var yyyy = today.getFullYear();
today = yyyy + "-" + mm + "-" + dd;

ngaydat.setAttribute("value", today);

function disabledFormDatHang(isTrue) {
  if (isTrue) {
    hoTenKhachHang.disabled = true;
    hoTenKhachHang.value = "";
    emailKhanhHang.disabled = true;
    emailKhanhHang.value = "";
    diachikhachhang.disabled = true;
    diachikhachhang.value = "";
  } else {
    hoTenKhachHang.disabled = false;
    hoTenKhachHang.value = "";
    emailKhanhHang.disabled = false;
    emailKhanhHang.value = "";
    diachikhachhang.disabled = false;
    diachikhachhang.value = "";
  }
}
disabledFormDatHang(true);

checkNewKhachHang.addEventListener("click", () => {
  if (isNewKhachHang) {
    disabledFormDatHang(true);
    isNewKhachHang = false;
  } else {
    isNewKhachHang = true;
    disabledFormDatHang(false);
    sdtkhachhang.value = "";
  }
});

var khachHangsSearch = null;
var khachHangChon = null;

const url_search_khach_hang =
  "http://localhost:8080/khachHangSearch?soDienThoai=";

sdtkhachhang.addEventListener("keyup", (event) => {
  if (event.target.value == "") tableKhachHanngSearch.innerHTML = "";
  else if (!isNewKhachHang) renderKhachHangSearch(event.target.value);
  tableKhachHanngSearch.innerHTML = "";
});

function renderKhachHangSearch(soDienThoai) {
  var tr = "";
  fetch(url_search_khach_hang + soDienThoai)
    .then((res) => res.json())
    .then((data) => {
      khachHangsSearch = data;
      data.forEach((ele) => {
        tr += `<div style="cursor: pointer;" class="sdt-search" onClick="chonKhacHang(${ele.maKhachHang})">${ele.hoTen} - ${ele.soDienThoai}</div>`;
      });
      tableKhachHanngSearch.innerHTML = tr;
    });
}
function chonKhacHang(maKhachHang) {
  var khachHang = khachHangsSearch.filter(
    (ele) => ele.maKhachHang == maKhachHang
  )[0];
  renderKhachHangForm(khachHang);
}
function renderKhachHangForm(khachHang) {
  tableKhachHanngSearch.innerHTML = "";
  hoTenKhachHang.value = khachHang.hoTen;
  emailKhanhHang.value = khachHang.email;
  diachikhachhang.value = khachHang.diaChi;
  sdtkhachhang.value = khachHang.soDienThoai;
}
