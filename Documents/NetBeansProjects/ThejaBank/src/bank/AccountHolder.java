
package bank;

import java.util.ArrayList;
import java.util.List;



public class AccountHolder {
    private final int id;
    private String nic;
    private String name;
    private String contact;
    private String address;
    private List<Account> accounts;

    public AccountHolder(int id) {
        this.id=id;
    }

    
    public AccountHolder(int id, String nic, String name, String contact, String address) {
        this.id = id;
        this.nic = nic;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }
    
    

    public int getId() {
        return id;
    }

 

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    
    
    
}
