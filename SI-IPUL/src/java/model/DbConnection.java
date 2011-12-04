package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    Connection conn = null;

    public DbConnection() {
        String URL = "jdbc:mysql://localhost:3306/si-ipul";
        String USER = "root";
        String PASS = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeConnection() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception ex) {
            }
        }
    }
}
