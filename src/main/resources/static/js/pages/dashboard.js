$(function () {
  "use strict";
  new Chartist.Line(
    "#ct-visits",
    {
      labels: ["2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"],
      series: [
        [5, 2, 7, 4, 5, 3, 5, 4],
        [2, 5, 2, 6, 2, 5, 2, 4],
      ],
    },
    {
      top: 0,
      low: 1,
      showPoint: true,
      fullWidth: true,
      plugins: [Chartist.plugins.tooltip()],
      axisY: {
        labelInterpolationFnc: function (value) {
          return value / 1 + "k";
        },
      },
      showArea: true,
    }
  );

  var chart = [chart];

  var sparklineLogin = function () {
    $("#sparklinedash").sparkline([0, 5, 6, 10, 9, 12, 4, 9], {
      type: "bar",
      height: "30",
      barWidth: "4",
      resize: true,
      barSpacing: "5",
      barColor: "#7ace4c",
    });
    $("#sparklinedash2").sparkline([0, 5, 6, 10, 9, 12, 4, 9], {
      type: "bar",
      height: "30",
      barWidth: "4",
      resize: true,
      barSpacing: "5",
      barColor: "#7460ee",
    });
    $("#sparklinedash3").sparkline([0, 5, 6, 10, 9, 12, 4, 9], {
      type: "bar",
      height: "30",
      barWidth: "4",
      resize: true,
      barSpacing: "5",
      barColor: "#11a0f8",
    });
    $("#sparklinedash4").sparkline([0, 5, 6, 10, 9, 12, 4, 9], {
      type: "bar",
      height: "30",
      barWidth: "4",
      resize: true,
      barSpacing: "5",
      barColor: "#f33155",
    });
  };
  var sparkResize;
  $(window).on("resize", function (e) {
    clearTimeout(sparkResize);
    sparkResize = setTimeout(sparklineLogin, 500);
  });
  sparklineLogin();
});

/**
 *  ==========================
 */
const soluongkhachhang = document.querySelector("#soluongkhachhang");
const soluongdoan = document.querySelector("#soluongdoan");
const soluongdouong = document.querySelector("#soluongdouong");
const soLuongNhanVien = document.querySelector("#soLuongNhanVien");
function renderAnalytist() {
  fetch("http://localhost:8080/api/nhanVien")
    .then((res) => {
      if (res.ok) return res.json();
      else throw new Error("Something went wrong");
    })
    .then((data) => {
      soLuongNhanVien.innerHTML = data.length;
    });
  fetch("http://localhost:8080/api/khachHang")
    .then((res) => {
      if (res.ok) return res.json();
      else throw new Error("Something went wrong");
    })
    .then((data) => {
      soluongkhachhang.innerHTML = data.length;
    });
  fetch("http://localhost:8080/api/doAnKem")
    .then((res) => {
      if (res.ok) return res.json();
      else throw new Error("Something went wrong");
    })
    .then((data) => {
      soluongdoan.innerHTML = data.length;
    });
  fetch("http://localhost:8080/api/doUong")
    .then((res) => {
      if (res.ok) return res.json();
      else throw new Error("Something went wrong");
    })
    .then((data) => {
      soluongdouong.innerHTML = data.length;
    });
}
renderAnalytist();

/**
 * Render table hoa ??on
 */
const tabledonhang1 = document.querySelector("#table-donhang-1");
const tabledonhang2 = document.querySelector("#table-donhang-2");
const tongdoanhthu = document.querySelector("#tongdoanhthu");

function formatPrice(params) {
  return new Intl.NumberFormat("vi-VN", {
    style: "currency",
    currency: "VND",
  }).format(params);
}
const formatDate = (date) => {
  var newDate = date.split("-");
  return newDate[2] + "/" + newDate[1] + "/" + newDate[0];
};

function renderHoaDonDaGiao() {
  fetch("http://localhost:8080/api/donHangs/trangthai?status=1")
    .then((res) => res.json())
    .then((data) => {
      var tr = "";
      var tongthunhap = 0;
      data.forEach((ele) => {
        tongthunhap += ele.phieuDatHang.tongTien;
        tr += `<tr style='cursor:pointer'
                      onClick='renderChiTietDonHang(${
                        ele.phieuDatHang.maPhieuDatHang
                      })'>
                  <td><span class="text-success">${
                    ele.phieuDatHang.maPhieuDatHang
                  }</span></td>
                  <td class="txt-oflo">${ele.khachHang.hoTen}</td>
                  <td>${formatDate(ele.phieuDatHang.ngayGioDat)}</td>
                  <td class="txt-oflo">${formatDate(
                    ele.phieuDatHang.ngayGioGiao
                  )}</td>
                  <td>${formatPrice(ele.phieuDatHang.tongTien)}</td>
              </tr>`;
      });
      tabledonhang1.innerHTML = tr;
      tongdoanhthu.innerHTML = formatPrice(tongthunhap);
    });
}
renderHoaDonDaGiao();

function renderHoaDonChuaGiao() {
  fetch("http://localhost:8080/api/donHangs/trangthai?status=0")
    .then((res) => res.json())
    .then((data) => {
      var tr = "";
      data.forEach((ele) => {
        tr += `<tr style='cursor:pointer' onClick='renderChiTietDonHang(${
          ele.phieuDatHang.maPhieuDatHang
        })'>
                  <td><span class="text-success">${
                    ele.phieuDatHang.maPhieuDatHang
                  }</span></td>
                  <td class="txt-oflo">${ele.khachHang.hoTen}</td>
                  <td>${formatDate(ele.phieuDatHang.ngayGioDat)}</td>
                  <td class="txt-oflo">${formatDate(
                    ele.phieuDatHang.ngayGioGiao
                  )}</td>
                  <td>${formatPrice(ele.phieuDatHang.tongTien)}</td>
              </tr>`;
      });
      tabledonhang2.innerHTML = tr;
    });
}
renderHoaDonChuaGiao();

/**
 * Chi tiet don hang
 */
const modal = document.querySelector("#exampleModal");

function updateStatus(maPhieuDatHang, status) {
  fetch(
    "http://localhost:8080/api/donhang/trangthai?" +
      new URLSearchParams({
        maPhieuDatHang: maPhieuDatHang,
        status: status,
      }),
    { method: "POST" }
  )
    .then((res) => {
      if (res.ok) {
        renderAnalytist();
        renderHoaDonChuaGiao();
        renderHoaDonDaGiao();
        document.querySelector("#exampleModal").style.display = "none";
        return tata.success(
          "C???p nh???t th??nh c??ng",
          `C???p nh???t ????n h??ng ${maPhieuDatHang}`
        );
      } else throw new Error("C???p nh???t tr???ng th??i th???t b???i");
    })
    .catch((error) => {
      console.log(error);
      document.querySelector("#exampleModal").style.display = "none";
      return tata.error("C???p nh???t th???t b???i", "Vui l??ng ki???m tra l???i");
    });
}

function renderChiTietDonHang(maDonHang) {
  modal.style.display = "block";
  fetch(`http://localhost:8080/api/donHangs/${maDonHang}`)
    .then((res) => res.json())
    .then((data) => {
      var tr = "";
      var i = 0;
      var pStatus = `<button type="button" onclick="document.querySelector('#exampleModal').style.display = 'none'" data-bs-dismiss="modal" class="btn btn-primary">????ng</button>`;
      if (data.phieuDatHang.trangThai == 0) {
        pStatus = `<button type="button" onClick="updateStatus(${data.phieuDatHang.maPhieuDatHang}, 1)" data-bs-dismiss="modal" class="btn btn-primary">C???p nh???t ???? giao</button>`;
      }
      data.chiTietDoAn.forEach((ele) => {
        i++;
        tr += `<tr style="cursor: pointer;" class="hover-item">
                  <td>${i}</td>
                  <td>
                      <img style="height: 50px;width: 50px;" src="${
                        ele.doAnKem.hinhAnh
                      }" alt="">
                  </td>
                  <td>${ele.doAnKem.tenDoAn}</td>
                  <td>${formatPrice(ele.doAnKem.donGia)}</td>
              </tr>`;
      });
      data.chiTietGoiNuoc.forEach((ele) => {
        i++;
        tr += `<tr style="cursor: pointer;" class="hover-item">
                  <td>${i}</td>
                  <td>
                      <img style="height: 50px;width: 50px;" src="${
                        ele.nuocUong.hinhAnh
                      }" alt="">
                  </td>
                  <td>${ele.nuocUong.tenNuocUong}</td>
                  <td>${formatPrice(ele.nuocUong.donGia)}</td>
              </tr>`;
      });
      var status = "";
      if (data.phieuDatHang.trangThai == 1)
        status = '<i class="fas fa-check-circle" style="color: #46c446"></i>';
      else
        status = '<i class="fas fa-times-circle" style="color: #ee5252"></i>';
      var md = `<div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel" style="font-weight: 700;">Chi ti???t h??a ????n</h5>
                    <button type="button" onclick="document.querySelector('#exampleModal').style.display = 'none' "
                        class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div>
                        <div style="font-weight:700;font-size:17px;">M?? ????n h??ng: <span>${maDonHang}</span>
                        <i class="fas fa-truck" style="margin-left: 25px"></i>
                        ${status}
                        </div>
                        <div style="font-weight:700;font-size:17px;">M?? kh??ch h??ng: <span>${
                          data.khachHang.maKhachHang
                        }</span></div>
                        <div style="font-weight:700;font-size:17px;">T??n kh??ch h??ng: <span>${
                          data.khachHang.hoTen
                        } - S??T:
                        ${data.khachHang.soDienThoai}</span></div>
                        <div style="font-weight:700;font-size:17px;">?????a ch??? kh??ch h??ng: <span>${
                          data.khachHang.diaChi
                        }</span></div>
                        <div style="font-weight:700;font-size:17px;">Ng??y ?????t-giao: <span>${formatDate(
                          data.phieuDatHang.ngayGioDat
                        )} -
                        ${formatDate(
                          data.phieuDatHang.ngayGioGiao
                        )}</span></div>

                        <h4 class="page-title" style="margin-top:15px;font-weight:700;">Danh s??ch ?????t h??ng</h4>
                        <div class="table-responsive">
                            <table class="table text-nowrap">
                                <thead>
                                    <tr>
                                        <th class="border-top-0">S??? th??? t???</th>
                                        <th class="border-top-0">H??nh ???nh</th>
                                        <th class="border-top-0">T??n s???n ph???m</th>
                                        <th class="border-top-0">Gi??</th>
                                    </tr>
                                </thead>
                                <tbody id="table-doankemorder">
                                    ${tr}
                                    <tr>
                                      <td></td>
                                      <td></td>
                                      <td style="font-weight: 700">T???ng ti???n:</td>
                                      <td style="font-weight: 700">${formatPrice(
                                        data.phieuDatHang.tongTien
                                      )}</td>
                                  </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" value="Print" onclick="window.print()" class="btn btn-success" data-bs-dismiss="modal">In</button>
                    ${pStatus}
                </div>
            </div>
        </div>`;

      modal.innerHTML = md;
    });
}
