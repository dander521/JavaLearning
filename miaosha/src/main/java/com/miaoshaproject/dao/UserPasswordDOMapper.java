package com.miaoshaproject.dao;

import com.miaoshaproject.dataObject.UserPasswordDO;
import java.util.List;

public interface UserPasswordDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Wed May 15 18:22:28 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Wed May 15 18:22:28 CST 2019
     */
    int insert(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Wed May 15 18:22:28 CST 2019
     */
    UserPasswordDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Wed May 15 18:22:28 CST 2019
     */
    List<UserPasswordDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Wed May 15 18:22:28 CST 2019
     */
    int updateByPrimaryKey(UserPasswordDO record);

    UserPasswordDO selectByUserId(String userId);
}