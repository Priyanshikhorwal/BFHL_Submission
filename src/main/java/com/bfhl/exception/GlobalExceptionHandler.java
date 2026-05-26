package com.bfhl.exception;

import com.bfhl.dto.BfhlResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BfhlResponse> handleException(Exception ex) {
        ex.printStackTrace();
        BfhlResponse response = new BfhlResponse();
        response.setIs_success(false);
        // Ensure standard fields are populated even on failure if requested,
        // but typically a generic error message or just is_success=false is enough.
        response.setUser_id("priyanshi_khorwal_09052006");
        response.setEmail("priyanshikhorwal231190@acropolis.in");
        response.setRoll_number("0827CS231196");
        return ResponseEntity.ok(response); // Return 200 OK with success=false as per some assessment patterns, or could be 400.
    }
}
