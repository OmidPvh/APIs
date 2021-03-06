package com.ariodev.instagram.api.v1.requests;

import com.ariodev.instagram.api.v1.requests.payload.InstagramSearchUsersResult;
import com.ariodev.instagram.api.v1.util.InstagramConstants;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Created by root on 09/06/17.
 */

@AllArgsConstructor
public class InstagramSearchUsersRequest extends InstagramGetRequest<InstagramSearchUsersResult> {

    private final String query;

    @Override
    public String getUrl() {
        return "users/search/?ig_sig_key_version=" + InstagramConstants.API_KEY_VERSION
                + "&is_typeahead=true&query="+ query + "&rank_token=" + api.getRankToken();
    }

    @Override
    @SneakyThrows
    public InstagramSearchUsersResult parseResult(int statusCode, String content) {
        return parseJson(statusCode, content, InstagramSearchUsersResult.class);
    }

}
