package com.deadlock.fastjk.data.auth;

import com.deadlock.fastjk.configuration.GoogleSecretsDTO;
import com.deadlock.fastjk.exceptions.GoogleLoginException;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static java.util.Objects.isNull;

@Component
@Slf4j
@RequiredArgsConstructor
public class GoogleProvider {

    private final GoogleSecretsDTO googleSecretsDTO;

    public GoogleUserDTO authenticateGoogleInformation(String idGoogleToken ){
        GoogleIdToken idToken = verifyAndGetGoogleIdToken(idGoogleToken);
        return buildGoogleUserDTO(idToken);
    }

    private GoogleIdToken verifyAndGetGoogleIdToken(String idGoogleToken){
        JsonFactory jsonFactory = new GsonFactory();
        HttpTransport transport = new NetHttpTransport();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(googleSecretsDTO.CLIENT_ID()))
                .build();

        try {
            GoogleIdToken idToken = verifier.verify(idGoogleToken);
            if(isNull(idToken)) throw new GoogleLoginException("Invalid id token");
            return idToken;
        }catch (Exception exception) {
            log.error("error while validating google token");
            throw new GoogleLoginException();
        }
    }

    private GoogleUserDTO buildGoogleUserDTO(GoogleIdToken idToken) {
        Payload payload = idToken.getPayload();
        return new GoogleUserDTO(
                payload.getSubject(),
                payload.getEmail(),
                payload.getEmailVerified(),
                (String) payload.get("name"),
                (String) payload.get("given_name"),
                (String) payload.get("family_name"),
                (String) payload.get("picture"),
                (String) payload.get("locale")
        );

    }

}
