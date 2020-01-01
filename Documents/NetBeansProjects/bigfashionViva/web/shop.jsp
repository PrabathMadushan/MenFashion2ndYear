<%@page import="dbmodels.CartItems"%>
<%@page import="java.util.Collection"%>
<%@page import="dbmodels.Cart"%>
<%@page import="customer.other.CusAuth"%>
<jsp:include page="inc/authCheck.jsp"></jsp:include>
<%
    CusAuth auth = (CusAuth) session.getAttribute(CusAuth.SESSION);
    Cart session_cart = auth.getSession_cart();
    Collection<CartItems> cic = session_cart.getCartItemsCollection();
%>    

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Title  -->
        <title>Big Fashion | Shop</title>

        <!-- Favicon  -->
        <link rel="icon" href="img/core-img/favicon.ico">

        <!-- Core Style CSS -->
        <link rel="stylesheet" href="css/core-style.css">
        <link rel="stylesheet" href="style.css">
        <link href="css/iziToast.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!-- Search Wrapper Area Start -->

        <!-- Search Wrapper Area End -->

        <!-- ##### Main Content Wrapper Start ##### -->
        <div class="main-content-wrapper d-flex clearfix">

            <!-- Mobile Nav (max width 767px)-->
            <div class="mobile-nav">
                <!-- Navbar Brand -->
                <div class="amado-navbar-brand">
                    <a href="index.jsp"><img src="img/core-img/logo.png" alt=""></a>
                </div>
                <!-- Navbar Toggler -->
                <div class="amado-navbar-toggler">
                    <span></span><span></span><span></span>
                </div>
            </div>

            <!-- Header Area Start -->
            <header class="header-area clearfix">
                <!-- Close Icon -->
                <div class="nav-close">
                    <i class="fa fa-close" aria-hidden="true"></i>
                </div>
                <!-- Logo -->
                <div class="logo">
                    <a href="index.jsp"><img src="img/core-img/logo.png" alt=""></a>
                </div>
                <!-- Amado Nav -->
                <nav class="amado-nav">
                    <ul>
                        <li><a href="index.jsp">Home</a></li>
                        <li class="active"><a href="shop.jsp">Shop</a></li>
                        <!--<li><a href="product-details.jsp">Product</a></li>-->
                        <li><a href="cart.jsp">Cart <span id="citemcount">(<%=cic.size()%>)</span></a></li>
                    </ul>
                </nav>
                <!-- Button Group -->
                <div class="amado-btn-group mt-30 mb-100">
                    <a href="#" class="btn amado-btn mb-15">Login</a>
                    <a href="register.jsp" class="btn amado-btn active">Register</a>
                </div>
                <!-- Cart Menu -->
                <div class="cart-fav-search mb-100">

                </div>
                <!-- Social Button -->
                <div class="social-info d-flex justify-content-between">
                    <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                </div>
            </header>
            <!-- Header Area End -->

            <div class="shop_sidebar_area" style="padding-top: 20px;">

                <!-- ##### Single Widget ##### -->
                <div class="widget catagory mb-50">
                    <!-- Widget Title -->
                    <h6 class="widget-title mb-30">Catagories</h6>

                    <!--  Catagories  -->
                    <div class="catagories-menu">
                        <ul id="categories">

                        </ul>
                    </div>
                </div>

                <!-- ##### Single Widget ##### -->
                <div class="widget brands mb-50">
                    <!-- Widget Title -->
                    <h6 class="widget-title mb-30">Sizes</h6>

                    <div class="catagories-menu">
                        <ul>
                            <li id="size0" onclick="selectSize('size0')" class="active"><a href="#">All Sizes</a></li>
                            <li id="size1" onclick="selectSize('size1')"><a href="#">M</a></li>
                            <li id="size2" onclick="selectSize('size2')"><a href="#">L</a></li>
                            <li id="size3" onclick="selectSize('size3')"><a href="#">XL</a></li>
                            <li id="size4" onclick="selectSize('size4')"><a href="#">XXL</a></li>
                        </ul>
                    </div>

                </div>

                <!-- ##### Single Widget ##### -->
                <div class="widget color mb-50">
                    <div class="widget-desc">
                    </div>
                </div>

                <!-- ##### Single Widget ##### -->
                <div class="widget price mb-50">
                    <!-- Widget Title -->
                    <h6 class="widget-title mb-30">Price</h6>

                    <div class="widget-desc">
                        <div class="slider-range">
                            <div data-min="100" data-max="30000" data-unit="Rs" class="slider-range-price ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all" data-value-min="100" data-value-max="30000" data-label-result="">
                                <div class="ui-slider-range ui-widget-header ui-corner-all"></div>
                                <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0"></span>
                                <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0"></span>
                            </div>
                            <div class="range-price" style="font-size: 12px">RS 100 - RS 30000</div>

                        </div>
                    </div>
                </div>
                <!-- ##### Single Widget ##### -->
                <div class="widget price mb-50">
                    <!-- Widget Title -->
                    <div class="widget-desc">
                        <a href="#top" onclick="searchProducts(1)" style="width: 100%" class="btn amado-btn btn-sm">Search</a>
                    </div>
                </div>
            </div>

            <div class="amado_product_area section-padding-100" style="padding-top: 20px;">
                <div class="container-fluid">


                    <p class="" id="sinfor" style="font-size: 10px; background-color:  #f5f5f5;padding: 5px;"></p>
                    <div id="products">

                    </div>

                </div>
            </div>
        </div>
        <!-- ##### Main Content Wrapper End ##### -->

        <!-- ##### Newsletter Area Start ##### -->

        <!-- ##### Newsletter Area End ##### -->

        <!-- ##### Footer Area Start ##### -->
        <footer class="footer_area clearfix">
            <div class="container">
                <div class="row align-items-center">
                    <!-- Single Widget Area -->
                    <div class="col-12 col-lg-4">
                        <div class="single_widget_area">
                            <!-- Logo -->
                            <div class="footer-logo mr-50">
                                <a href="index.jsp"><img src="img/core-img/logo2.png" alt=""></a>
                            </div>
                            <!-- Copywrite Text -->
                            <p class="copywrite">
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved 
                        </div>
                    </div>
                    <!-- Single Widget Area -->
                    <div class="col-12 col-lg-8">
                        <div class="single_widget_area">
                            <!-- Footer Menu -->
                            <div class="footer_menu">
                                <nav class="navbar navbar-expand-lg justify-content-end">
                                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#footerNavContent" aria-controls="footerNavContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
                                    <div class="collapse navbar-collapse" id="footerNavContent">
                                        <ul class="navbar-nav ml-auto">
                                            <li class="nav-item active">
                                                <a class="nav-link" href="index.jsp">Home</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="shop.jsp">Shop</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="cart.jsp">Cart<span id="citemcount">(<%=cic.size()%>)</span></a>
                                            </li>
                                        </ul>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- ##### Footer Area End ##### -->

        <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
        <script src="js/jquery/jquery-2.2.4.min.js"></script>
        <!-- Popper js -->
        <script src="js/popper.min.js"></script>
        <!-- Bootstrap js -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Plugins js -->
        <script src="js/plugins.js"></script>
        <!-- Active js -->
        <script src="js/iziToast.js" type="text/javascript"></script>
        <script src="js/shop.js"></script>
        <script src="js/active.js"></script>


    </body>

</html>