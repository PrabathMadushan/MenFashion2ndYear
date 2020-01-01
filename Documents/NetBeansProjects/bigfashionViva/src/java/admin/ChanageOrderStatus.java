package admin;

import customer.CartStatus;
import dbmodels.Cart;
import dbmodels.Catogory;
import hiberate.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ChanageOrderStatus extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String status = req.getParameter("status");
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Cart.class);
        criteria.add(Restrictions.eq("id", Integer.parseInt(id)));
        Cart cart = (Cart) criteria.uniqueResult();
        if (CartStatus.CANCELED.toString().equals(status)) {
            cart.setStatus(CartStatus.CANCELED.toString());
        } else if (CartStatus.PENDING.toString().equals(status)) {
            cart.setStatus(CartStatus.PENDING.toString());
        } else if (CartStatus.FINSHIED.toString().equals(status)) {
            cart.setStatus(CartStatus.FINSHIED.toString());
        }
        Transaction transaction = session.beginTransaction();
        session.update(cart);
        transaction.commit();
        session.close();
       
    }

}
