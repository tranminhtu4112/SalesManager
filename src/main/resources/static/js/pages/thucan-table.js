const selectDanhmuc = document.querySelector("#select-danhmuc");
const tableDanhmuc = document.querySelector("#table-danhmuc");

function formatPrice(params) {
  return new Intl.NumberFormat("vi-VN", {
    style: "currency",
    currency: "VND",
  }).format(params);
}
document.querySelector("#donGia").addEventListener("keyup", (event) => {
  document.querySelector("#price-f").innerHTML = formatPrice(
    event.target.value
  );
});
const url = "http://localhost:8080/api/danhMucDoAn";

const options = {
  method: "GET",
};

var danhMucList = [];

function renderDanhMuc() {
  fetch(url, options)
    .then((res) => res.json())
    .then((data) => {
      danhMucList = data;
      var op1 = "<option selected>Chọn danh mục</option>";
      var ops = "";
      var tblDanhMuc = "";
      var i = 0;
      danhMucList.forEach((ele) => {
        i++;
        ops += `<option value="${ele.maDanhMucDoAn}">${ele.tenDanhMuc}</option>`;
        tblDanhMuc += `<tr>
                          <td>${i}</td>
                          <td>${ele.tenDanhMuc}</td>
                          <td><i class=" far fa-trash-alt"> </i></td>
                          <td><i class=" far fa-edit"></i></td>
                      </tr>`;
      });
      selectDanhmuc.innerHTML = op1 + ops;
      tableDanhmuc.innerHTML = tblDanhMuc;
    });
}
renderDanhMuc();

const tableDoankem = document.querySelector("#table-doankem");
const urlDoAnKem = "http://localhost:8080/api/doAnKem";

function renderDoAnKem() {
  fetch(urlDoAnKem, { method: "GET" })
    .then((res) => res.json())
    .then((data) => {
      listDoAnKem = data;
      var tr = "";
      var i = 0;
      listDoAnKem.forEach((ele) => {
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
                <td>${ele.soLuongTon}</td>
                <td><i class=" far fa-trash-alt"> </i></td>
                <td><i class=" far fa-edit"></i></td>
            </tr>`;
      });
      tableDoankem.innerHTML = tr;
    });
}
renderDoAnKem();
// =========== Them do an =============

const btnThemDoAn = document.querySelector("#btnThemDoAn");
const urlThemDoAn = "http://localhost:8080/api/doAnKem";

btnThemDoAn.addEventListener("click", () => {
  var img = document.querySelector("#fileImage").files[0];

  var form = new FormData();
  form.append("maDanhMucDoAn", selectDanhmuc.value);
  form.append("tenDoAn", document.querySelector("#tenDoAn").value);
  form.append("donGia", document.querySelector("#donGia").value);
  form.append("donViTinh", document.querySelector("#donViTinh").value);
  form.append("soLuongTon", document.querySelector("#soLuongTon").value);
  form.append("fileImage", img);

  const optionsThemDoAn = {
    method: "POST",
    body: form,
  };

  fetch(urlThemDoAn, optionsThemDoAn).then((resp) => {
    if (resp.status === 200) {
      tata.success("Thêm thành công", "Đã cập nhật");
      renderDoAnKem();
    } else tata.error("Thêm thất bại", "Vui lòng kiểm tra lại");
  });
});

/**
 *  Thêm danh mục đồ ăn
 */
const tenDanhMucDoAn = document.querySelector("#tenDanhMucDoAn");
const btnthemdanhmuc = document.querySelector("#btn-themdanhmuc");

btnthemdanhmuc.addEventListener("click", () => {
  fetch(
    "http://localhost:8080/api/danhMucDoAn?" +
      new URLSearchParams({ tenDanhMucDoAn: tenDanhMucDoAn.value }),
    {
      method: "POST",
    }
  )
    .then((res) => {
      if (res.ok) return res.json();
      else throw new Error("error");
    })
    .then((data) => {
      renderDanhMuc();
      tata.success("Thêm thành công", "Đã cập nhật");
    })
    .catch((error) => {
      tata.error("Thêm thất bại", "Vui lòng kiểm tra lại");
      console.log(error);
    });
});
