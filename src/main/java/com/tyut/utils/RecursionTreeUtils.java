package com.tyut.utils;


import com.tyut.model.Resource;
import com.tyut.model.vo.TreeMenuVo;


import java.util.ArrayList;
import java.util.List;
/**
 * @PACKAGE_NAME: agriculture
 * @description: 递归树状接口的的工具类
 * @author: wangchen
 * @create: 2020/2/20 15:40
 **/

public final class RecursionTreeUtils {

    private RecursionTreeUtils() {
    }

    /**
     * 递归分拆菜单的后台接口路由
     * @param treeMenuVo
     * @param dataList
     */
    public static void splitTreeMenu(List<TreeMenuVo> treeMenuVo, List<String> dataList) {
        for (TreeMenuVo vo : treeMenuVo) {
            String routerApi = vo.getRouterApi();
            if (StringUtils.isNotEmpty(routerApi)) {
                dataList.add(routerApi);
            }
            List<TreeMenuVo> children = vo.getChildren();
            if (StringUtils.isNotEmpty(children)) {
                splitTreeMenu(children, dataList);// 递归
            }
        }
    }

   /**
     * 构建权限菜单的树状结构
     * @param list
     * @param id
     * @param level
     * @return
     */
    public static TreeMenuVo buildAuthTreeMenu(List<Resource> list, Integer id) {
        Resource resource = list.stream().filter(menu -> menu.getId().equals(id)).findFirst().get();
        TreeMenuVo vo = new TreeMenuVo();
        vo.setId(resource.getId());
        vo.setName(resource.getName());
        vo.setIcon(resource.getIcon());
        vo.setRouter(resource.getRouter());
        vo.setRouterApi(resource.getRouterApi());
        vo.setLevel(resource.getLevel());
        vo.setParentId(resource.getParentId());
        for (Resource data : list) {
            if (data.getParentId().equals(resource.getId())) {
                TreeMenuVo tet = buildAuthTreeMenu(list, data.getId());// 递归
                List<TreeMenuVo> childrenList = vo.getChildren();
                if (StringUtils.isEmpty(childrenList)) {
                    childrenList = new ArrayList<>();
                    vo.setChildren(childrenList);
                }
                childrenList.add(tet);
            }
        }
        return vo;
    }
}
