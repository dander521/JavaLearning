package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.ItemModel;

import java.util.List;

public interface ItemService {

    public ItemModel createItem(ItemModel itemModel) throws BusinessException;

    List<ItemModel> listItem();

    ItemModel getItemById(Integer id);

    // 库存扣减
    boolean decreaseStock(Integer itemId, Integer amount) throws BusinessException;

    // 商品销量增加
    void increaseSales(Integer itemId, Integer amount) throws BusinessException;
}
