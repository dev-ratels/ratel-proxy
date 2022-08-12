package com.devratels.ratelproxy.sql;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class SQLExecuteRequest {
    private String connectionKey;
    private String query;
    private Map<String, String> bindParameterMap;
}
