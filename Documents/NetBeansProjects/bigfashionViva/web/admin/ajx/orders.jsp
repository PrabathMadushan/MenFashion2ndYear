<%@page import="customer.CartStatus"%>
<%@page import="dbmodels.Cart"%>
<%@page import="java.util.List"%>
<%
    List<Cart> cs = (List<Cart>) request.getAttribute("olist");
    for (Cart c : cs) {
%>
<tr>
    <td>
        <%=c.getId()%>
    </td>
    <td>
        <%=c.getCustomerId().getName()%>
    </td>
    <td>
        <%=c.getStatus()%>
    </td>
    <td  class="text-center">
        <%
            if (CartStatus.CANCELED.toString().equals(c.getStatus())) {
        %>
        <button onclick="chengeStatus('<%=c.getId()%>', '<%=CartStatus.PENDING.toString()%>')" class="btn btn-primary btn-sm">Pending</button>
        <button onclick="chengeStatus('<%=c.getId()%>', '<%=CartStatus.FINSHIED.toString()%>')"class="btn btn-danger btn-sm">Finished</button>
        <%
        } else if (CartStatus.PENDING.toString().equals(c.getStatus())) {
        %>
        <button onclick="chengeStatus('<%=c.getId()%>', '<%=CartStatus.FINSHIED.toString()%>')" class="btn btn-primary btn-sm">Finished</button>
        <button onclick="chengeStatus('<%=c.getId()%>', '<%=CartStatus.CANCELED.toString()%>')"class="btn btn-danger btn-sm">Canceled</button>
        <%
        } else if (CartStatus.FINSHIED.toString().equals(c.getStatus())) {
        %>
        <button onclick="chengeStatus('<%=c.getId()%>', '<%=CartStatus.PENDING.toString()%>')" class="btn btn-primary btn-sm">Pending</button>
        <button onclick="chengeStatus('<%=c.getId()%>', '<%=CartStatus.CANCELED.toString()%>')"class="btn btn-danger btn-sm">Canceled</button>
        <%
            }
        %>
        <button onclick="viewItems('<%=c.getId()%>')" class="btn btn-default btn-sm">View Items</button>
    </td>
</tr>
<%
    }
%>

