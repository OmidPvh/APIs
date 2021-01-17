package com.ariodev.instagram.api.v1.requests;

import com.ariodev.instagram.api.v1.requests.payload.InstagramGetMediaCommentsResult;
import com.ariodev.instagram.api.v1.util.InstagramConstants;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * Created by root on 09/06/17.
 */

@AllArgsConstructor
public class InstagramGetMediaCommentsRequest extends InstagramGetRequest<InstagramGetMediaCommentsResult>
{

    @NonNull
    private final String mediaId;
    private final String maxId;

    @Override
    public String getUrl()
    {
        String url = "media/" + mediaId + "/comments/?ig_sig_key_version=" + InstagramConstants.API_KEY_VERSION;
        if (maxId != null && !maxId.isEmpty())
        {
            url += "&max_id=" + maxId;
        }
        return url;
    }

    @Override
    public InstagramGetMediaCommentsResult parseResult(int resultCode, String content)
    {
        return parseJson(resultCode, content, InstagramGetMediaCommentsResult.class);
    }
}
