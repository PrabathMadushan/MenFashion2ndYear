<%@page import="customer.other.CusAuth"%>
<%
    Object oco = session.getAttribute(CusAuth.SESSION);
    if (oco == null) {
        CusAuth auth = new CusAuth();
        auth.setAuth(false);
        session.setAttribute(CusAuth.SESSION, auth);
    }
%>
