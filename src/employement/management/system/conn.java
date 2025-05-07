package employement.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
//    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
//    private static final String username = "root";
//    private static final String password = "28041997";

    Connection connection;

    Statement statement;

    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "28041997");
            statement = connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
