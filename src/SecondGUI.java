import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


public class SecondGUI {

	private JFrame frame;
	private JPanel loginpage;
	private JTextField usernamefield;
	private JPasswordField passwordField;
	private JPanel mainscreen;
	Connection connection = null;
	
	private JLabel lblAddEmployee;
	private JLabel lblLastName;
	private JLabel lblFirstName;
	private JLabel lblHourlyWage;
	private JLabel lblHoursPerWeek;
	private JLabel lblAssignUsername;
	private JLabel lblAssignPassword;
	private JTextField lastname;
	private JTextField Firstname;
	private JTextField wage;
	private JTextField hours;
	private JTextField setusername;
	private JPasswordField setpassword;
	private JButton btnAddEmployee;
	private JPanel homepage;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondGUI window = new SecondGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SecondGUI() {
		initialize();
		connection = Sqlconnection.dbConnector();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		loginpage = new JPanel();
		frame.getContentPane().add(loginpage, "name_2634869902926");
		loginpage.setLayout(null);
		
		usernamefield = new JTextField();
		usernamefield.setBounds(163, 32, 122, 28);
		loginpage.add(usernamefield);
		usernamefield.setColumns(10);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setBounds(50, 38, 101, 16);
		loginpage.add(lblEnterUsername);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setBounds(50, 78, 101, 16);
		loginpage.add(lblEnterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 72, 122, 28);
		loginpage.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					String query="select * from employee where UserName=? and password=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,usernamefield.getText() );
					pst.setString(2,passwordField.getText() );
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()){
						
						count++;
						
						
					}
					if (count == 1)
					{
						
						
						homepage.setVisible(true);
						loginpage.setVisible(false);
						
						
					}
					
					else if (count > 1) JOptionPane.showMessageDialog(null, "wrong info");
					
					else JOptionPane.showMessageDialog(null, "still wrong");
					rs.close();
					pst.close();
					connection.close();
					
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnLogin.setBounds(173, 112, 90, 28);
		loginpage.add(btnLogin);
		
		mainscreen = new JPanel();
		frame.getContentPane().add(mainscreen, "name_2938254862206");
		mainscreen.setLayout(null);
		
		lblAddEmployee = new JLabel("Add employee");
		lblAddEmployee.setBounds(219, 19, 93, 16);
		mainscreen.add(lblAddEmployee);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(100, 81, 80, 16);
		mainscreen.add(lblLastName);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(100, 109, 80, 16);
		mainscreen.add(lblFirstName);
		
		lblHourlyWage = new JLabel("Hourly Wage");
		lblHourlyWage.setBounds(100, 137, 80, 16);
		mainscreen.add(lblHourlyWage);
		
		lblHoursPerWeek = new JLabel("Hours per week");
		lblHoursPerWeek.setBounds(100, 165, 93, 16);
		mainscreen.add(lblHoursPerWeek);
		
		lblAssignUsername = new JLabel("Assign UserName");
		lblAssignUsername.setBounds(100, 199, 125, 16);
		mainscreen.add(lblAssignUsername);
		
		lblAssignPassword = new JLabel("Assign Password");
		lblAssignPassword.setBounds(100, 227, 125, 16);
		mainscreen.add(lblAssignPassword);
		
		lastname = new JTextField();
		lastname.setBounds(235, 75, 122, 28);
		mainscreen.add(lastname);
		lastname.setColumns(10);
		
		Firstname = new JTextField();
		Firstname.setBounds(235, 103, 122, 28);
		mainscreen.add(Firstname);
		Firstname.setColumns(10);
		
		wage = new JTextField();
		wage.setBounds(235, 131, 122, 28);
		mainscreen.add(wage);
		wage.setColumns(10);
		
		hours = new JTextField();
		hours.setBounds(235, 159, 122, 28);
		mainscreen.add(hours);
		hours.setColumns(10);
		
		setusername = new JTextField();
		setusername.setBounds(235, 193, 122, 28);
		mainscreen.add(setusername);
		setusername.setColumns(10);
		
		setpassword = new JPasswordField();
		setpassword.setBounds(237, 221, 120, 28);
		mainscreen.add(setpassword);
		
		btnAddEmployee = new JButton("Add employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection = Sqlconnection.dbConnector();
				try
				{
					String query1="insert into employee(username,password,hourlyrate,hrsweekly,firstname,lastname) values (?,?,?,?,?,?)";
					PreparedStatement pst1 = connection.prepareStatement(query1);
					pst1.setString(1,setusername.getText() );
					pst1.setString(2,setpassword.getText() );
					
					
					String s = wage.getText(); 
					
					try
					{
						double id = Double.parseDouble(s); 
						pst1.setDouble(3, id); 
					}
					
					catch(NumberFormatException ex)
					{ 
						JOptionPane.showMessageDialog(null, "Wrong entry");
					}
					
					
                    String n = hours.getText(); 
					
					try
					{
						double id2 = Double.parseDouble(n); 
						pst1.setDouble(4, id2); 
					}
					
					catch(NumberFormatException ex)
					{ 
						JOptionPane.showMessageDialog(null, "Wrong entry");
					}
					pst1.setString(5,Firstname.getText() );
					pst1.setString(6,lastname.getText() );
					
					
					pst1.executeUpdate();
					
					pst1.close();
					connection.close();
				}
				catch(Exception x)
				{
					JOptionPane.showMessageDialog(null, x);
				}
				
				
				
				
			}
		});
		btnAddEmployee.setBounds(285, 35, 143, 28);
		mainscreen.add(btnAddEmployee);
		
		homepage = new JPanel();
		frame.getContentPane().add(homepage, "name_10459822637649");
		homepage.setLayout(null);
		
		JButton btnAddEmployees = new JButton("Add employees");
		btnAddEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainscreen.setVisible(true);
				homepage.setVisible(false);
				
			}
		});
		btnAddEmployees.setBounds(167, 46, 137, 28);
		homepage.add(btnAddEmployees);
	}
}
