package admin;

import dbmodels.Cart;
import dbmodels.Product;
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
import org.hibernate.criterion.Restrictions;

public class LoadOrders extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Cart.class);
        if (!"ALL".equals(status)) {
            criteria.add(Restrictions.eq("status", status));
        }
        List<Cart> list = criteria.list();
        req.setAttribute("olist", list);
        req.getRequestDispatcher("admin/ajx/orders.jsp").include(req, resp);
    }

}
