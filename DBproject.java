package dbproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBProject {
  
    public static void main(String[] args) {

        String DB_URL = "jdbc:sqlserver://127.0.0.1:1434"; 
        Connection con = null; 
        Statement stmt = null;  

        try{          
            //Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, "user", "password");
            System.out.println("Connected");     
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM [LibraryManagement].[dbo].[Teacher]");
            ResultSetMetaData rsmd = null;
            rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnCount());
            int count = 1;
            while (count <= rsmd.getColumnCount())
            {
                System.out.println(rsmd.getColumnLabel(count));
                count++;
            }
            
            count = 1;
            
            String type = null;
            while (rs.next())
            {
            count = 1; 
            
            while (count <= (rsmd.getColumnCount()  ))
            {
                type = rsmd.getColumnTypeName(count);
                if (type == "varchar")
                {
                System.out.print( " " + rsmd.getColumnLabel(count)+ ":" +  rs.getString(count));
                    
                }
                else if (type == "smallint")
                {
                    System.out.println(" " + rsmd.getColumnLabel(count)+ ":" + rs.getInt(count));
                }
               
                count++;
                
            }    
            
            //System.out.println( rs.getString(1) + rs.getString(2) + rs.getInt(3));
                /*
            while (count <= (rsmd.getColumnCount()  ))
            {
                type = rsmd.getColumnTypeName(count);
                if (type == "varchar")
                {
                System.out.println(rs.getString(count));
                    
                }
                else if (type == "smallint")
                {
                    System.out.println(rs.getInt(count));
                }                              
                
                count++;
                
            }*/
            }
            
           /* while(rs.next())
            {
               System.out.println(rs.getString("name"));  
            }*/
            
        }catch(Exception e){e.printStackTrace();}                 
    }    
}
