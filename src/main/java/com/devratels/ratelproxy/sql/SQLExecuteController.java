package com.devratels.ratelproxy.sql;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sql")
@RequiredArgsConstructor
public class SQLExecuteController {

    private final SQLExecuteService service;

    @PostMapping("/execute")
    public SQLExecuteResponse execute(@RequestBody SQLExecuteRequest request) throws SQLException {
        return service.execute(request);
    }

    @GetMapping("/fetch")
    public SQLExecuteResponse fetch(@RequestParam String key) {
        return service.fetch(key);
    }
}
