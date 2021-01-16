package com.ariodev.instagram.api.v1.requests;

import com.ariodev.instagram.api.v1.requests.payload.InstagramGetMediaLikersResult;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Created by Charlie on 13/06/17.
 */

@AllArgsConstructor
public class InstagramGetMediaLikersRequest extends InstagramGetRequest<InstagramGetMediaLikersResult> {

    private final long mediaId;

    @Override
    public String getUrl() {
        return "media/" + mediaId + "/likers/";
    }

    @Override
    @SneakyThrows
    public InstagramGetMediaLikersResult parseResult(int statusCode, String content) {
        return parseJson(statusCode, content, InstagramGetMediaLikersResult.class);
    }
}