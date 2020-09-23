package com.ljh.vhr.util;

import cn.hutool.core.bean.copier.CopyOptions;

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
}
