package shared;

import util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {

    public Connection getConnection(){
        try {
            PropertiesUtil util = new PropertiesUtil();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection
                    (util.getProperty("db.url"),util.getUsername("db.user"),util.getPassword("db.password"));
            Thread.sleep(800000000);
            if(!connection.isClosed())
                System.out.println("Connection established with data base");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
