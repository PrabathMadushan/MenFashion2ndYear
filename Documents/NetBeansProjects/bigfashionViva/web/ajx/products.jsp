<%@page import="dbmodels.Product"%>
<%@page import="java.util.List"%>
<div class="row" >
    <%
        int pageCount = Integer.parseInt(request.getAttribute("pcount").toString());
        int cp = Integer.parseInt(request.getAttribute("cp").toString());
        List<Product> cs = (List<Product>) request.getAttribute("plist");
        for (Product c : cs) {
    %>
    <!-- Single Product Area -->
    <div class="col-12 col-sm-6 col-md-12 col-xl-6">
        <div class="single-product-wrapper" style="background-color: #f5f5f5;box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);">
            <!-- Product Image -->
            <div class="product-img">
                <img src="res/<%= c.getImage1()%>" alt="image1">
                <!-- Hover Thumb -->
                <img class="hover-img" src="res/<%= c.getImage2()%>" alt="">
            </div>
            <!-- Product Description -->
            <div style="padding-left:10px;padding-right: 10px; " class="product-description d-flex align-items-center justify-content-between">
                <!-- Product Meta Data -->
                <div class="product-meta-data">
                    <div class="line"></div>
                    <p class="product-price">Rs <%= c.getPrice()%> </p>
                    <a href="product-details.jsp">
                        <h6><%= c.getName()%></h6>
                    </a>
                </div>
                <!-- Ratings & Cart -->
                <div class="ratings-cart text-right">
                    <div class="ratings" ></div>
                    
                    <div class="cart">
                        <a onclick="addtocart(<%= c.getId()%>)" class="mcart" data-toggle="tooltip" data-placement="left" title="Add to Cart" style="font-size: 25px; color: #333333"><i class="fa fa-cart-plus xxx"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
<%
    if (cs.isEmpty()) {
%>
<div class="col-12 col-sm-12 col-md-12 col-xl-12">
    <div class="alert alert-warning" style="text-align: center">Sorry No Products Available For This Search...!</div>
</div>

<%
    }

%>

<div class="row">
    <div class="col-12">
        <!-- Pagination -->
        <nav aria-label="navigation">
            <ul class="pagination justify-content-end mt-50">
                <%                    for (int i = 1; i <= pageCount; i++) {
                %>

                <li onclick="searchProducts(<%=i%>)" class='page-item <%=(i == cp) ? "active" : ""%>'><a class="page-link" href="#"><%=i%>.</a></li>

                <%
                    }
                %>


            </ul>
        </nav>
    </div>
</div>


