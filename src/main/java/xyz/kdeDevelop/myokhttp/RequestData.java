package xyz.kdeDevelop.myokhttp;

public class RequestData {

    private RequestType requestType;
    private String url;
    private String refererUrl;
    private String userAgent;
    private ProxyData proxyData;
    private String data;

    private RequestData(Builder builder) {
        requestType = builder.requestType;
        url = builder.url;
        refererUrl = builder.refererUrl;
        userAgent = builder.userAgent;
        proxyData = builder.proxyData;
        data = builder.data;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setRefererUrl(String refererUrl) {
        this.refererUrl = refererUrl;
    }

    public String getRefererUrl() {
        return refererUrl;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setProxyData(ProxyData proxyData) {
        this.proxyData = proxyData;
    }

    public ProxyData getProxyData() {
        return proxyData;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public static class Builder {

        private RequestType requestType;
        private String url;
        private String refererUrl;
        private String userAgent;
        private ProxyData proxyData;
        private String data;

        public Builder requestType(RequestType requestType) {
            this.requestType = requestType;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder refererUrl(String refererUrl) {
            this.refererUrl = refererUrl;
            return this;
        }

        public Builder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public Builder proxyData(ProxyData proxyData) {
            this.proxyData = proxyData;
            return this;
        }

        public Builder data(String data) {
            this.data = data;
            return this;
        }

        public RequestData build() {
            return new RequestData(this);
        }
    }
}
