package cinima;
import java.sql.*;
import java.util.*;

import com.mysql.cj.xdevapi.PreparableStatement;
public class Theatre {
	Scanner  s;
	SignupSignin sinsup = new SignupSignin();
	Connection connection;
	Statement statement;;
    PreparedStatement ps;
   

	Theatre(){
		try {
	    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CINIMA","root","2004");
 	    statement =connection.createStatement();
		s = new Scanner(System.in);
	   }catch(Exception e) {e.printStackTrace();}}
   
	void go(String name) {
		System.out.println("1.Add Show\n2.change Password\nChoice?");
		int choice = s.nextInt();
		if(choice==1)
			addShow(name);
		if(choice==2)
		    sinsup.changePassword(name);
		
    	
    }
    
    void addShow(String Name) {
    	System.out.print("Enter the date(dd//mm/yyyy): ");
    	String date = s.next();
    	System.out.println("Enter the Movie name: ");
    	String name = s.next();
    	System.out.println("Enter movie StartTime: ");
    	String sTime = s.next();
    	System.out.println("Enter movie End Time: ");
    	String eTime = s.next();
    	System.out.println("Enter highest ticket Price: ");
    	int price1  = s.nextInt();
    	System.out.println("Enter avilable tickets: ");
    	int avl1 = s.nextInt();
    	System.out.println("Enter the Mid ticket Price: ");
    	int price2 = s.nextInt();
    	System.out.println("Enter avilable tickets: ");
    	int avl2 = s.nextInt();
    	System.out.println("Enter the lowest ticket Price: ");
    	int price3 = s.nextInt();
    	System.out.println("Enter avilable tickets: ");
    	int avl3 = s.nextInt();
    	System.out.println("Enter totalSeats: ");
    	int seats = s.nextInt();
    	
    	try {
    	String str = "INSERT INTO "+Name+" VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    	ps = connection.prepareStatement(str);
    	ps.setString(1, date);
    	ps.setString(2, sTime);
    	ps.setString(3, eTime);
    	ps.setString(4, name);
    	ps.setInt(5, price1);
    	ps.setInt(6, avl1);
    	ps.setInt(7, price2);
    	ps.setInt(8, avl2);
    	ps.setInt(9, price3);
    	ps.setInt(10, avl3);
    	ps.setInt(11, seats);
    	ps.executeUpdate();}catch(Exception e) {e.printStackTrace();}}
}
