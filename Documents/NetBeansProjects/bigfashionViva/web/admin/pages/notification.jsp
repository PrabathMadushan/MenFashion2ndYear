

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="../assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
             Admin Portal
        </title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <!-- CSS Files -->
        <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="../assets/css/paper-dashboard.css?v=2.0.0" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="../assets/demo/demo.css" rel="stylesheet" />
    </head>

    <body class="">
        <div class="wrapper ">
            <div class="sidebar" data-color="white" data-active-color="danger">
                <!--
                  Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
                -->
                <div class="logo">
                    <a href="http://www.creative-tim.com" class="simple-text logo-mini">
                        <div class="logo-image-small">
                            <img src="../assets/img/logo-small.png">
                        </div>
                    </a>
                    <a href="http://www.creative-tim.com" class="simple-text logo-normal">
                        Creative Tim
                        <!-- <div class="logo-image-big">
                          <img src="../assets/img/logo-big.png">
                        </div> -->
                    </a>
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li>
                            <a href="./dashboard.jsp">
                                <i class="nc-icon nc-bank"></i>
                                <p>Dashboard</p>
                            </a>
                        </li>
                        <li>
                            <a href="./manageCategories.jsp">
                                <i class="nc-icon nc-bullet-list-67"></i>
                                <p>Manage Categories</p>
                            </a>
                        </li>
                        <li>
                            <a href="./manageProducts.jsp">
                                <i class="nc-icon nc-basket"></i>
                                <p>Manage Products</p>
                            </a>
                        </li>
                        <li>
                            <a href="./orders.jsp">
                                <i class="nc-icon nc-paper"></i>
                                <p>Orders</p>
                            </a>
                        </li>
                        <li>
                            <a href="./customers.jsp">
                                <i class="nc-icon nc-single-02"></i>
                                <p>Customers</p>
                            </a>
                        </li>
                        <li>
                            <a href="./settings.jsp">
                                <i class="nc-icon nc-settings-gear-65"></i>
                                <p>System Settings</p>
                            </a>
                        </li>
                        <li class="active">
                            <a href="./notification.jsp">
                                <i class="nc-icon nc-bell-55"></i>
                                <p>Notifications</p>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
                    <div class="container-fluid">
                        <div class="navbar-wrapper">
                            <div class="navbar-toggle">
                                <button type="button" class="navbar-toggler">
                                    <span class="navbar-toggler-bar bar1"></span>
                                    <span class="navbar-toggler-bar bar2"></span>
                                    <span class="navbar-toggler-bar bar3"></span>
                                </button>
                            </div>
                            <a class="navbar-brand" href="#pablo">Paper Dashboard 2</a>
                        </div>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-end" id="navigation">
                            <form>
                                <div class="input-group no-border">
                                    <input type="text" value="" class="form-control" placeholder="Search...">
                                    <div class="input-group-append">
                                        <div class="input-group-text">
                                            <i class="nc-icon nc-zoom-split"></i>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link btn-magnify" href="#pablo">
                                        <i class="nc-icon nc-layout-11"></i>
                                        <p>
                                            <span class="d-lg-none d-md-block">Stats</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="nav-item btn-rotate dropdown">
                                    <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="nc-icon nc-bell-55"></i>
                                        <p>
                                            <span class="d-lg-none d-md-block">Some Actions</span>
                                        </p>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                        <a class="dropdown-item" href="#">Action</a>
                                        <a class="dropdown-item" href="#">Another action</a>
                                        <a class="dropdown-item" href="#">Something else here</a>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link btn-rotate" href="#pablo">
                                        <i class="nc-icon nc-settings-gear-65"></i>
                                        <p>
                                            <span class="d-lg-none d-md-block">Account</span>
                                        </p>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div class="content">
                   
                </div>
                <footer class="footer footer-black  footer-white ">
                    <div class="container-fluid">
                        <div class="row">
                            <nav class="footer-nav">
                                <ul>
                                    <li>
                                        <a href="https://www.creative-tim.com" target="_blank">Creative Tim</a>
                                    </li>
                                    <li>
                                        <a href="http://blog.creative-tim.com/" target="_blank">Blog</a>
                                    </li>
                                    <li>
                                        <a href="https://www.creative-tim.com/license" target="_blank">Licenses</a>
                                    </li>
                                </ul>
                            </nav>
                            <div class="credits ml-auto">
                                <span class="copyright">
                                    ©
                                    <script>
                                        document.write(new Date().getFullYear())
                                    </script>, made with <i class="fa fa-heart heart"></i> by Creative Tim
                                </span>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <!--   Core JS Files   -->
        <script src="../assets/js/core/jquery.min.js"></script>
        <script src="../assets/js/core/popper.min.js"></script>
        <script src="../assets/js/core/bootstrap.min.js"></script>
        <script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!--  Google Maps Plugin    -->
        <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
        <!-- Chart JS -->
        <script src="../assets/js/plugins/chartjs.min.js"></script>
        <!--  Notifications Plugin    -->
        <script src="../assets/js/plugins/bootstrap-notify.js"></script>
        <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="../assets/js/paper-dashboard.min.js?v=2.0.0" type="text/javascript"></script>
        <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
        <script src="../assets/demo/demo.js"></script>
    </body>

</html>
