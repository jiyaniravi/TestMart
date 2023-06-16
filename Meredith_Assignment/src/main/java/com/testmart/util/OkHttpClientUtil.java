/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.util;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class OkHttpClientUtil {

    private static final Logger LOG = LogManager.getLogger();

    public static String getHttpRequest(String url){
        return getHttpRequest(url, null);
    }

    public static String getHttpRequest(String url, Map<String, String> queryParams){
        try{
            OkHttpClient client = new OkHttpClient();
            HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
            addQueryParameters(queryParams, urlBuilder);
            url = urlBuilder.build().toString();

            LOG.debug("Requested URL={}",url);
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();

            return response.body().string();
        } catch (IOException e) {
            LOG.error("An error occurred while retrieving data for url={} and queryParams={}, exception={}",url,queryParams,e);
            throw new RuntimeException(e);
        }
    }

    private static void addQueryParameters(Map<String, String> queryParams, HttpUrl.Builder urlBuilder) {
        if(queryParams !=null && queryParams.size()!=0){
            for(Map.Entry<String, String> queryParam: queryParams.entrySet()){
                String key = queryParam.getKey();
                if(key!=null && "".equalsIgnoreCase(key)) {
                    urlBuilder.addQueryParameter(key, queryParam.getValue());
                }
            }
        }
    }
}
