package com.ariodev.instagram.api.v1.requests;

import com.ariodev.instagram.api.v1.requests.payload.InstagramFriendshipStatus;

public class InstagramGetFriendshipRequest extends InstagramGetRequest<InstagramFriendshipStatus>
{
    private final long userId;

    public InstagramGetFriendshipRequest(long userId)
    {
        this.userId = userId;
    }

    @Override
    public String getUrl()
    {
        return "friendships/show/" + userId;
    }

    @Override
    public InstagramFriendshipStatus parseResult(int statusCode, String content)
    {
        return this.parseJson(content, InstagramFriendshipStatus.class);
    }
}
