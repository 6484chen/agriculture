package com.tyut.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyut.mapper.CropMapper;
import com.tyut.model.Crop;
import com.tyut.result.Result;
import com.tyut.service.CropService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/3/17 14:27
 **/

@Service
public class CropServiceImpl extends ServiceImpl<CropMapper, Crop> implements CropService {


    @Override
    public void saveCrop(Crop crop) {
        Date date = new Date();
        crop.setCreateTime(date);
        crop.setUpdateTime(date);
        this.save(crop);

    }

    @Override
    public Crop listCropById(Integer id) {
        return this.getById(id);
    }

    @Override
    public void updateCrop(Crop crop) {
        Crop newCrop = listCropById(crop.getId());
        Date date = new Date();

        //修改时间不可以大于一天
        if((date.getTime()-crop.getCreateTime().getTime())<(24*60*60*1000)){
            newCrop = crop;
            newCrop.setUpdateTime(date);
            this.updateById(crop);
        }

    }

    @Override
    public List<Crop> listCropByType(Integer type) {
        List<Crop> crops = this.query().eq(Crop.TYPE, type).list();
        return crops;
    }

}
