import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Createcon {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/InventoryDB";
            String user = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");

            Statement s = con.createStatement();

            String createCategoriesTable = "CREATE TABLE Categories (category_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100) NOT NULL)";
            s.executeUpdate(createCategoriesTable);

            String createSuppliersTable = "CREATE TABLE Suppliers (supplier_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100) NOT NULL, contact_info VARCHAR(100))";
            s.executeUpdate(createSuppliersTable);

            String createProductsTable = "CREATE TABLE Products (product_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100) NOT NULL, category_id INT, supplier_id INT, price DECIMAL(10, 2) NOT NULL, FOREIGN KEY (category_id) REFERENCES Categories(category_id), FOREIGN KEY (supplier_id) REFERENCES Suppliers(supplier_id))";
            s.executeUpdate(createProductsTable);

            String createStockTable = "CREATE TABLE Stock (stock_id INT AUTO_INCREMENT PRIMARY KEY, product_id INT, quantity INT NOT NULL, FOREIGN KEY (product_id) REFERENCES Products(product_id))";
            s.executeUpdate(createStockTable);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

