package com.ariodev.instagram.api.v1.requests;

import android.util.Log;

import com.ariodev.instagram.api.v1.requests.payload.InstagramLoginPayload;
import com.ariodev.instagram.api.v1.requests.payload.InstagramLoginResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Created by root on 09/06/17.
 */

@AllArgsConstructor
public class InstagramLoginRequest extends InstagramPostRequest<InstagramLoginResult>
{
    private final InstagramLoginPayload payload;

    @Override
    public String getUrl()
    {
        return "accounts/login/";
    }

    @Override
    @SneakyThrows
    public String getPayload()
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(payload);
    }

    @Override
    @SneakyThrows
    public InstagramLoginResult parseResult(int statusCode, String content)
    {
        return parseJson(statusCode, content, InstagramLoginResult.class);
    }

    @Override
    public boolean requiresLogin()
    {
        return false;
    }
}
