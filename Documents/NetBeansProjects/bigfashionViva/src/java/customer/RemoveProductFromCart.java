
package customer;

import customer.other.CusAuth;
import dbmodels.Cart;
import dbmodels.CartItems;
import dbmodels.Product;
import hiberate.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


public class RemoveProductFromCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Product.class);
        criteria.add(Restrictions.eq("id", pid));
        Product product = (Product) criteria.uniqueResult();
        HttpSession httpSession = req.getSession();
        CusAuth auth = (CusAuth) httpSession.getAttribute(CusAuth.SESSION);
        Cart session_cart = auth.getSession_cart();
        Collection<CartItems> items = session_cart.getCartItemsCollection();
        CartItems item = null;
        for (CartItems i : items) {
            if (Objects.equals(i.getProductId().getId(), product.getId())) {
                item = i;
                break;
            }
        }
        if (item!=null) {
            item.setQnt(item.getQnt()+1);
        } else {
            CartItems citem = new CartItems();
            citem.setProductId(product);
            citem.setQnt(1);
            session_cart.getCartItemsCollection().add(citem);
        }

        if (auth.isAuth()) {

        }

    }

}
