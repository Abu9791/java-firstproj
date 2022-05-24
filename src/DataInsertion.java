import java.sql.*;
public class DataInsertion {
    public static void main(String[] args) throws Exception {
        //Step-1: loading driver class dynamically
        Class.forName("com.mysql.jdbc.Driver");
        
        //Step-2: connection to database
          final String DB_URL="jdbc:mysql://localhost:3306/abu";
          final String DB_USER="root";
          final String DB_PASS="";
          
          
        Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        
        //Step-3: create preparestatement to execute SQL query
        PreparedStatement stmt=con.prepareStatement("insert into student(stuid,name)values(?,?)");
        
        stmt.setInt(1,105);
        stmt.setString(2,"naresh");
        int result=stmt.executeUpdate();
        if(result>0)
        {
            System.out.println("data inserted successfully");
        }
        else
        {
            System.err.println("data insertion error");
        }
        
        
        //Display Result
        
        
        
 
        
        
        
    }
    
}
