import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class insert {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/Project";
            String user = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");

            String insertTable = "insert into Bus_Management(b_id,bus_no,st_point,bus_fees) values (?, ?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(insertTable);

            pstmt.setInt(1, 01);
            pstmt.setInt(2, 10);
            pstmt.setString(3, "Karur");
            pstmt.setInt(4, 22000);
            pstmt.executeUpdate();
            
            pstmt.setInt(1, 02);
            pstmt.setInt(2, 20);
            pstmt.setString(3, "Salem");
            pstmt.setInt(4, 7500);
            pstmt.executeUpdate();

            pstmt.setInt(1, 03);
            pstmt.setInt(2, 30);
            pstmt.setString(3, "Namakkal");
            pstmt.setInt(4, 7200);
            pstmt.executeUpdate();

            pstmt.setInt(1, 04);
            pstmt.setInt(2, 40);
            pstmt.setString(3, "Erode");
            pstmt.setInt(4, 21000);
            pstmt.executeUpdate();

            System.out.println("table data added successfully");

        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}