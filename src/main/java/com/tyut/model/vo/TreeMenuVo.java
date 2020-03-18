package com.tyut.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/20 10:31
 **/

@lombok.Data
public class TreeMenuVo implements Serializable {
    private static final long serialVersionUID = -7844676091286955195L;

    /**主键.*/
    private Integer id;

    /**静态资源名称.*/
    private String name;

    /**菜单icon*/
    private String icon;

    /**菜单路由*/
    private String router;

    /**后台接口主路由.*/
    private String routerApi;

    /**资源级别.*/
    private Integer level;

    /**静态资源父id.*/
    private Integer parentId;

    /**子集菜单*/
    private List<TreeMenuVo> children;

}
