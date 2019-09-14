package com.example.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by suman.das on 7/22/19.
 */
public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

    public RestTemplateHeaderModifierInterceptor() {

    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        /**
        final ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        final HttpServletRequest attrRequest = attr.getRequest();
        Enumeration headerNames = attrRequest.getHeaderNames();
        String value = null;
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            if ("projectId".equalsIgnoreCase(key)) {
                value = attrRequest.getHeader(key);
                request.getHeaders().add(key, value);
            }
        }
         */
        String projectId = TenantContext.getCurrentTenant();
        request.getHeaders().add("X-TenantID", projectId);
        ClientHttpResponse response = clientHttpRequestExecution.execute(request, body);
        response.getHeaders().add("X-TenantID", projectId);
        return response;


    }
}
