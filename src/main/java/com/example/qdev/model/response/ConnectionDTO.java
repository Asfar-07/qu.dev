package com.example.qdev.model.response;

public class ConnectionDTO {
    final String url;

    private String path;
    private String host;
    private String port;
    private String nameDB;

    public ConnectionDTO(String url){
        this.url=url;
    }

    public String getNameDB() {
        String[] data=url.split(":");
        return data[1];
    }

    public String getPath() {
        String[] data=url.split("jdbc:");
        return data[data.length-1];
    }

    public String getHost() {
        String[] data=url.split("/");
        return data[2].split(":")[0];
    }

    public String getPort() {
        String[] data=url.split("/");
        return data[2].split(":")[1];
    }


}
