package com.miaoshaproject.dao;

import com.miaoshaproject.dataObject.ItemStockDO;
import java.util.List;

public interface ItemStockDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Thu May 16 11:46:13 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Thu May 16 11:46:13 CST 2019
     */
    int insert(ItemStockDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Thu May 16 11:46:13 CST 2019
     */
    ItemStockDO selectByPrimaryKey(Integer id);
    ItemStockDO selectByItemId(Integer itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Thu May 16 11:46:13 CST 2019
     */
    List<ItemStockDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Thu May 16 11:46:13 CST 2019
     */
    int updateByPrimaryKey(ItemStockDO record);

    int decreaseStock(Integer itemId, Integer amount);
}