import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class fetch {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/Project";
            String user = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");

            String query = "SELECT * FROM Bus_Management";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                System.out.println("Current data:");
                System.out.println("Bus_id: " + rs.getInt("b_id"));
                System.out.println("Bus_no: " + rs.getInt("bus_no"));
                System.out.println("Starting_point: " + rs.getString("st_point"));
                System.out.println("Bus_Fees: " + rs.getInt("bus_fees"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}