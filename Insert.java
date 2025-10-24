import java.sql.*;

public class Insert {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String username= "root";
        String password= "#MacBook316";
        String query = "INSERT INTO student(id,name,job_title,salary) values (4,'Himani','DevOps Engineer',65000);";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established Successfully");
            Statement stmt = con.createStatement();
            int row_affected = stmt.executeUpdate(query);

            if(row_affected > 0)
            {
                System.out.println("Insert Successful!!.."+ row_affected + " rows affected");
            }
            else {
                System.out.println("Insertion Failed");
            }
            stmt.close();
            con.close();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
