


public class Employee {

	
	private String userName;
	private String password;
	private String lastName;
	private String firstName;
	private double hourlyWage;
	private double HoursperWeek;
	
	public Employee(String userName, String password,double hourlyWage,
			double HoursperWeek, String firstName, String lastName ) {
		
		
		this.userName = userName;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.hourlyWage = hourlyWage;
		this.HoursperWeek = HoursperWeek;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double gethourlyWage() {
		return hourlyWage;
	}

	public void sethourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getHoursperWeek() {
		return HoursperWeek;
	}

	public void setSalary(double HoursperWeek) {
		this.HoursperWeek = HoursperWeek;
	}

	@Override
	public String toString() {
		return String
				.format("Employee [username=%s, password=%s, Hourly Wage=%s, Hours per week=%s,lastName=%s, firstName=%s ]",userName,
						password,hourlyWage, HoursperWeek, lastName, firstName );
	}
	
	
		
}