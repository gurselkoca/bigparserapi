package com.intellibus.bigparser.api.domain;


import java.util.Objects;


public record LoginRequest (String emailId, String password,Boolean loggedIn) {

     public LoginRequest {
          Objects.requireNonNull(emailId);
          Objects.requireNonNull(password);
          Objects.requireNonNull(loggedIn);
     }
      public LoginRequest(String emailId, String password){
           this(emailId,password,true);
      }




}
