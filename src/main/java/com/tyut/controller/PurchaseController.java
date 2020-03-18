package com.tyut.controller;

import com.tyut.model.Crop;
import com.tyut.model.Purchase;
import com.tyut.model.vo.PurchaseVo;
import com.tyut.result.Result;
import com.tyut.service.CropService;
import com.tyut.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/3/17 16:30
 **/

@Api(tags = {"代理商层"})
@RequestMapping("/agent")
@RestController
public class PurchaseController {

    @Autowired
    CropService cropService;

    @Autowired
    PurchaseService purchaseService;
    @ApiOperation("代理商列表")
    @GetMapping("/list")
    public Result ListCrop(Integer type){
        List<Crop> corps = cropService.listCropByType(type);
        return Result.getInstance(corps);
    }

    @ApiOperation("添加代理产品")
    @PostMapping("/add")
    public Result addPurchase(@RequestBody PurchaseVo purchaseVo){
        purchaseService.addPurchase(purchaseVo);
        return Result.getInstance();
    }
}
