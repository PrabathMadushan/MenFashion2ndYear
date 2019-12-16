package customer;

import dbmodels.Catogory;
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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

public class SearchProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final int product_count_in_one_page = 6;
        //?cat=all&size=all&minprice=0&maxprice=20000
        String cat = req.getParameter("cat");
        String size = req.getParameter("size");
        String min_price = req.getParameter("minprice");
        String max_price = req.getParameter("maxprice");
        int page = Integer.parseInt(req.getParameter("page"));

        System.out.println(cat);
        System.out.println(size);
        System.out.println(min_price);
        System.out.println(max_price);

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Product.class, "product");
        Criterion between;
        between = Restrictions.between("product.price", Float.parseFloat(min_price), Float.parseFloat(max_price));

        if (cat.equals("All Products")) {
            if (size.equals("All Sizes")) {
                criteria.add(Restrictions.and(between));
            } else {
                SimpleExpression rsize = Restrictions.eq("product.size", size);
                criteria.add(Restrictions.and(rsize, between));
            }
        } else {
            criteria.createAlias("product.catogoryId", "cat");
            SimpleExpression rcname = Restrictions.eq("cat.name", cat);
            if (size.equals("All Sizes")) {
                criteria.add(Restrictions.and(rcname, between));
            } else {
                SimpleExpression rsize = Restrictions.eq("product.size", size);
                criteria.add(Restrictions.and(rcname, rsize, between));
            }

        }
        criteria.addOrder(Order.asc("id"));
        int count = criteria.list().size();
        int page_count;
        if (count % product_count_in_one_page == 0) {
            page_count = count / product_count_in_one_page;
        } else {
            page_count = (count / product_count_in_one_page) + 1;
        }
        criteria.setMaxResults(product_count_in_one_page);
        criteria.setFirstResult(product_count_in_one_page * (page - 1));
        List<Product> list = criteria.list();
        req.setAttribute("plist", list);
        req.setAttribute("pcount", page_count);
        req.setAttribute("cp", page);

        req.getRequestDispatcher("ajx/products.jsp").include(req, resp);

    }

}
