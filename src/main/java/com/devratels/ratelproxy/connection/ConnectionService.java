package com.devratels.ratelproxy.connection;

import com.devratels.ratelproxy.connection.manager.ConnectionManager;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ConnectionService {

    public String connect(ConnectionConfig config) throws SQLException {
        ConnectionType type = ConnectionType.findByVendor(config.getVendor());

        try {
            Class.forName(type.getDriverClassPath());
        } catch (ClassNotFoundException e) {
            // TODO: Internal Error (Fault)
            e.printStackTrace();
        }

        // TODO: Has User, Password?
        Connection connection = DriverManager.getConnection(
                type.getURL(config),
                config.getUser(),
                config.getPassword());

        return ConnectionManager.getInstance().add(connection);
    }

    public void disconnect() {

    }
}
