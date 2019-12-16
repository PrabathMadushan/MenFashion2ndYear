<%@page import="dbmodels.Catogory"%>
<%@page import="java.util.List"%>
<%
    List<Catogory> cs = (List<Catogory>) request.getAttribute("clist");
    for (Catogory c : cs) {
%>
<tr>
    <td>
        <%=c.getName()%>
    </td>
    <td>
        <%=c.getDescription() %>
    </td>
    <td  class="text-center">
        <button class="btn btn-dark btn-sm">update</button>
    </td>
</tr>

<%
    }
%>

