package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.UserModel;

public interface UserService {

    public UserModel getUserById(String id);

    public void register(UserModel userModel) throws BusinessException;

    public UserModel validateLogin(String telephone, String encrptPassword) throws BusinessException;
}
