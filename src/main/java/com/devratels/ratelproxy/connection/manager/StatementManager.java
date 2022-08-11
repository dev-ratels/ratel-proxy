package com.devratels.ratelproxy.connection.manager;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class StatementManager {

    public static StatementManager getInstance() {
        return StatementManager.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final StatementManager INSTANCE = new StatementManager();
    }

    // TODO: When garbage??
    private Map<String, Statement> statementMap = new HashMap<>();
}
