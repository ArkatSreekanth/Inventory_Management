import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/InventoryDB";
            String user = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");

            String insertCategories = "INSERT INTO Categories (name) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(insertCategories);
            pstmt.setString(1, "Electronics");
            pstmt.executeUpdate();
            pstmt.setString(1, "Furniture");
            pstmt.executeUpdate();

            String insertSuppliers = "INSERT INTO Suppliers (name, contact_info) VALUES (?, ?)";
            pstmt = con.prepareStatement(insertSuppliers);
            pstmt.setString(1, "TechCorp");
            pstmt.setString(2, "contact@techcorp.com");
            pstmt.executeUpdate();
            pstmt.setString(1, "FurniWorld");
            pstmt.setString(2, "support@furniworld.com");
            pstmt.executeUpdate();

            String insertProducts = "INSERT INTO Products (name, category_id, supplier_id, price) VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(insertProducts);
            pstmt.setString(1, "Laptop");
            pstmt.setInt(2, 1);
            pstmt.setInt(3, 1);
            pstmt.setDouble(4, 1200.00);
            pstmt.executeUpdate();
            pstmt.setString(1, "Chair");
            pstmt.setInt(2, 2);
            pstmt.setInt(3, 2);
            pstmt.setDouble(4, 150.00);
            pstmt.executeUpdate();

            String insertStock = "INSERT INTO Stock (product_id, quantity) VALUES (?, ?)";
            pstmt = con.prepareStatement(insertStock);
            pstmt.setInt(1, 1);
            pstmt.setInt(2, 50);
            pstmt.executeUpdate();
            pstmt.setInt(1, 2);
            pstmt.setInt(2, 100);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
