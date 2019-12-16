<%@page import="dbmodels.Product"%>
<%@page import="java.util.List"%>
<%
    List<Product> cs = (List<Product>) request.getAttribute("plist");
    for (Product c : cs) {
%>
<tr>
    <td>
        <%=c.getName()%>
    </td>
    <td>
        <%=c.getDescription()%>
    </td>
    <td>
        <%=c.getPrice()%>
    </td>
    <td>
        <%=c.getQnt()%>
    </td>
    <td>
        <%=c.getCatogoryId().getName()%>
    </td>
    <td>
        <%=c.getSize()%>
    </td>
    <td  class="text-center">
        <button class="btn btn-primary btn-sm">Add</button>
        <button class="btn btn-danger btn-sm">Remove</button>
        <button class="btn btn-dark btn-sm" onclick="showModel('<%= c.getImage1() %>','<%= c.getImage2() %>')">Images</button>
    </td>
</tr>




<%
    }
%>

