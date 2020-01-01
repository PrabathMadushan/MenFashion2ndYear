package customer.other;

import dbmodels.Cart;
import dbmodels.Customer;
import java.util.ArrayList;

public class CusAuth {

    public static final String SESSION = "Cus_Auth";
    private Customer customer;
    private boolean auth;
    private final Cart session_cart;

    public CusAuth() {
        session_cart = new Cart();
        session_cart.setId((int)System.currentTimeMillis());
        session_cart.setCustomerId(customer);
        session_cart.setCartItemsCollection(new ArrayList<>());
        auth = false;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        session_cart.setCustomerId(customer);
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public Cart getSession_cart() {
        return session_cart;
    }

}
