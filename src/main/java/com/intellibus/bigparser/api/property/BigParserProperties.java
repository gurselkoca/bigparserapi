package com.intellibus.bigparser.api.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bigparser")
@ConfigurationPropertiesScan
@Data
public class BigParserProperties {
    private String emailId;
    private String password;
    private String baseUrl;
    private String apiV1Base;
    private String apiV2Base;
    private String gridCreate;
    private String login;
    private String loginBase;
    private Integer tokenInvalidSeconds;

}
