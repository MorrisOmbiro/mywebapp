package dataLayer;

import java.sql.*;

public class DB_User {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mywebapp";

    // Database credentials
    static final String USER = "mywebappuser";
    static final String PASS = "FakePassword";

    public boolean isValidUSerLogin(String userName, String userPassword) {
        boolean isValidUser = false;

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            // STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // Vulnerable to SQL injections but fine for now ...
            sql = "SELECT * FROM users WHERE user_name = \"" +
                    userName + "\" AND user_password = \"" + userPassword + "\"";

            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);

            // STEP 5: Extract data from result set
            if(rs.next()) // move to first row if it exists etc...
                isValidUser = true;

            // STEP 6" Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null)
                    stmt.close();
            }catch(SQLException se2) {
                // sigh ...
            }try {
                if(conn != null)
                    conn.close();
            }catch (SQLException se) {
                se.printStackTrace();
            }
        } // end try

        System.out.println("Closing DB connection :) ... ");

        return isValidUser;
    }
}
