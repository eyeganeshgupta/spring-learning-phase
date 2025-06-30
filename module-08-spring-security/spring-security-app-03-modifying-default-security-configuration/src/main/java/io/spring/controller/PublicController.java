package io.spring.controller;

import io.spring.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/rates")
    public ResponseEntity<ApiResponse<Map<String, Double>>> getInterestRates() {
        Map<String, Double> rates = Map.of(
                "Savings", 3.5,
                "Fixed Deposit - 1 Yr", 6.0,
                "Fixed Deposit - 5 Yr", 6.5
        );
        ApiResponse<Map<String, Double>> response = new ApiResponse<>(true, "Interest rates fetched", rates);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/about")
    public ResponseEntity<ApiResponse<String>> getAboutInfo() {
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Bank info", "Welcome to TrustBank! We are here for your financial growth.")
        );
    }
}
