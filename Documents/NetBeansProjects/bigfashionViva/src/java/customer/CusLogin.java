package customer;

import customer.other.CusAuth;
import dbmodels.Customer;
import hiberate.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

@WebServlet(name = "CusLogin", urlPatterns = {"/CusLogin"})
public class CusLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Customer.class);
        SimpleExpression r_email = Restrictions.eq("email", email);
        SimpleExpression r_password = Restrictions.eq("password", password);
        LogicalExpression res = Restrictions.and(r_email,r_password);
        criteria.add(res);
        Object oCustomer = criteria.uniqueResult();
        if (oCustomer!=null) {
            //login oks
            HttpSession httpSession = req.getSession();
            CusAuth auth=(CusAuth)httpSession.getAttribute(CusAuth.SESSION);
            auth.setAuth(true);
            auth.setCustomer(((Customer)oCustomer));
            //copy all cart items in session cart to database
            
        }
        session.close();
    }

}
