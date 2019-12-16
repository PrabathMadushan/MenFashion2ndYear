<%@page import="dbmodels.CartItems"%>
<%@page import="java.util.Collection"%>
<%
    Collection<CartItems> items = (Collection<CartItems>) request.getAttribute("citems");
    for (CartItems item : items) {
%>
<tr>
    <td class="cart_product_img">
        <a href="#"><img src="res/<%= item.getProductId().getImage1()%>" alt="Product"></a>
    </td>
    <td class="cart_product_desc">
        <h5><%= item.getProductId().getName()%></h5>
    </td>
    <td class="price">
        <span>Rs <%= item.getProductId().getPrice()%></span>
    </td>
    <td class="qty">
        <div class="qty-btn d-flex">
            <p>Qnty</p>
            <div class="quantity">
                <span onclick="removeQnty(<%= item.getProductId().getId()%>)" class="qty-minus"><i class="fa fa-minus" aria-hidden="true"></i></span>
                <input type="number" class="qty-text" id="qty<%= item.getProductId().getId()%>" step="1" min="1" max="300" name="quantity" value="<%= item.getQnt()%>">
                <span onclick="addQnty(<%= item.getProductId().getId()%>)" class="qty-plus"><i class="fa fa-plus" aria-hidden="true"></i></span>
            </div>
        </div>
    </td>
</tr>

<%
    }
%>
