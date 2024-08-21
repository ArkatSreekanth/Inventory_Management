import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/InventoryDB";
            String user = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");

            String deleteStock = "DELETE FROM Stock WHERE product_id = ?";
            PreparedStatement pstmt = con.prepareStatement(deleteStock);
            pstmt.setInt(1, 2);
            pstmt.executeUpdate();

            String deleteProduct = "DELETE FROM Products WHERE product_id = ?";
            pstmt = con.prepareStatement(deleteProduct);
            pstmt.setInt(1, 2);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
