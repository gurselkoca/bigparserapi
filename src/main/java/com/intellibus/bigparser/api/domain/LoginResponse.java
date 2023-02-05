package com.intellibus.bigparser.api.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class LoginResponse {
    @NonNull
    private String authId;
   // private boolean activationStatus;


//    {
//        "activationStatus": true,
//            "authId": "bd0a8dff-b38b-4b65-809e-39c6183dee6e",
//            "subscriptionInfo": {
//        "subscriptionType": "BASIC",
//                "orderGridId": "563c494fe4b0a9a5363287e7"
//    },
//        "userPreference": {
//        "id": "63c072c8177fca009fc13d2c",
//                "emailList": [
//        "gurselkoca@gmail.com"
//        ],
//        "userId": "6353f8f6d2f9ff00ff31609b",
//                "notificationType": {
//            "GRID_PAGE": true,
//                    "MY_DATA": true
//        }
//    },
//        "userStatus": "Completed",
//            "userinfo": {
//        "id": "6353f8f6d2f9ff00ff31609b",
//                "fullName": "Gursel Koca",
//                "emailId": "gursel.koca@intellibus.com",
//                "mobileNumber": "905545711571",
//                "dataStreamId": "6353f8f6d2f9ff00ff31609c",
//                "gridStreamId": "6353f8f6d2f9ff00ff31609d",
//                "role": "user"
//    }



}
