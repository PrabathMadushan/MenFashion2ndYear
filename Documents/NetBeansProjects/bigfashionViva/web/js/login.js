function login() {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    $.post("CusLogin", {
        email: email,
        password: password
    }, (data, status) => {
        alert('ok')
        location.reload();
        
    });
}


