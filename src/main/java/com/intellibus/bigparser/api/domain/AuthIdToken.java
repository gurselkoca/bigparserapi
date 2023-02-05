package com.intellibus.bigparser.api.domain;



import java.util.Date;
import java.util.Objects;


public record AuthIdToken (String authId, Date date, Integer validityDuration) {

    public AuthIdToken {
        Objects.requireNonNull(authId);
        Objects.requireNonNull(date);
        Objects.requireNonNull(validityDuration);
    }

    public boolean tokenExpired(){
       long expirationTime =  date.getTime()+validityDuration*1000;
       return System.currentTimeMillis()>=expirationTime;
    }

}
