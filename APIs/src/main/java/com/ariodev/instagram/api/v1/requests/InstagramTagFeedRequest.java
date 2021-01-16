package com.ariodev.instagram.api.v1.requests;

import com.ariodev.instagram.api.v1.requests.payload.InstagramFeedResult;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Created by root on 09/06/17.
 */

@AllArgsConstructor
public class InstagramTagFeedRequest extends InstagramGetRequest<InstagramFeedResult> {

    private final String tag;
    private final String maxId;

    @Override
    public String getUrl() {
        String url = "feed/tag/" + tag + "/?rank_token=" + api.getRankToken() + "&ranked_content=true&";
        if(maxId != null && !maxId.isEmpty()) {
            url += "&max_id=" + maxId;
        }
        return url;
    }

    @Override
    @SneakyThrows
    public InstagramFeedResult parseResult(int statusCode, String content) {
        return parseJson(statusCode, content, InstagramFeedResult.class);
    }

}
