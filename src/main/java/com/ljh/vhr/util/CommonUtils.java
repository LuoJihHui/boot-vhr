package com.ljh.vhr.util;

import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 统一工具类
 *
 * @author LuoJiaHui
 * @date 2020/9/22 16:23
 * @description
 */
public class CommonUtils {

    private CommonUtils() {
    }

    /**
     * HuToolBean转换专用
     *
     * @param
     * @return cn.hutool.core.bean.copier.CopyOptions
     * @auth LuoJiaHui
     * @Date 2020/9/23 14:07
     **/
    public static CopyOptions getCopyOptions() {
        CopyOptions copyOptions = new CopyOptions();
        copyOptions.ignoreError();
        copyOptions.ignoreCase();
        return copyOptions;
    }

    /**
     * 构建树状菜单
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/25 13:47
     **/
    public static List<Map<String, Object>> outTreeMenu(List<Map<String, Object>> data) {
        List<Map<String, Object>> treeList = new ArrayList<>();
        for (Map<String, Object> map : data) {
            if (map.get("parentId") == null) {
                map.put("children", addChildModule(map, data));
                treeList.add(map);
            }
        }
        return treeList;
    }

    private static List<Map<String, Object>> addChildModule(Map<String, Object> parentMap,
                                                            List<Map<String, Object>> list) {
        List<Map<String, Object>> childList = new ArrayList<>();
        // 为每一个父节点增加子树（List形式，没有则为空的list）
        parentMap.put("children", childList);
        for (Map<String, Object> childMap : list) {
            //如果子节点的pid等于父节点的ID，则说明是父子关系
            if (parentMap.get("id").equals(childMap.get("parentId"))) {
                // 是父子关系，则将其放入子list字面
                childList.add(childMap);
                // 继续调用递归算法，将当前作为父节点，继续找他的子节点，反复执行。
                addChildModule(childMap, list);
            }
        }
        // childrenList为空，删除children节点
        if (CollUtil.isEmpty(childList)) {
            parentMap.remove("children");
        }
        // 当遍历完成，返回调用的父节点的所有子节点
        return childList;
    }
}
