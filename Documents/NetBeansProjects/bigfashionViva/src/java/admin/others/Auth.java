package admin.others;

import dbmodels.Mysystem;

public class Auth {

    public static final String SESSION = "Admin_Auth";
    private Mysystem system;
    private boolean auth;
    public Auth() {
    }

    public Auth(Mysystem system) {
        this.system = system;
    }

    public Mysystem getSystem() {
        return system;
    }

    public void setSystem(Mysystem system) {
        this.system = system;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }
    
    

}
