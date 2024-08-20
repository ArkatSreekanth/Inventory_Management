
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class Createcon {
    public static void main(String[] args) {
        try{
            String url="jdbc:mysql://localhost:3306/Project";
            String user="root";
            String pass="root";
            Connection con=DriverManager.getConnection(url,user,pass);
            System.out.println("Connected");
            String c_table="create table Bus_Management(b_id int primary key,bus_no int not null,st_point varchar(50) not null,bus_fees int not null)";
            Statement s=con.createStatement();
            s.executeUpdate(c_table);
            System.out.println("table created sucessfully");
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}
