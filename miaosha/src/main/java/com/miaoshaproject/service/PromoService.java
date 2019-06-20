package com.miaoshaproject.service;

import com.miaoshaproject.service.model.PromoModel;

public interface PromoService {

    public PromoModel getPromoByItemId(Integer itemId);

    // 发布活动
    public void publishPromo(Integer promoId);

    // 生成秒杀令牌
    String generateSecondKillToken(Integer promoId, Integer itemId, String userId);
}
