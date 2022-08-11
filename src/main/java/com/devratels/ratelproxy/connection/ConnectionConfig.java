package com.devratels.ratelproxy.connection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Properties;

@Getter
@Setter
@RequiredArgsConstructor
public class ConnectionConfig {
    private final String dbType;
    private final String vendor;
    private String host;
    private Integer port;
    private String user;
    private String password;
    private String database;
    private Properties vendorOptions = new Properties();

    // TODO: Handle Expected Exception Invalid Value Type
    public void setVendorOptions(Map<String, String> vendorOptions) {
        vendorOptions.forEach((key, value) -> {
            this.vendorOptions.setProperty(key, value);
        });
    }
}
