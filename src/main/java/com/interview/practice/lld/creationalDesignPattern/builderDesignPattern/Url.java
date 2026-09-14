package com.interview.practice.lld.creationalDesignPattern.builderDesignPattern;

public class Url {

    private String protocol;
    private String host;
    private String port;
    private String basePath;
    private String queryParam;
    private String pathParam;
    private String body;

    private Url(UrlBuilder builder){
        this.host = builder.host;
        this.protocol = builder.protocol;
        this.port = builder.port;
        this.basePath = builder.basePath;
        this.queryParam = builder.queryParam;
        this.pathParam = builder.PathParam;
        this.body = builder.body;
    }

    public String getBasePath() {
        return basePath;
    }

    public String getBody() {
        return body;
    }

    public String getHost() {
        return host;
    }

    public String getPathParam() {
        return pathParam;
    }

    public String getPort() {
        return port;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getQueryParam() {
        return queryParam;
    }
    @Override
    public String toString() {
        return "Url{" +
                "protocol='" + protocol + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", basePath='" + basePath + '\'' +
                ", queryParam='" + queryParam + '\'' +
                ", pathParam='" + pathParam + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public static class UrlBuilder{
        private String protocol;
        private String host;
        private String port;
        private String basePath;
        private String queryParam;
        private String PathParam;
        private String body;

        public UrlBuilder setProtocol(String protocol){
            this.protocol = protocol;
            return this;
        }
        public UrlBuilder setHost(String host){
            this.host = host;
            return this;
        }

        public UrlBuilder setBasePath(String basePath) {
            this.basePath = basePath;
            return this;
        }
        public UrlBuilder setQueryParam(String queryParam){
            this.queryParam = queryParam;
            return this;
        }
        public UrlBuilder setPathParam(String pathParam){
            this.PathParam = pathParam;
            return this;
        }
        public UrlBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public Url build(){
            return new Url(this);
        }
    }



}
