package com.victorp;

import java.util.Objects;

public class Request {
    private final String url;
    private final String methoud;

    public Request(String url, String methoud) {
        this.url = url;
        this.methoud = methoud;
    }

    public String getUrl() {
        return url;
    }

    public String getMethoud() {
        return methoud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(url, request.url) &&
                Objects.equals(methoud, request.methoud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, methoud);
    }
}
