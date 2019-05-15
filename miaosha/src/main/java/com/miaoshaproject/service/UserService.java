package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.UserModel;

public interface UserService {

    public UserModel getUserById(Integer id);

    public void register(UserModel userModel) throws BusinessException;
}
