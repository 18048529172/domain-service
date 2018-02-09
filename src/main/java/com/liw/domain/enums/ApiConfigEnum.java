package com.liw.domain.enums;

public enum ApiConfigEnum {

    API_HOST("api_host","api的host"),
    API_PORT("api_port","api的端口")
    ;
    private String name;

    private String memo;

    private ApiConfigEnum(String name,String memo){
        this.name = name;
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public String getMemo() {
        return memo;
    }

}
