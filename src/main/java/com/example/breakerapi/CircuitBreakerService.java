package com.example.breakerapi;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerService {
    private int requestCounter = 0;

    @CircuitBreaker(name = "exampleBreaker", fallbackMethod = "fallbackForCircuitBreaker")
    public String testCircuitBreaker() {
        requestCounter++;
        System.out.println("Request attempt: " + requestCounter);

        if (requestCounter <= 6) {
            throw new RuntimeException("Simulated failure!");
        }
        return "Request successful!";
    }

    // Correct fallback signature
    public String fallbackForCircuitBreaker(Throwable t) {
        System.out.println("Fallback triggered: " + t.getMessage());
        return "Fallback Response: Circuit is OPEN!";
    }
}

