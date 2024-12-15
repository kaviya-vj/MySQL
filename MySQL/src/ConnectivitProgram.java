
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class ConnectivitProgram {
	    public static void main(String[] args) {
	        // Database connection parameters
	        String url = "jdbc:mysql://localhost:3306/GuviTask";  // MySQL URL 
	        String user = "root";  // Replace with your MySQL username
	        String password = "VJkavi@1420";  // Replace with your MySQL password

	        // SQL query to insert data into EmployeeInfo table
	        String sql = "INSERT INTO EmployeeInfo (emcode, emname, empage, emsalary) VALUES (?, ?, ?, ?)";

	        // Data to be inserted
	        Object[][] data = {
	            {101, "Jenny", 25, 10000},
	            {102, "Jack", 30, 20000},
	            {103, "Joe", 20, 40000},
	            {104, "John", 40, 80000},
	            {105, "Shameer", 25, 90000}
	        };

	        // Establish a connection and execute the insert queries
	        try (Connection conn = DriverManager.getConnection(url, user, password)) {
	            // Create a PreparedStatement for inserting data
	            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	                // Insert each row into the table
	                for (Object[] row : data) {
	                    stmt.setInt(1, (int) row[0]);  // emcode
	                    stmt.setString(2, (String) row[1]);  // emname
	                    stmt.setInt(3, (int) row[2]);  // empage
	                    stmt.setInt(4, (int) row[3]);  // emsalary
	                    stmt.executeUpdate();  // Execute the insert statement
	                }
	                System.out.println("Data inserted successfully!");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


