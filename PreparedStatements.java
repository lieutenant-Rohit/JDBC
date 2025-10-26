import java.sql.*;

public class PreparedStatements {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/TestDB";
        String username= "root";
        String password= "#MacBook316";
        String query = "Select * from student where id = ?;";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established");
            PreparedStatement myStmt = con.prepareStatement(query);
            myStmt.setInt(1,1);
            ResultSet rs = myStmt.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println("================");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Job Title: "+job_title);
                System.out.println("Salary: "+salary);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
