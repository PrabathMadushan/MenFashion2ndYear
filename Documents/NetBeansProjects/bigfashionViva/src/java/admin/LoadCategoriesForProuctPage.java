
package admin;

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
import org.hibernate.criterion.Order;


public class LoadCategoriesForProuctPage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Catogory.class);
        criteria.addOrder(Order.asc("id"));
        List<Catogory> list = criteria.list();
        for (Catogory catogory : list) {
            resp.getWriter().print("<option >"+catogory.getName()+"</option>");
        }
    }
   
}
