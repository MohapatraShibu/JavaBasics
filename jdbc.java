    package jdbcconnection;
    import java.sql.*;

    public class JDBCConnection {

   
    public static void main(String[] args) {
        
       String user = " ";
       String pass = " " ; 
        
       try{
           Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sycs_java",user,pass);
          System.out.println("Connected Successfully");
          Statement stmt = con.createStatement();
          ResultSet rs =stmt.executeQuery("select * from student");

          ResultSetMetaData rmd = rs.getMetaData();

          System.out.println("Total columns returned are " + rmd.getColumnCount() );

      while (rs.next())
      {
          System.out.println("GRno is:" + rs.getString(1) + " Name:" + rs.getString(2));
       }       
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }   
    }
