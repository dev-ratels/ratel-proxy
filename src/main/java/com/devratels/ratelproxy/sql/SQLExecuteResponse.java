package com.devratels.ratelproxy.sql;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SQLExecuteResponse {
    private Integer updateCount;
    private List<Map<String, Object>> resultSet;
}
