package com.bfhl.controller;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import com.bfhl.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BfhlController {

    @Autowired
    private BfhlService bfhlService;

    @PostMapping
    public ResponseEntity<BfhlResponse> processBfhlData(@RequestBody(required = false) BfhlRequest request) {
        if (request == null) {
            BfhlResponse response = new BfhlResponse();
            response.setIs_success(false);
            response.setUser_id("priyanshi_khorwal_09052006");
            response.setEmail("priyanshikhorwal231190@acropolis.in");
            response.setRoll_number("0827CS231196");
            return ResponseEntity.ok(response);
        }
        BfhlResponse response = bfhlService.processData(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getOperationCode() {
        Map<String, Object> response = new HashMap<>();
        response.put("operation_code", 1);
        return ResponseEntity.ok(response);
    }
}
