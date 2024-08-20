import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class update {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/Project";
            String user = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");
            String updateTable = "update Bus_Management set bus_fees = ? where bus_no = ?";
            PreparedStatement pstmt = con.prepareStatement(updateTable);
            pstmt.setInt(1, 10000);
            pstmt.setInt(2, 20);
            pstmt.executeUpdate();
            System.out.println("table data updated successfully");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}