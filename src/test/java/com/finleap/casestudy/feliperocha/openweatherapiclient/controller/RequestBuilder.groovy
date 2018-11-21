package com.finleap.casestudy.feliperocha.openweatherapiclient.controller

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@Component
class RequestBuilder {

    MockHttpServletRequestBuilder buildGetRequest(String url, String version = '1.0') {
        get(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header('Api-Version', version)
    }
}
