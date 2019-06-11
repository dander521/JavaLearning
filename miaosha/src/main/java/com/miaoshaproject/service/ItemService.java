package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.ItemModel;

import java.util.List;

public interface ItemService {

    public ItemModel createItem(ItemModel itemModel) throws BusinessException;

    List<ItemModel> listItem();

    ItemModel getItemById(Integer id);

    // item 及 promo model缓存模型
    ItemModel getItemByIdInCache(Integer id);

    // 库存扣减
    boolean decreaseStock(Integer itemId, Integer amount) throws BusinessException;

    // 库存回补
    boolean increaseStock(Integer itemId, Integer amount) throws BusinessException;

    // 异步更新库存
    boolean asyncDecreaseStock(Integer itemId, Integer amount);

    // 商品销量增加
    void increaseSales(Integer itemId, Integer amount) throws BusinessException;

    // 初始化库存流水
    String initStockLog(Integer itemId, Integer amount);
}
