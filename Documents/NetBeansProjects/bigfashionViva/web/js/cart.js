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
}


function calcSubTotal() {
    var x = document.getElementById("tblcart").rows.length - 1;
    var total = 0;
    for (var i = 1; i <= x; i++) {
        var price = document.getElementById("price" + i).innerHTML;
        var qnt = document.getElementById(document.getElementById("qnty" + i).innerHTML).value;
        total += (price * qnt);
    }
    document.getElementById("total").innerHTML = total;
}

function chackOut() {
    $.post("Checkout", null, (data, status) => {
        if (data === 'false') {
            window.location.replace("login.jsp");
        } else {
            iziToast.show({
                title: 'Checkout:',
                message: 'Cart items are cheked out',
                position: 'topRight',
                color: '', // blue, red, green, yellow
                timeout: 1500,
                theme: 'dark', // dark
                onClosed: function () {
                     window.location.replace("shop.jsp");
                }
            });
        }
    });
}