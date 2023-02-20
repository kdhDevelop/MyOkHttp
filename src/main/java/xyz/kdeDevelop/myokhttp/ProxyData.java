package xyz.kdeDevelop.myokhttp;

public class ProxyData {

    private final String url;
    private final int port;

    public ProxyData(String url, int port) {
        this.url = url;
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public int getPort() {
        return port;
    }
}
