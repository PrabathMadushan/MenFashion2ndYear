function saveCustomer() {
    var name = $('#name').val();
    var email = $('#email').val();
    var password = $('#password').val();
    var address = $('#address').val();
    var contact = $('#contact').val();
    $.post("CusRegister", {
        name: name,
        email: email,
        password: password,
        address: address,
        contact: contact
    }, (data, status) => {
        alert(data);
    });
}