package com.djachtoma.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpProtocol {

    HTTP_NO_SECURE_LAYER("http://"),
    HTTP_SECURE_LAYER("https://");

    private final String protocol;


}
