$(document).ready(function(){
    loadCartItems();
});

function loadCartItems() {
    $.post("LoadCart", null, (data, status) => {
        document.getElementById("cartitems").innerHTML = data;
    });
}

function addQnty(pid){
     $.post("AddQnty", {
         pid:pid
     }, (data, status) => {
        document.getElementById("qty"+pid).value = data;
    });
}


function removeQnty(pid){
     $.post("RemoveQnty", {
         pid:pid
     }, (data, status) => {
        document.getElementById("qty"+pid).value = data;
    });
}