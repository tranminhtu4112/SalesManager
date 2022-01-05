const inputThucAn = document.querySelector("#input-thucan");
const tableDoAnKemSearch = document.querySelector("#table-doankemsearch");
const tableDoAnKemOrder = document.querySelector("#table-doankemorder");
const url_search_thuc_an =
  "http://localhost:8080/api/doAnKemSearch?tenDoAnKem=";
const sumpricetable = document.querySelector("#sum-price-table");
const btndathang = document.querySelector("#btn-dathang");
const tongtienthanhtoan = document.querySelector("#tongtienthanhtoan");
/**
 *   Order do an
 */
var doAnKemOrder = [];
var doUongOrder = [];

function sumPrice() {
  var sum = 0;
  doAnKemOrder.forEach((ele) => {
    sum += ele.donGia;
  });
  doUongOrder.forEach((ele) => {
    sum += ele.donGia;
  });
  return sum;
}

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
  fetch("http://localhost:8080/api/doAnKem/" + maDoAn, { method: "GET" })
    .then((resp) => resp.json())
    .then((data) => {
      doAnKemOrder.push(data);
      renderTableOrder();
    });
}
function renderTableOrder() {
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
  doUongOrder.forEach((ele) => {
    i++;
    tr += `<tr>
                  <td>${i}</td>
                  <td>${ele.danhMucNuocUong.tenDanhMuc}</td>
                  <td>
                      <img class="hinh1" style="height: 50px;width: 50px;"
                          src="${ele.hinhAnh}"
                          alt="">
                  </td>
                  <td>${ele.tenNuocUong}</td>
                  <td>${formatPrice(ele.donGia)}</td>
                  <td>VNĐ</td>
                  <td><i style="cursor: pointer;" class=" far fa-trash-alt" onClick="xoaDoUong(${
                    ele.maNuoc
                  })"></i></td>
              </tr>`;
  });
  tableDoAnKemOrder.innerHTML = tr;
  sumpricetable.innerHTML = formatPrice(sumPrice());
  tongtienthanhtoan.value = formatPrice(sumPrice());
  if (sumPrice() == 0) {
    btndathang.disabled = true;
  } else {
    btndathang.disabled = false;
  }

  sumPrice();
}
function xoaDoAnKem(maDoAn) {
  for (let index = 0; index < doAnKemOrder.length; index++) {
    if (doAnKemOrder[index].maDoAn == maDoAn) {
      doAnKemOrder.splice(index, 1);
      break;
    }
  }
  renderTableOrder();
}

/**
 *  Order do uong
 */

const tabledouongearch = document.querySelector("#table-douongearch");
const inputdouong = document.querySelector("#input-douong");

inputdouong.addEventListener("keyup", (event) => {
  if (event.target.value == "") tabledouongearch.innerHTML = "";
  else renderSeachDoUong(event.target.value);
});

function renderSeachDoUong(tenDoUong) {
  fetch("http://localhost:8080/api/doUongSearch?tenDoUong=" + tenDoUong, {
    method: "GET",
  })
    .then((res) => res.json())
    .then((data) => {
      var tr = "";
      data.forEach((ele) => {
        tr += `<tr class="hover-item" style="cursor: pointer;" onClick="orderDoUong(${
          ele.maNuoc
        })">
                  <td>
                      <img style="height: 50px;width: 50px;"
                          src="${ele.hinhAnh}"
                          alt="">
                  </td>
                  <td>${ele.tenNuocUong}</td>
                  <td>${formatPrice(ele.donGia)}</td>
                  <td>VNĐ</td>
              </tr>`;
      });
      if (tr == "") tabledouongearch.innerHTML = "Không tìm thấy kết quả";
      else tabledouongearch.innerHTML = tr;
    });
}
function orderDoUong(maNuoc) {
  tabledouongearch.innerHTML = "";
  inputdouong.value = "";
  fetch(`http://localhost:8080/api/doUong/${maNuoc}`)
    .then((res) => res.json())
    .then((data) => {
      doUongOrder.push(data);
      renderTableOrder();
    });
}
function xoaDoUong(maNuoc) {
  for (let index = 0; index < doUongOrder.length; index++) {
    if (doUongOrder[index].maNuoc == maNuoc) {
      doUongOrder.splice(index, 1);
      break;
    }
  }
  renderTableOrder();
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
const btnthanhtoan = document.querySelector("#btn-thanhtoan");

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
  "http://localhost:8080/api/khachHangSearch?soDienThoai=";

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
        tr += `<div style="cursor: pointer;" class="sdt-search" onClick="chonKhachHang(${ele.maKhachHang})">${ele.hoTen} - ${ele.soDienThoai}</div>`;
      });
      tableKhachHanngSearch.innerHTML = tr;
    });
}
function chonKhachHang(maKhachHang) {
  khachHangChon = khachHangsSearch.filter(
    (ele) => ele.maKhachHang == maKhachHang
  )[0];
  renderKhachHangForm(khachHangChon);
}
function renderKhachHangForm(khachHang) {
  tableKhachHanngSearch.innerHTML = "";
  hoTenKhachHang.value = khachHang.hoTen;
  emailKhanhHang.value = khachHang.email;
  diachikhachhang.value = khachHang.diaChi;
  sdtkhachhang.value = khachHang.soDienThoai;
}

function getMaDatHang() {
  var date = new Date();
  var dd = String(date.getDate()).padStart(2, "0");
  var mm = String(date.getMonth() + 1).padStart(2, "0");
  var yyyy = date.getFullYear();
  var hh = date.getHours();
  var min = date.getMinutes();
  var ss = date.getSeconds();
  var mls = date.getMilliseconds();
  maDatHang = yyyy + mm + dd + hh + min + ss + mls;
  return maDatHang;
}

btnthanhtoan.addEventListener("click", () => {
  var itemOrder = {
    listDoAnKem: doAnKemOrder,
    listDoUong: doUongOrder,
    maNhanVien: manhanvien.value,
    ngayDat: ngaydat.value,
    ngayGiao: ngaygiao.value,
    tongTien: sumPrice(),
    trangThai: trangthai.value,
    isNewKhachHang: isNewKhachHang,
    khachHang: {
      maKhachHang: -1,
      hoTen: hoTenKhachHang.value,
      email: emailKhanhHang.value,
      diaChi: diachikhachhang.value,
      soDienThoai: sdtkhachhang.value,
    },
  };
  //console.log(itemOrder)
  fetch(
    "http://localhost:8080/api/thanhtoan?" +
      new URLSearchParams({
        maDatHang: getMaDatHang(),
      }),
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(itemOrder),
    }
  )
    .then((res) => {
      if (res.status === 200) {
        return;
      } else {
        throw new Error("Something went wrong");
      }
    })
    .then((data) => {
      return tata.success("Đặt hàng thành công", "Hãy kiểm tra đơn hàng");
    })
    .catch((err) => {
      return tata.error("Đặt hàng thất bại", "Vui lòng kiểm tra lại");
    });
});
