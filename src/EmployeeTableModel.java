

import java.util.List;

import javax.swing.table.AbstractTableModel;


class EmployeeTableModel extends AbstractTableModel {

	
	private static final int USER_NAME_COL = 0;
	private static final int PASSWORD_COL = 1;
	private static final int HRLY_WAGE = 2;
	private static final int HRS_WK = 3;
	private static final int LAST_NAME_COL = 4;
	private static final int FIRST_NAME_COL = 5;
	

	private String[] columnNames = {"username", "password", "hourlyrate", "hrsweekly", "firstname",
			"lastname" };
	private List<Employee> employees;

	public EmployeeTableModel(List<Employee> theEmployees) {
		employees = theEmployees;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Employee tempEmployee = employees.get(row);

		switch (col) {
		case LAST_NAME_COL:
			return tempEmployee.getLastName();
		case FIRST_NAME_COL:
			return tempEmployee.getFirstName();
		case HRLY_WAGE:
			return tempEmployee.gethourlyWage();
		case HRS_WK:
			return tempEmployee.getHoursperWeek();
		case USER_NAME_COL:
			return tempEmployee.getuserName();	
		case PASSWORD_COL:
			return tempEmployee.getpassword();
		
		default:
			return tempEmployee.getLastName();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
