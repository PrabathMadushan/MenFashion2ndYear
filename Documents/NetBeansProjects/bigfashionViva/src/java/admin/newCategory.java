package admin;

import dbmodels.Catogory;
import hiberate.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class newCategory extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String des = req.getParameter("des");
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            Transaction transaction = session.beginTransaction();
            Catogory c = new Catogory();
            c.setName(name);
            c.setDescription(des);
            session.save(c);
            transaction.commit();
            session.close();
            resp.getWriter().print(true);
        } catch (IOException | HibernateException e) {
            resp.getWriter().print(false);
        }

    }

}
