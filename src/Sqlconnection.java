
import java.sql.*;  
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
 

 public class Sqlconnection { 
	 
	 Connection conn=null;
	
	public static Connection dbConnector() {
      
		try{
		
		Class.forName("org.sqlite.JDBC");
	   Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\salman\\workspace\\SecondGUI\\company.sqlite.db");
	   
	   return conn;
	 
	   }
	   catch(Exception e)
	   {
		   JOptionPane.showMessageDialog(null, e);
		   return null;
	   }
	  
     }
 
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("select * from employee");
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}

			return list;		
		}
		
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<Employee> searchEmployees(String lastName) throws Exception {
		
		List<Employee> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			lastName += "%";
			myStmt = conn.prepareStatement("select * from employee where lastname like ?");
			
			myStmt.setString(1, lastName);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		
		finally {
			close(myStmt, myRs);
		}
	}
	
       private Employee convertRowToEmployee(ResultSet myRs) throws SQLException {
		
		
		String lastName = myRs.getString("lastname");
		String firstName = myRs.getString("firstname");
		String userName = myRs.getString("username");
		String password = myRs.getString("password");
		double hourlyWage = myRs.getDouble("hourlyrate");
		double HoursperWeek = myRs.getDouble("Hrsweekly");
		
		Employee tempEmployee = new Employee(userName, password, hourlyWage, HoursperWeek,firstName, lastName );
		
		return tempEmployee;
	}
 
private static void close(Connection conn, Statement myStmt, ResultSet myRs)
		throws SQLException {

	if (myRs != null) {
		myRs.close();
	}

	if (myStmt != null) {
		
	}
	
	if (conn != null) {
		conn.close();
	}
}

private void close(Statement myStmt, ResultSet myRs) throws SQLException {
	close(null, myStmt, myRs);		
}

public static void main(String[] args) throws Exception {
	
	Sqlconnection dao = new Sqlconnection();
	System.out.println(dao.searchEmployees(""));

	
}
 }
 