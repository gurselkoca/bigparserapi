package com.intellibus.bigparser.api.security;

import com.intellibus.bigparser.api.domain.AuthIdToken;
import com.intellibus.bigparser.api.property.BigParserProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthIdManagerIT {
    @Autowired
    AuthIdManager authIdManager;

    @SpyBean
    BigParserProperties bigParserProperties;

    @Test
    public void validToken_tokenNotExists_newTokenCreated(){
        AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
    }

    @Test
    public void validToken_validTokenExists_sameTokenReturned(){
        AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
        AuthIdToken secondAuthIdToken = authIdManager.validToken();
        assertEquals(authIdToken,secondAuthIdToken);
    }

    @Test
    public void validToken_tokenExpired_newTokenReturned() throws InterruptedException {
        when(bigParserProperties.getTokenInvalidSeconds()).thenReturn(1);
        AuthIdToken authIdToken = authIdManager.validToken();
        assertNotNull(authIdToken);
        assertFalse(authIdToken.tokenExpired());
        Thread.sleep(1100);
        assertTrue(authIdToken.tokenExpired());
        AuthIdToken secondAuthIdToken = authIdManager.validToken();
        assertNotEquals(authIdToken,secondAuthIdToken);
    }

}
