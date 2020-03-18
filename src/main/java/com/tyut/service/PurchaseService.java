package com.tyut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyut.model.Purchase;
import com.tyut.model.vo.PurchaseVo;

import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/3/17 17:25
 **/
public interface PurchaseService extends IService<Purchase> {

    List<Purchase> listPurchase(Integer id);
    void addPurchase(PurchaseVo purchaseVo);
}
