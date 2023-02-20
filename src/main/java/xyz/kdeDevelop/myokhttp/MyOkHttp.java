package xyz.kdeDevelop.myokhttp;

import okhttp3.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class MyOkHttp {

    /**
     * RequestData 객체를 받아 그 속에 있는 정보로 HTTP 또는 HTTPS 요청을 보내고 Reponse를 byte[]형태로 반환하는 함수.
     * @param requestData Request할 정보
     * @return 요청 Response
     * @throws IOException 요청 실패시 Exception 전달
     */
    public static byte[] getResponse(RequestData requestData) throws IOException {
        byte[] result = null;

        OkHttpClient.Builder OkHttpClientBuilder = new OkHttpClient().newBuilder();

        //PROXY
        ProxyData proxyData = requestData.getProxyData();
        if (proxyData != null)
            OkHttpClientBuilder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyData.getUrl(), proxyData.getPort())));

        OkHttpClient okHttpClient = OkHttpClientBuilder.build();

        Request.Builder requestBuilder = new Request.Builder();

        //URL
        requestBuilder.url(requestData.getUrl());

        //USER AGENT
        String userAgent = requestData.getUserAgent();
        if (userAgent != null)
            requestBuilder.addHeader("User-Agent", userAgent);

        //REFERER URL
        String refererUrl = requestData.getRefererUrl();
        if (refererUrl != null)
            requestBuilder.addHeader("Referer", refererUrl);

        //HTTP METHOD & REQUEST BODY
        switch (requestData.getRequestType()) {
            case GET : {
                requestBuilder.get();
                break;
            }
            case POST : {
                RequestBody requestBody = RequestBody.create(requestData.getData(), MediaType.parse("application/text; charset=utf-8"));
                requestBuilder.post(requestBody);
                break;
            }
            case PUT : {
                RequestBody requestBody = RequestBody.create(requestData.getData(), MediaType.parse("application/text; charset=utf-8"));
                requestBuilder.put(requestBody);
                break;
            }
        }

        Request request = requestBuilder.build();

        Response response = okHttpClient.newCall(request).execute();

        if (response.code() == HttpURLConnection.HTTP_OK) {
            result = response.body().bytes();
        }

        response.close();

        return result;
    }
}
