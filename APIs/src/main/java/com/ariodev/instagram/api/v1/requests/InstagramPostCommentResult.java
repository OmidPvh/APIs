package com.ariodev.instagram.api.v1.requests;


import com.ariodev.instagram.api.v1.requests.payload.InstagramComment;
import com.ariodev.instagram.api.v1.requests.payload.InstagramUser;
import com.ariodev.instagram.api.v1.requests.payload.StatusResult;

import java.util.ArrayList;


public class InstagramPostCommentResult extends StatusResult
{

    private InstagramComment comment;
    private ArrayList<InstagramUser> users;

}
