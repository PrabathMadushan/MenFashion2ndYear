package bank;

import Database.DBConnection;

public class Bank {

    private User user;
    private boolean isAuth;

    public void auth(String username, String password) {
        //Auth user with database
    }

    public void registerUser(User user) {
        if (isAuth && UserType.MANAGER.equals(user.getType())) {
            try {
//                 String sql = "Insert into user(name,password,nic,contact,type) values("
//                    + "'" + user.getName() + "',"
//                    + "'" + user.getPassword() + "',"
//                    + "'" + user.getNic() + "',"
//                    + "'" + user.getType().toString() + "',"
//                    + ")";
//            DBConnection.updateData(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
           
        } else {

        }
    }

    public void registerHolder(AccountHolder holder) {
        if (isAuth && UserType.MANAGER.equals(user.getType())) {
                //code: databse write
        } else {

        }
    }

    public void oppenSavingAccount(SavingsAccount account) {
        if (isAuth && UserType.MANAGER.equals(user.getType())) {
                 //code: databse write
        } else {

        }
    }

    public void oppenFixedAccount(FixedDepositAccount account) {
        if (isAuth && UserType.MANAGER.equals(user.getType())) {
                 //code: databse write
        } else {

        }
    }

    public void deposit(SavingsAccount account, Double amount) {
        if (isAuth) {
                 //code: databse write
        }
    }

    public void withdraw(SavingsAccount account, Double amount) {
        if (isAuth) {
             //code: databse write
        }
    }
    
    public void signOut(){
        isAuth=false;
        user=null;
    }

}
