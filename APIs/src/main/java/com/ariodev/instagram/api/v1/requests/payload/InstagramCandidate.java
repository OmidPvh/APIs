package com.ariodev.instagram.api.v1.requests.payload;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by root on 21/09/17.
 */

@Getter
@Setter
@ToString(callSuper = true)
public class InstagramCandidate implements Serializable {

    public String url;
    public int width;
    public int height;

}
