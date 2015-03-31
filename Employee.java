import java.math.BigDecimal;


public class Employee {

	private int id;
	private String lastName;
	private String firstName;
	private BigDecimal hourlyWage;
	private double HoursperWeek;
	
	public Employee(int id, String lastName, String firstName, BigDecimal hourlyWage,
			double HoursperWeek) {
		
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.hourlyWage = hourlyWage;
		this.HoursperWeek = HoursperWeek;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public BigDecimal gethourlyWage() {
		return hourlyWage;
	}

	public void sethourlyWage(BigDecimal hourlyWage) {
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
				.format("Employee [id=%s, lastName=%s, firstName=%s, Hourly Wage=%s, Hours per week=%s]",
						id, lastName, firstName, hourlyWage, HoursperWeek);
	}
	
	
		
}