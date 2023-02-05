package com.intellibus.bigparser.api.security;

import com.intellibus.bigparser.api.domain.AuthIdToken;
import com.intellibus.bigparser.api.domain.LoginRequest;
import com.intellibus.bigparser.api.domain.LoginResponse;
import com.intellibus.bigparser.api.property.BigParserProperties;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthIdManagerTest {

    @InjectMocks
    AuthIdManager authIdManager;

    @Mock
    BigParserProperties bigParserProperties;

    @Mock
    RestTemplate restTemplate;

    private LoginResponse loginResponse;
    @BeforeEach
    public void init(){
        Faker faker = new Faker(new Random(System.currentTimeMillis()));
        when(bigParserProperties.getEmailId()).thenReturn(faker.bothify("??????##@gmail.com"));
        when(bigParserProperties.getPassword()).thenReturn(faker.bothify("??????##"));
        when(bigParserProperties.getTokenInvalidSeconds()).thenReturn(1);
        when(bigParserProperties.getLogin()).thenReturn(faker.internet().ipV4Address());
        loginResponse = new LoginResponse(faker.bothify("???##??##???"));
        ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<>(loginResponse, HttpStatusCode.valueOf(200));
        when(restTemplate.postForEntity(anyString(),any(LoginRequest.class),any(Class.class))).thenReturn(responseEntity);

    }

    @Test
    public void validToken_tokenNotExists_newTokenCreated(){
               AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
        assertEquals(loginResponse.getAuthId(),authIdToken.authId());
    }

    @Test
    public void validToken_validTokenExists_sameTokenReturned(){
        AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
        AuthIdToken secondAuthIdToken = authIdManager.validToken();
        assertEquals(loginResponse.getAuthId(),authIdToken.authId());
        assertEquals(authIdToken,secondAuthIdToken);
    }

    @Test
    public void validToken_tokenExpired_newTokenReturned() throws InterruptedException {
     //   when(bigParserProperties.getTokenInvalidSeconds()).thenReturn(1);
        AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
        assertFalse(authIdToken.tokenExpired());
        Thread.sleep(1100);
        assertTrue(authIdToken.tokenExpired());
        AuthIdToken secondAuthIdToken = authIdManager.validToken();
        assertNotEquals(authIdToken,secondAuthIdToken);
    }

}
