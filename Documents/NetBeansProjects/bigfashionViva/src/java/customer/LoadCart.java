package customer;

import customer.other.CusAuth;
import dbmodels.Cart;
import dbmodels.CartItems;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CusAuth auth = (CusAuth) req.getSession().getAttribute(CusAuth.SESSION);
        Cart session_cart = auth.getSession_cart();
        Collection<CartItems> items = session_cart.getCartItemsCollection();
        req.setAttribute("citems", items);
        req.getRequestDispatcher("ajx/cartitems.jsp").forward(req, resp);
    }

}
