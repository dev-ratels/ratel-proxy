package com.devratels.ratelproxy.connection;

import com.devratels.ratelproxy.connection.url.ConnectionURLBuilder;
import com.devratels.ratelproxy.connection.url.MariaConnectionURLBuilder;
import com.devratels.ratelproxy.connection.url.MysqlConnectionURLBuilder;
import com.devratels.ratelproxy.connection.url.PostgresqlConnectionURLBuilder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum ConnectionType {
    MYSQL("RDBMS", "MYSQL", "com.mysql.cj.jdbc.Driver", new MysqlConnectionURLBuilder()),
    MARIA("RDBMS", "MARIA", "org.mariadb.jdbc.Driver", new MariaConnectionURLBuilder()),
    POSTGRESQL("RDBMS", "POSTGRESQL", "org.postgresql.Driver", new PostgresqlConnectionURLBuilder());

    private final String dbType;
    private final String vendor;
    private final String driverClassPath;
    private final ConnectionURLBuilder urlBuilder;

    public String getURL(ConnectionConfig config) {
        return urlBuilder.build(config);
    }

    public static List<ConnectionType> findAll() {
        return Arrays.stream(ConnectionType.values())
                .collect(Collectors.toList());
    }

    public static ConnectionType findByVendor(String vendor) {
        return Arrays.stream(ConnectionType.values())
                .filter(type -> type.getVendor().equals(vendor))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No Such Vendor"));
    }

    public static List<ConnectionType> findByDbType(String dbType) {
        return Arrays.stream(ConnectionType.values())
                .filter(type -> type.getDbType().equals(dbType))
                .collect(Collectors.toList());
    }
}
