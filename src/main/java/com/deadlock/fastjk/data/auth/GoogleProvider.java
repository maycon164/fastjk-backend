package com.deadlock.fastjk.data.auth;

import com.deadlock.fastjk.exceptions.GoogleLoginException;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@Slf4j
public class GoogleProvider {

    private String SECRET;
    private String CLIENT_ID;

    public GoogleUserDTO authenticateGoogleInformation(String tokenId){
        return null;
    }


    private GoogleIdToken getVerifier(){
        JsonFactory jsonFactory = new GsonFactory();
        HttpTransport transport = new NetHttpTransport();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                // Specify the CLIENT_ID of the app that accesses the backend:
                .setAudience(Collections.singletonList(CLIENT_ID))
                // Or, if multiple clients access the backend:
                //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                .build();

        try {
            String token =  "Google token send from frontend";
            GoogleIdToken idToken = verifier.verify(token);
            return idToken;
        }catch (Exception exception) {
            log.error("error while validating google token");
            throw new GoogleLoginException();
        }
    }

}
