package customer;

import dbmodels.Catogory;
import hiberate.HibernateUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

public class LoadCategoriesCus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Catogory.class);
        criteria.addOrder(Order.asc("id"));
        List<Catogory> list = criteria.list();
        int imax = (list.size() + 1);
        resp.getWriter().print("<li onclick=\"selectCategory('cat0', " + imax + ");\" id='cat0' class='itm-cat active'><a>All Products</a></li>");
        int i = 1;
        for (Catogory catogory : list) {
            resp.getWriter().print("<li id='cat" + i + "' onclick=\"selectCategory('cat" + i + "', " + imax + ");\"  class='itm-cat'><a>" + catogory.getName() + "</a></li>");
            i++;
        }
        session.close();
    }

}
