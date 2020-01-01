$(document).ready(function () {
    loadCartItems();
});

function loadCartItems() {
    $.post("LoadCart", null, (data, status) => {
        document.getElementById("cartitems").innerHTML = data;
        calcSubTotal();
    });
}

function addQnty(pid) {
    $.post("AddQnty", {
        pid: pid
    }, (data, status) => {
        document.getElementById("qty" + pid).value = data;
        calcSubTotal();
    });
}


function removeQnty(pid) {
    $.post("RemoveQnty", {
        pid: pid
    }, (data, status) => {
        document.getElementById("qty" + pid).value = data;
        calcSubTotal();
    });



    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            alert(xhr.responseText);
        }
    };
    xhr.open("post", "RemoveQnty", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("id=" + pid);
}


function calcSubTotal() {
    var x = document.getElementById("tblcart").rows.length - 1;
    var total = 0;
    for (i = 1; i <= x; i++) {
        var price = document.getElementById("price" + i).innerHTML;
        var qnt = document.getElementById("qty" + i).value;
        total += (price * qnt);
        console.log(price + " x " + qnt + " = " + (price * qnt))
    }
    document.getElementById("total").innerHTML = total;
}