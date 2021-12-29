const btnSubmit = document.querySelector('#btn-submit');
const image = document.querySelector('#image');

const url = "http://localhost:8080/doAnKem";

btnSubmit.addEventListener('click', () => {

    var img = image.files[0];

    var form = new FormData()
    form.append("maDanhMucDoAn", 1)
    form.append("tenDoAn", 1)
    form.append("donGia", 1)
    form.append("donViTinh", 1)
    form.append("soLuongTon", 1)
    form.append("fileImage", img)

    const options = {
      method: 'POST',

      body: form
    };
    fetch(url, options)
    .then(resp => console.log(resp.body))
    .catch(err => console.log(`err`, err))
})

