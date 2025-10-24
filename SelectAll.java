import java.sql.*;
class SelectAll
{
    public static void main(String[] args)throws ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/StudentDB";
        String username ="root";
        String password = "#MacBook316";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        }catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established Successfully");
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student");
            while (rs.next())
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
            con.close();
            rs.close();
            con.close();
            System.out.println("Connection Closed Successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }


    }
}