package com.ariodev.instagram.api.v1.requests;

import com.ariodev.instagram.api.v1.requests.payload.InstagramSearchUsernameResult;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Get User Information Request
 *
 * @author Bruno Candido Volpato da Cunha
 */
@AllArgsConstructor
public class InstagramGetUserInfoRequest extends InstagramGetRequest<InstagramSearchUsernameResult>
{

    private final long userId;

    @Override
    public String getUrl()
    {
        return "users/" + userId + "/info/";
    }

    @Override
    @SneakyThrows
    public InstagramSearchUsernameResult parseResult(int statusCode, String content)
    {
        return parseJson(statusCode, content, InstagramSearchUsernameResult.class);
    }

}
