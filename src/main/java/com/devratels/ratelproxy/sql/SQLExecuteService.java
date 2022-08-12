package com.devratels.ratelproxy.sql;

import com.devratels.ratelproxy.connection.manager.ConnectionManager;
import com.devratels.ratelproxy.connection.manager.StatementManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SQLExecuteService {

    public SQLExecuteResponse execute(SQLExecuteRequest request) throws SQLException {
        Connection connection = ConnectionManager.getInstance().get(request.getConnectionKey());

        PreparedStatement preparedStatement = connection.prepareStatement(request.getQuery());
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();

        SQLExecuteResponse response = new SQLExecuteResponse();
        response.setUpdateCount(preparedStatement.getUpdateCount());
        response.setResultSet(resultSetToJson(resultSet));

        return response;
    }

    public SQLExecuteResponse fetch(String key) {
        return null;
    }

    private List<Map<String, Object>> resultSetToJson(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd =  rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        List<Map<String, Object>> resultList = new ArrayList<>();

        while (rs.next()) {
            Map<String, Object> result = new HashMap<>();
            for (int index = 1; index <= columnCount; index++) {
                String columnName = rsmd.getColumnName(index);
                Object columnValue = rs.getObject(columnName);

                result.put(columnName, columnValue);
            }
            resultList.add(result);
        }

        return resultList;
    }
}
