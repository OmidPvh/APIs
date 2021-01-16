package com.ariodev.instagram.api.v1.requests.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ariodev.instagram.api.v1.requests.InstagramPostRequest;
import com.ariodev.instagram.api.v1.requests.payload.StatusResult;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Created by root on 09/06/17.
 */

@AllArgsConstructor
public class InstagramExposeRequest extends InstagramPostRequest<StatusResult> {

    @Override
    public String getUrl() {
        return "qe/expose/";
    }

    @Override
    @SneakyThrows
    public String getPayload() {

        Map<String, Object> likeMap = new LinkedHashMap<>();
        likeMap.put("_uuid", api.getUuid());
        likeMap.put("_uid", api.getUserID());
        likeMap.put("id", api.getUserID());
        likeMap.put("_csrftoken", api.getOrFetchCsrf(null));
        likeMap.put("experiment", "ig_android_profile_contextual_feed");

        ObjectMapper mapper = new ObjectMapper();
        String payloadJson = mapper.writeValueAsString(likeMap);

        return payloadJson;
    }

    @Override
    @SneakyThrows
    public StatusResult parseResult(int statusCode, String content) {
        return parseJson(statusCode, content, StatusResult.class);
    }

}
