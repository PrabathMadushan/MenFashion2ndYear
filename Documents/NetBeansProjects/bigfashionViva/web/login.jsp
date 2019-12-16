<jsp:include page="inc/authCheck.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Men Fashion | Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                background-color: #f5f5f5;
            }
            .login-wraper{
                margin: auto;
                margin-top: 10%;

            }
            input{
                display: block;
                width: 100%;
                height: 50px;
                border: solid 1px #f5a20f;
                padding-left: 10px;

            }
            input:focus{
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

        
        <div class="login-wraper col-md-4">
            <div class="form-group btnw2">
                <i class="fa fa-anchor"></i>    
            <h2>Men Fashion</h2>
            <h5>LOGIN</h5>
        </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" placeholder="Email" >
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="email" placeholder="Email" >
            </div>
            <div class="form-group btnw">
                <button class="btn mbtn" >Login</button>
            </div>
        </div>

    </body>

</html>