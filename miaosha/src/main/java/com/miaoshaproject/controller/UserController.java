package com.miaoshaproject.controller;

import com.alibaba.druid.util.StringUtils;
import com.miaoshaproject.controller.viewObject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;


@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType register(String name, String otpCode, Integer age, Byte gender, String telephone, String password) throws BusinessException {

        String inSessionOptCode = (String) this.httpServletRequest.getSession().getAttribute(telephone);
        if (!StringUtils.equals(otpCode, inSessionOptCode)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不符");
        }

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAge(age);
        userModel.setGender(gender);
        userModel.setTelephone(Integer.valueOf(telephone));
        userModel.setRegisterMode("byphone");
        userModel.setEncrptPassword(MD5Encoder.encode(password.getBytes()));
        userService.register(userModel);

        return CommonReturnType.creat(null);
    }


    @RequestMapping(value = "/getOtp", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(String telephone) throws BusinessException {
        if (telephone == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 生成otp
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);

        // otp与telephone关联 redis 或 使用httpsession方式绑定
        httpServletRequest.getSession().setAttribute(telephone, otpCode);

        // 第三方平台发送
        System.out.println("telephone = " + telephone + " & otpCode = " + otpCode);

        return CommonReturnType.creat(null);
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(Integer id) throws BusinessException {
        if (id == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        UserModel userModel = userService.getUserById(id);
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.creat(userVO);
    }

    private UserVO convertFromModel(UserModel userModel) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }
}
