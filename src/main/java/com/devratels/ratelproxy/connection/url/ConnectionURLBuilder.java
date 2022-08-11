package com.devratels.ratelproxy.connection.url;

import com.devratels.ratelproxy.connection.ConnectionConfig;

public interface ConnectionURLBuilder {
    String build(ConnectionConfig config);
}
