var selected_category = "All Products";
var selected_size = "All Sizes";
var selected_minprice = 100;
var selected_maxprice = 50000;

function selectCategory(id, max) {

    id = '#' + id;
    for (var i = 0; i < max; i++) {
        var xid = '#cat' + i;
        if (id !== xid) {
            $(xid).removeClass('active');
        } else {
            $(id).addClass('active');
            selected_category = $(id).children('a').html();
        }
    }

    searchProducts(1);
}

function selectSize(id) {
    id = '#' + id;
    for (var i = 0; i < 6; i++) {
        var xid = '#size' + i;
        if (id !== xid) {
            $(xid).removeClass('active');
        } else {
            $(id).addClass('active');
            selected_size = $(id).children('a').html();
        }
    }

    searchProducts(1);
}

function selectPrice(min, max) {
    selected_minprice = min;
    selected_maxprice = max;
}

$(document).ready(() => {
    loadCategories();
    searchProducts(1);
    selectPrice();

});
function loadCategories() {
    $.get("LoadCategoriesCus", null, (data, status) => {
        //document.getElementById("tblcategories").innerHTML=data;
        $("#categories").html(data);
    });
}

function searchProducts(page) {

    if (selected_minprice === undefined) {
        selected_minprice = 100;
    }
    if (selected_maxprice === undefined) {
        selected_maxprice = 30000;
    }
    console.log("min:" + selected_minprice, "max:" + selected_maxprice)
    $.get("SearchProduct", {
        cat: selected_category,
        size: selected_size,
        minprice: selected_minprice,
        maxprice: selected_maxprice,
        page: page
    }, (data, status) => {
        //document.getElementById("tblcategories").innerHTML=data;
        $("#products").html(data);

    });

    $('#sinfor').html("<b>Selected Category:</b>" + selected_category + " | " + "<b>Selected Size:</b>" + selected_size + " | " + "<b>Price From</b> Rs " + selected_minprice + " to Rs " + selected_maxprice);
}

function addtocart(id) {
    $.post("AddProductToCart", {
        pid: id
    }, (data, status) => {
        document.getElementById("citemcount").innerHTML="("+data+")";
    });
}

function updateCartIcon() {

}