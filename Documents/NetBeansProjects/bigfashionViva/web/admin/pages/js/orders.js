var statusx = 'ALL';

$(document).ready(function () {
    loadOrders()
});

function loadOrders() {
    $.post("../../LoadOrders", {
        status: statusx
    }, (data, status) => {
        //document.getElementById("tblcategories").innerHTML=data;
        $("#orders").html(data);

    });
}

function changeStatus(status) {
    statusx = status;
    loadOrders();
}

function chengeStatus(id, status) {
    $.post("../../ChanageOrderStatus", {
        id: id,
        status: status
    }, (data, status) => {
        loadOrders();
    });
}

function viewItems(id) {

}
