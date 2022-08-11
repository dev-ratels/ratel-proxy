package com.devratels.ratelproxy.connection.manager;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class ResultSetManager {

    public static ResultSetManager getInstance() {
        return ResultSetManager.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final ResultSetManager INSTANCE = new ResultSetManager();
    }

    // TODO: When garbage??
    private Map<String, ResultSet> resultSetMap = new HashMap<>();
}
