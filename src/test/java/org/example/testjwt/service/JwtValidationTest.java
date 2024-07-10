package org.example.testjwt.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.testjwt.domain.JwtPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class JwtValidationTest {

    @Mock
    private JwtValidation jwtService;

    @Mock
    private ObjectMapper objectMapper;

    @MockBean
    private Base64.Decoder decoder;


    private String tokenCase1 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";
    private String tokenCase2 = "eyJhbGciOiJzI1NiJ9.dfsdfsfryJSr2xrIjoiQWRtaW4iLCJTZrkIjoiNzg0MSIsIk5hbrUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05fsdfsIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";

    private String tokenCase3 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs";

    private String tokenCase4 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY";

    private String tokenCase5 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNjY4OCIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.9mbvr8JJSR5yoBszmW0c_ZaBtuyYdt5VTVcXXZscQCE";

    private String tokenCase6 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRGFybGFuIiwiU2VlZCI6Ijc4NDEiLCJOYW1lIjoiVG9uaW5obyBBcmF1am8ifQ.dcRCV801ODEwMmLOJPtkNiJ-QYZKBp8Ob3fRyqkLLRM";

    private String tokenCase7 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRGFybGFuIiwiU2VlZCI6Ijc4NDEiLCJOYW1lIjoiTG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdCwgc2VkIGRvIGVpdXNtb2QgdGVtcG9yIGluY2lkaWR1bnQgdXQgbGFib3JlIGV0IGRvbG9yZSBtYWduYSBhbGlxdWEuIFV0IGVuaW0gYWQgbWluaW0gdmVuaWFtLCBxdWlzIG5vc3RydWQgZXhlcmNpdGF0aW9uIHVsbGFtY28gbGFib3JpcyBuaXNpIHV0IGFsaXF1aXAgZXggZWEgY29tbW9kbyBjb25zZXF1YXQuIER1aXMgYXV0ZSBpcnVyZSBkb2xvciBpbiByZXByZWhlbmRlcml0IGluIHZvbHVwdGF0ZSB2ZWxpdCBlc3NlIGNpbGx1bSBkb2xvcmUgZXUgZnVnaWF0IG51bGxhIHBhcmlhdHVyLiJ9.UyAplTu1f_hnHKwIr-Z5pBk8YVtSMh5RRJN3LCCJI80";

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        decoder = Base64.getUrlDecoder();
    }
    @Test
    @DisplayName("Validation case 1 - Jwt validation ok")
    public void validateJwtToken_ValidToken_ReturnsTrue() throws JsonProcessingException {
        Map<String, String> details = new LinkedHashMap<>();
        details.put("Role","Admin");
        details.put("Seed","7841");
        details.put("Name","Toninho Araujo");

        JwtPayload jwtPayload = new JwtPayload();
        jwtPayload.setDetails(details);
        Mockito.mockStatic(Base64.Decoder.class);
        Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(Class.class))).thenReturn(jwtPayload);
        System.out.println(jwtService.validateJwtToken(tokenCase1));
        Assertions.assertTrue(jwtService.validateJwtToken(tokenCase1));
    }

    @Test
    @DisplayName("Validation case 2 - Invalid token")
    public void validateJwtToken_InvalidToken_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(tokenCase2));
    }

    @Test
    @DisplayName("Validation case 3 - Claim Name Is Numeric")
    public void validateJwtToken_ClaimNameIsNumeric_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(tokenCase3));
    }

    @Test
    @DisplayName("Validation case 4 - More claims not permitted")
    public void validateJwtToken_MoreClaimNotPermitted_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(tokenCase4));
    }


    @Test
    @DisplayName("Validation case 5 - Seed not prime number")
    public void validateJwtToken_SeedNotPrime_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(tokenCase5));
    }

    @Test
    @DisplayName("Validation case 6 - \n" +
            "claim name exceeds 256 characters")
    public void validateJwtToken_ClaimNameExceeds256Characters_ReturnsFalse() {
        Assertions.assertFalse(jwtService.validateJwtToken(tokenCase6));
    }
}
