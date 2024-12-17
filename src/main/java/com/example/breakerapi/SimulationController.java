package com.example.breakerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simulate")
public class SimulationController {

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @GetMapping("/breaker")
    public ResponseEntity<String> simulateBreaker() {
        String response = circuitBreakerService.testCircuitBreaker();
        return ResponseEntity.ok(response);
    }
}
