package admin;

import admin.others.Auth;
import dbmodels.Mysystem;
import hiberate.HibernateUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        String rememberMe = req.getParameter("rememberme");

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Mysystem.class);
        List<Mysystem> list = criteria.list();
        if (list.size() > 0) {
            Mysystem system = list.get(0);
            if (email.equals(system.getEmail()) && password.equals(system.getPassword())) {
                HttpSession httpSession = req.getSession();
                Auth auth=new Auth();
                auth.setSystem(system);
                httpSession.setAttribute(Auth.SESSION, auth);
                resp.getWriter().print(true);
            } else {
                resp.getWriter().print(false);
            }
        }
        session.close();
    }

}
