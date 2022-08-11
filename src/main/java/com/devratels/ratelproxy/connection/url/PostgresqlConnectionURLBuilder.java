package com.devratels.ratelproxy.connection.url;

import com.devratels.ratelproxy.connection.ConnectionConfig;

public class PostgresqlConnectionURLBuilder implements ConnectionURLBuilder{
    @Override
    public String build(ConnectionConfig config) {
        StringBuilder stringBuilder = new StringBuilder("jdbc:postgresql://");
        stringBuilder.append(config.getHost());
        if (config.getPort() != null) stringBuilder.append(":").append(config.getPort());
        return stringBuilder.toString();
    }
}
