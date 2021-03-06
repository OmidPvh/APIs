package com.ariodev.instagram.api.v1.requests;

import com.ariodev.instagram.api.v1.requests.payload.InstagramGetUserFollowersResult;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/**
 * Created by root on 09/06/17.
 */

@RequiredArgsConstructor
@AllArgsConstructor
public class InstagramGetUserFollowersRequest extends InstagramGetRequest<InstagramGetUserFollowersResult> {


    private long userId;
    private String maxId;

    @Override
    public String getUrl() {
        String baseUrl = "friendships/" + userId + "/followers/?rank_token=" + api.getRankToken();
        if (maxId != null && !maxId.isEmpty()) {
            baseUrl += "&max_id=" + maxId;
        }

        return baseUrl;
    }

    @Override
    @SneakyThrows
    public InstagramGetUserFollowersResult parseResult(int statusCode, String content) {
        return parseJson(statusCode, content, InstagramGetUserFollowersResult.class);
    }
}
