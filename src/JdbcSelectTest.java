import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.*;   // Use classes in java.sql package
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
 
// JDK 7 and above
 class JdbcSelectTest {  // Save as "JdbcSelectTest.java"
	 
	 private Connection conn;
	
	public JdbcSelectTest() throws Exception  {
      
		

	   Properties props = new Properties();
	   props.load(new FileInputStream("info.properties"));
	   
	   
	   String user= props.getProperty("user");
	   String password = props.getProperty("password");
	   String dburl = props.getProperty("dburl");
	   
	   conn = DriverManager.getConnection(dburl,user,password);
	   
	   System.out.println("DB connection successful to: " + dburl);
	  
	   
	   
}
	
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("select * from employees");
			
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
			myStmt = conn.prepareStatement("select * from employees where lastname like ?");
			
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
		
		int id = myRs.getInt("id");
		String lastName = myRs.getString("lastname");
		String firstName = myRs.getString("firstname");
		BigDecimal hourlyWage = myRs.getBigDecimal("hourlyWage");
		double HoursperWeek = myRs.getDouble("HoursperWeek");
		
		Employee tempEmployee = new Employee(id, lastName, firstName, hourlyWage, HoursperWeek);
		
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
		
		JdbcSelectTest dao = new JdbcSelectTest();
		System.out.println(dao.searchEmployees(""));

		
	}
	
}