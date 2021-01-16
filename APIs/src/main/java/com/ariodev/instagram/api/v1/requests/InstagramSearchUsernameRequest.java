package com.ariodev.instagram.api.v1.requests;

import com.ariodev.instagram.api.v1.requests.payload.InstagramSearchUsernameResult;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Created by root on 09/06/17.
 */

@AllArgsConstructor
public class InstagramSearchUsernameRequest extends InstagramGetRequest<InstagramSearchUsernameResult> {

    private final String username;

    @Override
    public String getUrl() {
        return "users/" + username + "/usernameinfo/";
    }

    @Override
    @SneakyThrows
    public InstagramSearchUsernameResult parseResult(int statusCode, String content) {
        return parseJson(statusCode, content, InstagramSearchUsernameResult.class);
    }

}
