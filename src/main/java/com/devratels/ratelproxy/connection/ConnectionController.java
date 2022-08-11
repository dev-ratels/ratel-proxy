package com.devratels.ratelproxy.connection;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/connection")
@RequiredArgsConstructor
public class ConnectionController {

    private final ConnectionService service;

    @PostMapping()
    public String connect(@RequestBody ConnectionConfig config) throws SQLException {
        // TODO: Should Delete throws SQLException and throw return Ratel Exception
        return service.connect(config);
    }

    @DeleteMapping()
    public void disconnect() {
        service.disconnect();
    }
}
