import java.sql.*;
import java.util.Date;

public class Database {
    PostgreSQL postgreSQL;

    public Database() {
        postgreSQL = new PostgreSQL();
    }

    public void displayCategories() {
        String query = "SELECT * FROM categories ORDER BY id";
        Connection con;
        try {
            con = postgreSQL.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\nCategories of our products: ");
            while(rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayProductsOfCategory(int categoryID) {
        String query = "SELECT * FROM products WHERE category = ? AND quantity > 0 ORDER BY id";
        Connection con;
        try {
            con = postgreSQL.getConnection();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, categoryID);

            ResultSet rs = st.executeQuery();

            System.out.println("\nAll products of category " + categoryID + " we have: ");
            while(rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") +
                        " | " + rs.getFloat("price") + "$");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void buyProduct(int productID, String firstname, String lastname, String phone) {
        String query1 = "INSERT INTO purchases (customer_name, customer_lastname, customer_phone, product_id," +
                "purchase_date) values (?,?,?,?,CURRENT_DATE );";
        String query2 = "UPDATE products set quantity = quantity - 1 WHERE id = ?;";
        Connection con;
        try {
            con = postgreSQL.getConnection();
            PreparedStatement st1 = con.prepareStatement(query1);
            st1.setString(1, firstname);
            st1.setString(2, lastname);
            st1.setString(3, phone);
            st1.setInt(4, productID);

            st1.execute();

            PreparedStatement st2 = con.prepareStatement(query2);
            st2.setInt(1, productID);
            st2.execute();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
