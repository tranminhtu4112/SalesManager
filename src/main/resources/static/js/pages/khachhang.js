const tablekhachhang = document.querySelector("#table-khachhang");
const hotenkhachhang = document.querySelector("#hotenkhachhang");
const diachikhachhang = document.querySelector("#diachikhachhang");
const sdtkhachhang = document.querySelector("#sdtkhachhang");
const emailkhachhhang = document.querySelector("#emailkhachhhang");
const btnthemkhachahng = document.querySelector("#btn-themkhachahng");

function renderTableKhachHang() {
  fetch("http://localhost:8080/khachHang")
    .then((res) => {
      if (res.ok) return res.json();
      else console.log("error fetch khachhang");
    })
    .then((data) => {
      var tr = "",
        i = 0;
      data.forEach((ele) => {
        i++;
        tr += `<tr>
                    <td>${i}</td>
                    <td>${ele.hoTen}</td>
                    <td>${ele.diaChi}</td>
                    <td>${ele.soDienThoai}</td>
                    <td>${ele.email}</td>
                    <td><i style="cursor:pointer" class="far fa-trash-alt"></i></td>
                    <td><i class=" far fa-edit"></i></td>
                </tr>`;
      });
      tablekhachhang.innerHTML = tr;
    });
}
renderTableKhachHang();

btnthemkhachahng.addEventListener("click", () => {

  var form = new FormData();
  form.append("hoTen", hotenkhachhang.value);
  form.append("diaChi", diachikhachhang.value);
  form.append("soDienThoai", sdtkhachhang.value);
  form.append("email", emailkhachhhang.value);

  const optionsThemKhachHang = {
    method: "POST",
    body: form,
  };

  fetch("http://localhost:8080/khachHang", optionsThemKhachHang).then((resp) => {
    if (resp.status === 200) {
      tata.success("Thêm thành công", "Đã cập nhật");
      renderTableKhachHang();
    } else tata.error("Thêm thất bại", "Vui lòng kiểm tra lại");
  });
});
