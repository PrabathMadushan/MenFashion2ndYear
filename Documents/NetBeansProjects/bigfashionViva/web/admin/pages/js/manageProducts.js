$(document).ready(() => {
    loadCategories();
    loadProducts()
});



function saveProduct() {
    var file1 = document.getElementById("image01").files;
    var file2 = document.getElementById("image02").files;
    var name = document.getElementById("name").value;
    var des = document.getElementById("des").value;
    var size = document.getElementById("size").value;
    var category = document.getElementById("category").value;
    var price = document.getElementById("price").value;
    var qnty = document.getElementById("qnty").value;

//    alert(name);
//    alert(file.length);
//    alert(file[0].name);

    var form = new FormData();
    form.append("name", name);
    form.append("des", des);
    form.append("size", size);
    form.append("category", category);
    form.append("price", price);
    form.append("qnty", qnty);

    form.append("image1", file1[0]);

    form.append("image2", file2[0]);

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            demo.showNotification('top', 'right', 'New Product ' + name + ' is Saved');
        } else {

        }
    };

    request.open("POST", "../../NewProduct", true);
//    request.setRequestHeader("Content-Type","application/x-www-from-urlencoded");
    request.send(form);

}
function loadCategories() {
    $.post("../../LoadCategoriesForProuctPage", null, (data, status) => {
        //document.getElementById("tblcategories").innerHTML=data;
        $("#category").html(data);

    });
}

function loadProducts() {
    $.get("../../LoadProucts", null, (data, status) => {
        //document.getElementById("tblcategories").innerHTML=data;
        $("#products").html(data);

    });
}

function showModel(image1, image2) {
    $('#imagep').html("\
<img src='../../res/" + image1 + "' alt='image'>\n\
<img src='../../res/" + image2 + "' alt='image'>\n\
");
    $('#imageModel').modal('show');
}
