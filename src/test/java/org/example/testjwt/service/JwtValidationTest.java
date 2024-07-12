package org.example.testjwt.service;

import org.example.testjwt.util.TokenCases;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JwtValidationTest {

    @InjectMocks
    private JwtValidation jwtService;

    @Test
    @DisplayName("Validation case 1 - Jwt validation ok")
    public void validateJwtToken_ValidToken_ReturnsTrue()  {
        Assertions.assertTrue(jwtService.validateJwtToken(TokenCases.TOKEN_CASE_1));
    }

    @Test
    @DisplayName("Validation case 2 - Invalid token")
    public void validateJwtToken_InvalidToken_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(TokenCases.TOKEN_CASE_2));
    }

    @Test
    @DisplayName("Validation case 3 - Claim Name Has Numeric")
    public void validateJwtToken_ClaimNameHasNumeric_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(TokenCases.TOKEN_CASE_3));
    }

    @Test
    @DisplayName("Validation case 4 - More claims not permitted")
    public void validateJwtToken_MoreClaimNotPermitted_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(TokenCases.TOKEN_CASE_4));
    }


    @Test
    @DisplayName("Validation case 5 - Seed not prime number")
    public void validateJwtToken_SeedNotPrime_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(TokenCases.TOKEN_CASE_5));
    }

    @Test
    @DisplayName("Validation case 6 - \n" +
            "claim role not allowed")
    public void validateJwtToken_ClaimRoleNotAllowed_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(TokenCases.TOKEN_CASE_6));
    }

    @Test
    @DisplayName("Validation case 7 - \n" +
            "claim name exceeds 256 characters")
    public void validateJwtToken_ClaimNameExceeds256Characters_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(TokenCases.TOKEN_CASE_7));
    }
}
