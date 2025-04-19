package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionC {

    public Connection getConnection()
    {
        Connection connection= null;

        try {
                connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/contactos","root","");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }

}
