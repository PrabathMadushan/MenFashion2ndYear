package admin;

import dbmodels.Catogory;
import hiberate.HibernateUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoadCategories extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        List<Catogory> list = session.createCriteria(Catogory.class).list();
        req.setAttribute("clist", list);
        req.getRequestDispatcher("admin/ajx/categories.jsp").include(req, resp);
    
    }

}
