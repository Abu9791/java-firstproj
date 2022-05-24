import java.sql.*;
public class ConnectionDemo {
    public static void main(String[] args) throws Exception {
        //Step-1: loading driver class dynamically
        Class.forName("com.mysql.jdbc.Driver");
        
        //Step-2: connection to database
          final String DB_URL="jdbc:mysql://localhost:3306/abu";
          final String DB_USER="root";
          final String DB_PASS="";
          
          
        Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        
        //Step-3: create statement to execute SQL query
        Statement stmt=con.createStatement();
        
        //Display Result
        ResultSet rs=stmt.executeQuery("select * from student");
        while(rs.next())
        {
            System.out.println("student id is"+rs.getInt(1));
            System.out.println("student name is"+rs.getString(2));
        }
        
        
    }
    
}
