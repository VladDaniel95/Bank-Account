package sample.domain;




import java.sql.*;


public class dbConnection {
    // creez conexiunea in mod singleton la baza de date
    // JDBC name and database url
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Bank";

    // database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    public Connection connection;

    public static dbConnection db;

    private dbConnection() {
        try {
            // register jdbc driver
            // step 3:open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            // handle errors for Class.forName
            e.printStackTrace();
        }

    }

    public static synchronized dbConnection getConnection() {
        // pentru a ne asigura ca db este instantiat o singura data, indiferent de unde se apeleaza
        if (db == null) {
            db = new dbConnection();
        }
        return db;
    }
}
