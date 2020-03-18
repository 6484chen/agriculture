package com.tyut.controller;

import com.tyut.model.Crop;
import com.tyut.result.Result;
import com.tyut.service.CropService;
import com.tyut.service.impl.CropServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 种植户控制层
 * @author: wangchen
 * @create: 2020/3/17 14:13
 **/

@Api(tags = {"种植户层"})
@RestController
@RequestMapping("/farmer")
public class FarmerController {
    @Autowired
    CropService cropService;

    @ApiOperation( value = "添加农作物商品")
    @PostMapping("/add")
    public Result addCrop(@RequestBody Crop crop){
        // TODO  写一个获取登录名组件
        crop.setFarmerName("farmerName");
        cropService.saveCrop(crop);
        return Result.getInstance();

    }

    @ApiOperation("单个查询")
    @GetMapping("/listType")
    @ApiImplicitParam(name = "id", value = "id", dataType = "Integer",paramType = "query" )
    public Result listById(@RequestParam("id") Integer id){

        return Result.getInstance(cropService.listCropById(id));
    }

    @ApiOperation("按类型查询")
    @GetMapping("/list")
    @ApiImplicitParam(name = "type", value = "id", dataType = "Integer",paramType = "query" )
    public Result listByType(@RequestParam("type") Integer type){

        return Result.getInstance(cropService.listCropByType(type));
    }

    @ApiOperation("修改作物")
    @PutMapping("/update")
    @ApiImplicitParam(name = "id", value = "id", dataType = "Integer",paramType = "query" )
    public Result updateCrop(@RequestBody Crop crop){

        cropService.updateCrop(crop);
        return Result.getInstance();


    }
}
