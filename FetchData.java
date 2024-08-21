import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchData {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/InventoryDB";
            String user = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");

            String queryProducts = "SELECT * FROM Products";
            PreparedStatement pstmt = con.prepareStatement(queryProducts);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Product_id: " + rs.getInt("product_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Category_id: " + rs.getInt("category_id"));
                System.out.println("Supplier_id: " + rs.getInt("supplier_id"));
                System.out.println("Price: " + rs.getDouble("price"));
            }

            String queryStock = "SELECT * FROM Stock";
            pstmt = con.prepareStatement(queryStock);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Stock_id: " + rs.getInt("stock_id"));
                System.out.println("Product_id: " + rs.getInt("product_id"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
