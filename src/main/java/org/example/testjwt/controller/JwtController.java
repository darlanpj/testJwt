package org.example.testjwt.controller;

import org.example.testjwt.controller.Request.Token;
import org.example.testjwt.service.JwtValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JwtController {

    @Autowired
    private JwtValidation jwtValidation;

    @PostMapping("/validation/token")
    public ResponseEntity<Boolean> validateJwtToken(@RequestBody Token token) {
     return ResponseEntity.ok(jwtValidation.validateJwtToken(token.getToken()));
    }
}
