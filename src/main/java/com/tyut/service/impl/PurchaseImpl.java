package com.tyut.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyut.mapper.PurchaseMapper;

import com.tyut.model.Purchase;
import com.tyut.model.vo.PurchaseVo;
import com.tyut.service.PurchaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/3/17 17:26
 **/

@Service
public class PurchaseImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {
    @Override
    public List<Purchase> listPurchase(Integer type) {
        List<Purchase> purchases = this.query().eq(Purchase.CROP_TYPE, type).list();
        return purchases;
    }

    @Override
    public void addPurchase(PurchaseVo purchaseVo) {
        Purchase purchase = new Purchase();

    }
}
