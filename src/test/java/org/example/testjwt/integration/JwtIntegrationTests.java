package org.example.testjwt.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.testjwt.controller.Request.Token;
import org.example.testjwt.util.TokenCases;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class JwtIntegrationTests {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();

	private static final String URL_TEMPLATE = "/api/v1/validation/token";

	@Test
	@DisplayName("Validation case 1 - Jwt validation ok")
	void validateJwtToken_ValidToken_ReturnsTrue() throws Exception {
		Token token = new Token();
		token.setToken(TokenCases.TOKEN_CASE_1);
		mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(token)))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("true"));

	}

	@Test
	@DisplayName("Validation case 2 - Invalid token")
	void validateJwtToken_InvalidToken_ReturnsFalse() throws Exception {
		Token token = new Token();
		token.setToken(TokenCases.TOKEN_CASE_2);
		mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(token)))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("false"));

	}

	@Test
	@DisplayName("Validation case 3 - Claim Name Has Numeric")
	void validateJwtToken_ClaimNameHasNumeric_ReturnsFalse() throws Exception {
		Token token = new Token();
		token.setToken(TokenCases.TOKEN_CASE_3);
		mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(token)))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("false"));
	}

	@Test
	@DisplayName("Validation case 4 - More claims not permitted")
	void validateJwtToken_MoreClaimNotPermitted_ReturnsFalse() throws Exception {
		Token token = new Token();
		token.setToken(TokenCases.TOKEN_CASE_4);
		mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(token)))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("false"));
	}

	@Test
	@DisplayName("Validation case 5 - More claims not permitted")
	void validateJwtToken_SeedNotPrime_ReturnsFalse() throws Exception {
		Token token = new Token();
		token.setToken(TokenCases.TOKEN_CASE_5);
		mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(token)))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("false"));
	}

	@Test
	@DisplayName("Validation case 6 - claim role not allowed")
	void validateJwtToken_ClaimRoleNotAllowed_ReturnsFalse() throws Exception {
		Token token = new Token();
		token.setToken(TokenCases.TOKEN_CASE_7);
		mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(token)))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("false"));
	}

	@Test
	@DisplayName("Validation case 7 - claim name exceeds 256 characters")
	void validateJwtToken_ClaimNameExceeds256Characters_ReturnsFalse() throws Exception {
		Token token = new Token();
		token.setToken(TokenCases.TOKEN_CASE_7);
		mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(token)))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("false"));
	}

}
