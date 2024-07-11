package org.example.testjwt.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.testjwt.controller.Request.Token;
import org.example.testjwt.service.JwtValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validation")
public class JwtController {

    private static Log log = LogFactory.getLog(JwtController.class);

    @Autowired
    private JwtValidation jwtValidation;

    @PostMapping("/token")
    public ResponseEntity<Boolean> validateJwtToken(@RequestBody Token token) {
     return ResponseEntity.ok(jwtValidation.validateJwtToken(token.getToken()));
    }
}
