package cinima;
import java.sql.DriverManager;
import java.util.*;
import java.sql.*;

public class SignupSignin {
		   Scanner s = new Scanner(System.in);
		   Theatre theatre = new Theatre();
		   Connection connection;
	       Statement statement;
	       PreparedStatement ps; 
		   ResultSet rs;
		   
		   
	      SignupSignin(){
	    	   try {
	    	   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CINIMA","root","2004");
	    	   statement =connection.createStatement();
	    	   connection.close();
	    	   }catch(Exception e){e.printStackTrace();}
	    	   s = new Scanner(System.in);}
	 
	      
	    
	      void TheatreSignup() {
	    	  System.out.print("Enter the Theatre Name: ");
	    	  String name = s.nextLine();
	    	  String pass1="";
	    	  while(true) {
	    	  System.out.print("Enter password: ");
	    	  pass1 = s.next();
	    	  System.out.print("ReEnter password: ");
	    	  String pass2 = s.next();
	    	  if(!(pass1.equals(pass2))){
	    			  System.out.println("Password Mismatch....");
	    			  continue;}
	    	  else break;}
	    	  System.out.print("Enter the capacity: ");
	    	  int cap = s.nextInt();
	    	  System.out.print("Enter the Location: ");
	    	  String location = s.next();
	    	  System.out.print("Enter Contact No: ");
	    	  String phn = s.next();
	    	 
	    	  // inserting into database
	    	  try {
	    	  ps = connection.prepareStatement("INSERT INTO THEATRE VALUES(?,?,?,?,?)");
	    	  ps.setString(1, name);
	    	  ps.setString(2, pass1);
	    	  ps.setInt(3, cap);
	    	  ps.setString(4, location);
	    	  ps.setString(5, phn);
	    	  ps.executeUpdate();
	    	  String str = "CREATE TABLE " +  name + " (S_DATE VARCHAR(30),S_STIME VARCHAR(30),S_ETIME VARCHAR(30),S_NAME VARCHAR(100),S_TPRICE1 INT,S_PAV1 INT,S_TPRICE2 INT,S_PAV2 INT,S_TPRICE3 INT,S_PAV3 INT,S_SEATSREMAIN INT)";
	      	  ps = connection.prepareStatement(str);
	 		  ps.executeUpdate();
	    	  }catch(Exception e ) {e.printStackTrace();}}
	      
	      
	      void theatreSignin() {
	    	  System.out.print("Enter your Theatre Name: ");
	    	  String name = s.next();
	    	  System.out.print("Enter password: ");
	    	  String pass = s.next();
	    	  theatre.go(name);}
	      
	      
	      void changePassword(String name) {
	    	  while(true) {
	    	  System.out.println("Enter your old password: ");
	    	  String pass = s.next();
	    	  if(verify(name, pass)) {
	    		  System.out.println("Enter the New Password: ");
	    		  String pass1 = s.next();
	    		  System.out.println("ReEnter password: ");
	    		  String pass2 = s.next();
	    		  if(pass1.equals(pass2)) {
	    			  try {
	    				  String str = "UPDATE THEATRE SET T_PASSWORD = ? WHERE T_NAME = ?";
	    				  ps = connection.prepareStatement(str);
	    				  ps.setString(1, pass1);
	    				  ps.setString(2, name);
	    				  ps.executeUpdate();
	    			  }catch(Exception e) {e.printStackTrace();}}
	    		  else {
	    			  System.out.println("password Mismatch..."); 
	    			  continue;}}
	    	  else {
	    		  System.out.println("Wrong Password..");
	    		  continue;}}}
	      
	      
	      
	      boolean verify(String name , String pass) {
	    	  try {
	    	  rs = statement.executeQuery("SELECT * FROM THEATRE");
	    	  while(rs.next()) {
	    		  if(rs.getString(1).equals(name)&&rs.getString(2).equals(pass))
	    			  return true;}
	    	  }catch(Exception e) {e.printStackTrace();}
	    	  return false;}
	      
	      
	      
	      
	}