const selectdanhmucnuoc = document.querySelector("#select-danhmucnuoc");
const tennuoc = document.querySelector("#tennuoc");
const dongia = document.querySelector("#dongia");
const donvi = document.querySelector("#donvi");
const soluongton = document.querySelector("#soluongton");
const fileImage = document.querySelector("#fileImage");
const btnthemdouong = document.querySelector("#btn-them");
const tabledouong = document.querySelector("#table-douong");
const tabledanhmucnuoc = document.querySelector("#table-danhmucnuoc");

function formatPrice(params) {
    return new Intl.NumberFormat("vi-VN", {
      style: "currency",
      currency: "VND",
    }).format(params);
  }

function renderDanhMucNuoc() {
  fetch("http://localhost:8080/danhMucDoUong", { method: "GET" })
    .then((res) => res.json())
    .then((data) => {
      var options = "";
      data.forEach((ele) => {
        options += `<option value="${ele.maDanhMucNuoc}">${ele.tenDanhMuc}</option>`;
      });
      selectdanhmucnuoc.innerHTML = options;
    });
}
renderDanhMucNuoc();

function rederTableDanhMucMuoc() {
  fetch("http://localhost:8080/danhMucDoUong", { method: "GET" })
    .then((res) => res.json())
    .then((data) => {
      var tr = "",
        i = 0;
      data.forEach((ele) => {
        i++;
        tr += `<tr>
                    <td>${i}</td>
                    <td>${ele.tenDanhMuc}</td>
                    <td><i class=" far fa-trash-alt"> </i></td>
                    <td><i class=" far fa-edit"></i></td>
                </tr>`;
      });
      tabledanhmucnuoc.innerHTML = tr;
      renderDanhMucNuoc();
    });
}
rederTableDanhMucMuoc();

const urlThemDoUong = "http://localhost:8080/doUong";

btnthemdouong.addEventListener("click", () => {
  var img = fileImage.files[0];

  var form = new FormData();
  form.append("maDanhMucNuoc", selectdanhmucnuoc.value);
  form.append("tenNuocUong", tennuoc.value);
  form.append("donGia", dongia.value);
  form.append("donViTinh", donvi.value);
  form.append("soLuongTon", soluongton.value);
  form.append("fileImage", img);

  const optionsThemDoAn = {
    method: "POST",
    body: form,
  };

  fetch(urlThemDoUong, optionsThemDoAn).then((resp) => {
    if (resp.status === 200) {
      tata.success("Thêm thành công", "Đã cập nhật");
      renderTableDoUong();
    } else tata.error("Thêm thất bại", "Vui lòng kiểm tra lại");
  });
});

function renderTableDoUong() {
  fetch("http://localhost:8080/doUong", { method: "GET" })
    .then((res) => res.json())
    .then((data) => {
      var tr = "",
        i = 0;
      data.forEach((ele) => {
        i++;
        tr += `<tr>
                    <td>${i}</td>
                    <td>${ele.danhMucNuocUong.tenDanhMuc}</td>
                    <td>
                        <img style="height: 50px;width: 50px;"
                            src="${ele.hinhAnh}"
                            alt="">
                    </td>
                    <td>${ele.tenNuocUong}</td>
                    <td>${formatPrice(ele.donGia)}</td>
                    <td>${ele.donViTinh}</td>
                    <td>${ele.soLuongTon}</td>
                    <td><i class=" far fa-trash-alt"> </i></td>
                    <td><i class=" far fa-edit"></i></td>
                </tr>`;
      });
      tabledouong.innerHTML = tr;
    });
}
renderTableDoUong();
