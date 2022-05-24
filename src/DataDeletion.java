import java.sql.*;
public class DataDeletion {
    public static void main(String[] args) throws Exception {
        //Step-1: loading driver class dynamically
        Class.forName("com.mysql.jdbc.Driver");
        
        //Step-2: connection to database
          final String DB_URL="jdbc:mysql://localhost:3306/abu";
          final String DB_USER="root";
          final String DB_PASS="";
          
          
        Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        
        //Step-3: create preparestatement to execute SQL query
        PreparedStatement stmt=con.prepareStatement("delete from student where stuid=?");
        stmt.setInt(1,103);
        int result=stmt.executeUpdate();
        if(result>0)
        {
            System.out.println("data deleted successfully");
        }
        else
        {
            System.err.println("data deletion error");
        }
        
        
        //Display Result
        
        
        
 
        
        
        
    }
    
}
