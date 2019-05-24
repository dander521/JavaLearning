package com.miaoshaproject.service;

public interface CacheService {

    void setCommonCache(String key, Object object);

    Object getFromCommonCache(String key);
}
