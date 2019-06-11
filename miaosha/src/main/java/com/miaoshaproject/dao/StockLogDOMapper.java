package com.miaoshaproject.dao;

import com.miaoshaproject.dataObject.StockLogDO;
import java.util.List;

public interface StockLogDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_log
     *
     * @mbggenerated Tue Jun 11 10:43:49 CST 2019
     */
    int deleteByPrimaryKey(String stockLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_log
     *
     * @mbggenerated Tue Jun 11 10:43:49 CST 2019
     */
    int insert(StockLogDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_log
     *
     * @mbggenerated Tue Jun 11 10:43:49 CST 2019
     */
    StockLogDO selectByPrimaryKey(String stockLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_log
     *
     * @mbggenerated Tue Jun 11 10:43:49 CST 2019
     */
    List<StockLogDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_log
     *
     * @mbggenerated Tue Jun 11 10:43:49 CST 2019
     */
    int updateByPrimaryKey(StockLogDO record);
}