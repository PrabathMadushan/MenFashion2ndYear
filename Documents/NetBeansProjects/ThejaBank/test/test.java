
import Database.DBConnection;
import java.sql.ResultSet;


public class test {
    
    public static void main(String[] args) throws Exception {
        String sql="SELECT * FROM USER";
        ResultSet data = DBConnection.getData(sql);
        while(data.next()){
            String name = data.getString("name");
            System.out.println(name);
        }
    }
}
