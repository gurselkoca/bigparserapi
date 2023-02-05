package com.intellibus.bigparser.api.property;

import  static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {BigParserProperties.class})
public class BigParserPropertiesTest {

    @Autowired
    BigParserProperties bigParserProperties;

    @Test
    public void validateProperties(){
        assertNotNull(bigParserProperties.getApiV1Base());
        assertNotNull(bigParserProperties.getGridCreate());
        assertNotNull(bigParserProperties.getTokenInvalidSeconds());
        assertNotNull(bigParserProperties.getLogin());
        assertNotNull(bigParserProperties.getPassword());
        assertNotNull(bigParserProperties.getEmailId());

        assertEquals(bigParserProperties.getApiV1Base()+bigParserProperties.getLoginBase(),bigParserProperties.getLogin());
    }

}
