import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/InventoryDB";
            String user = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");

            String updateProductPrice = "UPDATE Products SET price = ? WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(updateProductPrice);
            pstmt.setDouble(1, 1150.00);
            pstmt.setString(2, "Laptop");
            pstmt.executeUpdate();

            String updateStockQuantity = "UPDATE Stock SET quantity = ? WHERE product_id = ?";
            pstmt = con.prepareStatement(updateStockQuantity);
            pstmt.setInt(1, 60);
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
