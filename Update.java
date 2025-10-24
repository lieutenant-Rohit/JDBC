import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String username = "root";
        String password = "#MacBook316";
        String query = "UPDATE student Set salary = 80000 WHERE id = 4;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully");
            Statement stmt = con.createStatement();
            int row_affected = stmt.executeUpdate(query);

            if(row_affected > 0)
            {
                System.out.println("Update Successful!!.."+ row_affected + " rows affected");
            }
            else {
                System.out.println("Update Failed");
            }
            stmt.close();
            con.close();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
