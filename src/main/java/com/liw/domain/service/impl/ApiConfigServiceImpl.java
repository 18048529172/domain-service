package com.liw.domain.service.impl;

import com.liw.domain.dao.ApiConfigDAO;
import com.liw.domain.enums.ApiConfigEnum;
import com.liw.domain.service.ApiConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiConfigServiceImpl implements ApiConfigService {

    @Autowired
    private ApiConfigDAO apiConfigDAO;

    @Override
    public String getApiByPath(String apiPath) {
        String host = this.apiConfigDAO.findOneByKey(ApiConfigEnum.API_HOST.getName()).getValue();
        String port = this.apiConfigDAO.findOneByKey(ApiConfigEnum.API_PORT.getName()).getValue();
        return "http://"+host+":"+port+apiPath;
    }
}
