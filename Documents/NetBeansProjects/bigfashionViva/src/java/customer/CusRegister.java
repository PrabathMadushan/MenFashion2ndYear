package customer;

import dbmodels.Customer;
import hiberate.HibernateUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CusRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setContact(contact);
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            resp.getWriter().print(true);
        } catch (Exception e) {
            resp.getWriter().print(false);
            e.printStackTrace();
        }
        session.close();
    }

}
