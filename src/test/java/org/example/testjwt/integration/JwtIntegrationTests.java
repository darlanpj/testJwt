package org.example.testjwt.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.testjwt.controller.JwtController;
import org.example.testjwt.controller.Request.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class JwtIntegrationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@InjectMocks
	private JwtController jwtController;
	@Mock
	private ObjectMapper objectMapper;

	private String tokenCase1 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";
	private String tokenCase2 = "eyJhbGciOiJzI1NiJ9.dfsdfsfryJSr2xrIjoiQWRtaW4iLCJTZrkIjoiNzg0MSIsIk5hbrUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05fsdfsIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";

	private String tokenCase3 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs";

	private String tokenCase4 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY";

	private String tokenCase5 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNjY4OCIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.9mbvr8JJSR5yoBszmW0c_ZaBtuyYdt5VTVcXXZscQCE";

	private String tokenCase6 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRGFybGFuIiwiU2VlZCI6Ijc4NDEiLCJOYW1lIjoiVG9uaW5obyBBcmF1am8ifQ.dcRCV801ODEwMmLOJPtkNiJ-QYZKBp8Ob3fRyqkLLRM";

	private String tokenCase7 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRGFybGFuIiwiU2VlZCI6Ijc4NDEiLCJOYW1lIjoiTG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdCwgc2VkIGRvIGVpdXNtb2QgdGVtcG9yIGluY2lkaWR1bnQgdXQgbGFib3JlIGV0IGRvbG9yZSBtYWduYSBhbGlxdWEuIFV0IGVuaW0gYWQgbWluaW0gdmVuaWFtLCBxdWlzIG5vc3RydWQgZXhlcmNpdGF0aW9uIHVsbGFtY28gbGFib3JpcyBuaXNpIHV0IGFsaXF1aXAgZXggZWEgY29tbW9kbyBjb25zZXF1YXQuIER1aXMgYXV0ZSBpcnVyZSBkb2xvciBpbiByZXByZWhlbmRlcml0IGluIHZvbHVwdGF0ZSB2ZWxpdCBlc3NlIGNpbGx1bSBkb2xvcmUgZXUgZnVnaWF0IG51bGxhIHBhcmlhdHVyLiJ9.UyAplTu1f_hnHKwIr-Z5pBk8YVtSMh5RRJN3LCCJI80";

	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void validateJwtToken_ValidToken_ReturnsTrue() throws Exception {
		Token token = new Token();
		token.setToken(tokenCase1);
		mockMvc.perform(MockMvcRequestBuilders.post("/validation/token")
				.contentType("application/json")
				.content(token.getToken()))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("true"));

	}

}
