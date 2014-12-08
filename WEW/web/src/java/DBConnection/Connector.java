package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {
    protected String username = "root";
    protected String password = "root";
    protected String url = "jdbc:mysql://localhost:3306/foobar";
    protected String driver = "com.mysql.jdbc.Driver";
    
    public Connection getConnection(){
        try {
            Class.forName(driver);
            Connection c = DriverManager.getConnection(url, username, password);
            return c;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
