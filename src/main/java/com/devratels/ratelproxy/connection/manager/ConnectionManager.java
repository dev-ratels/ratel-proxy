package com.devratels.ratelproxy.connection.manager;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class ConnectionManager {

    public static ConnectionManager getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final ConnectionManager INSTANCE = new ConnectionManager();
    }

    private Map<String, Connection> connectionMap = new HashMap<>();

    public String add(Connection connection) {
        String key = UUID.randomUUID().toString();
        connectionMap.put(key, connection);
        return key;
    }

    public void remove(String key) {
        connectionMap.remove(key);
    }

    public Connection get(String key) {
        return connectionMap.get(key);
    }
}
