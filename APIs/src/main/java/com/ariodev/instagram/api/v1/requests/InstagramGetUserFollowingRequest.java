package com.ariodev.instagram.api.v1.requests;

import com.ariodev.instagram.api.v1.requests.payload.InstagramGetUserFollowersResult;
import com.ariodev.instagram.api.v1.util.InstagramConstants;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Created by root on 09/06/17.
 */

@RequiredArgsConstructor
@AllArgsConstructor
public class InstagramGetUserFollowingRequest extends InstagramGetRequest<InstagramGetUserFollowersResult>
{


    private long userId;
    private String maxId;

    @Override
    public String getUrl()
    {
        String baseUrl = "friendships/" + userId + "/following/?rank_token=" + api.getRankToken() + "&ig_sig_key_version=" + InstagramConstants.API_KEY_VERSION;
        if (maxId != null && !maxId.isEmpty())
        {
            baseUrl += "&max_id=" + maxId;
        }
        return baseUrl;
    }

    @Override
    public InstagramGetUserFollowersResult parseResult(int resultCode, String content)
    {
        return parseJson(resultCode, content, InstagramGetUserFollowersResult.class);
    }
}
