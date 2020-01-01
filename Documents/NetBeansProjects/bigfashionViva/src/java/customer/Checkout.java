package customer;

import customer.other.CusAuth;
import dbmodels.Cart;
import dbmodels.CartItems;
import dbmodels.Customer;
import hiberate.HibernateUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Checkout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //if customer is loged in or not
        HttpSession httpSession = req.getSession();
        CusAuth auth = (CusAuth) httpSession.getAttribute(CusAuth.SESSION);
        if (!auth.isAuth()) {
            resp.getWriter().print("false");
        } else {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            System.out.println(auth.getSession_cart().getCustomerId());
            Cart session_cart = auth.getSession_cart();
            session_cart.setDatetime(new Date());
            session_cart.setStatus(CartStatus.PENDING.toString());
            Collection<CartItems> items = session_cart.getCartItemsCollection();
            session_cart.setCartItemsCollection(new ArrayList<>());
            Transaction transaction = session.beginTransaction();
            session.save(auth.getSession_cart());
            transaction.commit();
            Transaction transaction1 = session.beginTransaction();
            for (CartItems item : items) {
                session.save(item);
            }
            transaction1.commit();
            session.close();
            resp.getWriter().print("true");
        }
    }

}
