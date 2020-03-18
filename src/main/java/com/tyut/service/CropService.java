package com.tyut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyut.model.Crop;

import java.util.List;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/3/17 14:26
 **/
public interface CropService extends IService<Crop> {
    void saveCrop(Crop crop);
    Crop listCropById(Integer id);
    void updateCrop(Crop crop);
    List<Crop> listCropByType(Integer type);
}
