import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Database Connection Class
 * Handles all database connections for the hotel management system
 */

public class DBConnection {
    // Database configuration
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/BM_System";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    // Connection instance
    private static Connection connection = null;
    /**
     * Get database connection
     * @return Connection object
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC Driver
            Class.forName(JDBC_DRIVER);
            // Create connection
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Database connected successfully!");
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
            throw new SQLException("Database driver not found", e);
        } catch (SQLException e) {
            System.err.println("Failed to connect to database!");
            e.printStackTrace();
            throw e;
        }
    }
    /**
     * Close database connection
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing database connection!");
            e.printStackTrace();
        }
    }
    /**
     * Test database connection
     * @return true if connection successful, false otherwise
     */
    public static boolean testConnection() {
        try {
            Connection testCon = getConnection();
            if (testCon != null && !testCon.isClosed()) {
                testCon.close();
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Database connection test failed!");
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Get connection with auto-commit disabled for transactions
     * @return Connection with auto-commit disabled
     * @throws SQLException if connection fails
     */
    public static Connection getTransactionConnection() throws SQLException {
        Connection con = getConnection();
        con.setAutoCommit(false);
        return con;
    }
}