package com.dragon.mall.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
    public static String request(String host, Map<String, String> params)
            throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(host);

        if (params.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Iterator<String> iterator = params.keySet().iterator(); iterator
                    .hasNext();) {
                String k = (String) iterator.next();
                nvps.add(new BasicNameValuePair(k, params.get(k)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        }

        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity, "UTF-8");
        response.close();

        return content;
    }
}
