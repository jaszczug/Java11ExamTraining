package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "user1", "pass")) {

			try (Statement stmt = con.createStatement()) {
				String tableSql = "CREATE TABLE IF NOT EXISTS employees"
						+ "(emp_id int PRIMARY KEY AUTO_INCREMENT, name varchar(30),"
						+ "position varchar(30), salary double)";
				stmt.execute(tableSql);

				String insertSql = "INSERT INTO employees(name, position, salary)"
						+ " VALUES('john', 'developer', 2000)";
				stmt.executeUpdate(insertSql);

				String selectSql = "SELECT * FROM employees";
				try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
					List<Employee> employees = new ArrayList<>();
					while (resultSet.next()) {
						Employee emp = new Employee();
						emp.setId(resultSet.getInt("emp_id"));
						emp.setName(resultSet.getString("name"));
						
					
						
						emp.setPosition(resultSet.getString("position"));
						emp.setSalary(resultSet.getDouble("salary"));
						employees.add(emp);
						
						System.out.println(emp);
					}

					System.out.print("Num of records:" + employees.size());
				}

			}
			update(con);
			

		}

	}
	
	 public static void update(Connection con) throws SQLException {
		 
		 String updatePositionSql = "UPDATE employees SET position=? WHERE emp_id=?";
		 PreparedStatement pstmt = con.prepareStatement(updatePositionSql);
		 pstmt.setString(1, "lead developer");
		 pstmt.setInt(2, 1);

		 String updateSalarySql = "UPDATE employees SET salary=? WHERE emp_id=?";
		 PreparedStatement pstmt2 = con.prepareStatement(updateSalarySql);
		 pstmt2.setDouble(1, 3000);
		 
		 //pstmt2.setNull(1, java.sql.Types.NVARCHAR);
		 pstmt2.setInt(2, 1);

		 boolean autoCommit = con.getAutoCommit();
		 try {
		     con.setAutoCommit(false);
		     pstmt.executeUpdate();
		     pstmt2.executeUpdate();
		     con.commit();
		 } catch (SQLException exc) {
			 
			 exc.printStackTrace();
		     con.rollback();
		 } finally {
		     con.setAutoCommit(autoCommit);
		 }
		 
		 
		 try (Statement stmt = con.createStatement()) {
			 String insertSql = "INSERT INTO employees(name, position, salary)"
					  + " VALUES('john', 'developer', 2000)";
					stmt.executeUpdate(insertSql);
		 }

	 }
	

}

class Employee {
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary + "]";
	}

	private int id;
	private String name;
	private String position;
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	// standard constructor, getters, setters
}