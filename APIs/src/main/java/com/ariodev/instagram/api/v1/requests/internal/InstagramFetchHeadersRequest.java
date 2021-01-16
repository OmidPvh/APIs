package com.ariodev.instagram.api.v1.requests.internal;

import com.ariodev.instagram.api.v1.requests.InstagramGetRequest;
import com.ariodev.instagram.api.v1.requests.payload.StatusResult;
import com.ariodev.instagram.api.v1.util.InstagramGenericUtil;

/**
 * Created by root on 08/06/17.
 */

public class InstagramFetchHeadersRequest extends InstagramGetRequest<StatusResult>
{

    @Override
    public String getUrl()
    {
        return "si/fetch_headers/?challenge_type=signup&guid=" + InstagramGenericUtil.generateUuid(false);
    }

    @Override
    public boolean requiresLogin()
    {
        return false;
    }

    @Override
    public StatusResult parseResult(int resultCode, String content)
    {
        return parseJson(resultCode, content, StatusResult.class);
    }
}
