package com.liw.domain.dao;

import com.liw.domain.entity.ApiConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiConfigDAO extends JpaRepository<ApiConfig,String> {

    ApiConfig findOneByKey(String key);

}
