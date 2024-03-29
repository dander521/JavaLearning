package com.miaoshaproject.dao;

import com.miaoshaproject.dataObject.PromoDO;
import java.util.List;

public interface PromoDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbggenerated Fri May 17 14:02:13 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbggenerated Fri May 17 14:02:13 CST 2019
     */
    int insert(PromoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbggenerated Fri May 17 14:02:13 CST 2019
     */
    PromoDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbggenerated Fri May 17 14:02:13 CST 2019
     */
    List<PromoDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbggenerated Fri May 17 14:02:13 CST 2019
     */
    int updateByPrimaryKey(PromoDO record);

    PromoDO selectByItemId(Integer itemId);
}