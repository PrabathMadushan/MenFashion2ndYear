<jsp:include page="inc/authCheck.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Men Fashion | Register</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                background-color: #f5f5f5;
            }
            .login-wraper{
                margin: auto;

            }
            .minput{
                display: block;
                width: 100%;
                height: 50px;
                border: solid 1px #f5a20f;
                padding-left: 10px;

            }
            .minput:focus{
                border: solid 1px #f5a20f;
            }

            /*            label{
                            margin-top: 20px;
                        }*/
            .mbtn{
                margin-top: 10px;
                height: 40px;
                padding-left: 20px;
                padding-right: 20px;
                background-color: #333333;
                border-radius: 0px;
                color: whitesmoke;
            }
            .mbtn:hover{
                background-color: #f5a20f;
            }
            .btnw{
                text-align: right;
            }
            .btnw2{
                text-align: center;
            }
        </style>
    </head>

    <body>
        <div class="login-wraper col-md-5">
            <div class="form-group btnw2">
                <i class="fa fa-anchor"></i>    
                <h2>Men Fashion</h2>
                <h5>REGISTER</h5>
<!--                <img src="img/core-img/logo.png" alt="logo">-->
            </div>
            <div class="form-group">
                <label>Name</label>
                <input id="name" class="minput" type="text" placeholder="Email" >
            </div>
            <div class="form-group">
                <label>Email</label>
                <input id="email" class="minput" type="email" placeholder="Email" >
            </div>
            <div class="form-group">
                <label>Password</label>
                <input id="password" class="minput" type="password" placeholder="Email" >
            </div>
            <div class="form-group">
                <label>Address</label>
                <textarea id="address" class="minput" placeholder="Address" ></textarea>
            </div>
            <div class="form-group">
                <label>Contact</label>
                <input id="contact" class="minput" type="text" placeholder="Email" >
            </div>
            <div class="form-group btnw">
                <button  class="btn mbtn" >Cancel</button>
                <button onclick="saveCustomer()" class="btn mbtn" >Register</button>
            </div>
        </div>
        <script src="js/jquery/jquery-2.2.4.min.js" type="text/javascript"></script>
        <script src="js/register.js" type="text/javascript"></script>
    </body>

</html>