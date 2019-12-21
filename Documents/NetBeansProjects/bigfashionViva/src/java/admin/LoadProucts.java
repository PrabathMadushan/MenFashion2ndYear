package admin;

import dbmodels.Product;
import hiberate.HibernateUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoadProucts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        List<Product> list = session.createCriteria(Product.class).list();
        req.setAttribute("plist", list);
        req.getRequestDispatcher("admin/ajx/products.jsp").include(req, resp);
    }
}