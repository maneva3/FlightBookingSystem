package com.flightbookingsystem.web.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeApiController {
    @GetMapping
    public ResponseEntity<?> getHomepage() {
        Map<String, String> data = new HashMap<>();
        data.put("message", "Success");
        return ResponseEntity.ok(data);
    }
}
