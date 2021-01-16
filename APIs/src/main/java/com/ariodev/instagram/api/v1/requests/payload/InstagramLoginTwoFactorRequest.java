package com.ariodev.instagram.api.v1.requests.payload;

import com.ariodev.instagram.api.v1.requests.InstagramPostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;


/**
 * Login TwoFactorRequest
 * 
 * @author Ozan Karaali
 *
 */
@AllArgsConstructor
public class InstagramLoginTwoFactorRequest extends InstagramPostRequest<InstagramLoginResult>
{

    private final InstagramLoginTwoFactorPayload payload;

    @Override
    public String getUrl() {
        return "accounts/two_factor_login/";
    }

    @Override
    @SneakyThrows
    public String getPayload() {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(payload);
    }

    @Override
    @SneakyThrows
    public InstagramLoginResult parseResult(int statusCode, String content) {
        return parseJson(statusCode, content, InstagramLoginResult.class);
    }

    @Override
    public boolean requiresLogin() {
        return false;
    }

}
