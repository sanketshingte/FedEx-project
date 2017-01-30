import java.sql.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    int id,source,destination;
    /***********************************************************/
    //JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    static final String DB_URL = "jdbc:mysql://localhost/SANKET?useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Sank*1991";
    static Connection conn = null;
    static Statement stmt = null;
    /***********************************************************/
    //public static ArrayList<Packet> Olist = new ArrayList<Packet>();
    public static ArrayList<Double> packet_id = new ArrayList<Double>();
    public static ArrayList<Integer> src = new ArrayList<Integer>();
    public static ArrayList<Integer> dest = new ArrayList<Integer>();
   
   
    public void dbconn(){
        try{
              //STEP 2: Register JDBC driver
              Class.forName("com.mysql.jdbc.Driver");

              //STEP 3: Open a connection
              System.out.println("Connecting to FedEx Server");
              conn = DriverManager.getConnection(DB_URL, USER, PASS);
              System.out.println("Connection to FedEx server is successful...");
             
              //STEP 4: Execute a query
              System.out.println("Welcome to the FedEx Packet Tracking System");
              stmt = conn.createStatement();

              String sql = "SELECT * FROM mytable"; //Where id ="+ idnum +" ";
              ResultSet rs = stmt.executeQuery(sql);
              //STEP 5: Extract data from result set
             // int i=0;
              while(rs.next()){
             
            	  packet_id.add((double)rs.getInt("tracking_ID"));
                  src.add(rs.getInt("Source"));
                  dest.add(rs.getInt("Destination"));
              
              }
              rs.close();
           }catch(SQLException se){
              //Handle errors for JDBC
              se.printStackTrace();
           }catch(Exception e){
              //Handle errors for Class.forName
              e.printStackTrace();
           }finally{
              //finally block used to close resources
              try{
                 if(stmt!=null)
                    conn.close();
              }catch(SQLException se){
              }// do nothing
              try{
                 if(conn!=null)
                    conn.close();
              }catch(SQLException se){
                 se.printStackTrace();
              }//end finally try
           }//end try
        }//end

    }