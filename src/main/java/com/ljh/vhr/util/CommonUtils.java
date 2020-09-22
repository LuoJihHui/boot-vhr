package com.ljh.vhr.util;

import cn.hutool.core.bean.copier.CopyOptions;

/**
 * @author LuoJiaHui
 * @date 2020/9/22 16:23
 * @description
 */
public class CommonUtils {

    private CommonUtils(){}

    public static CopyOptions getCopyOptions() {
        CopyOptions copyOptions = new CopyOptions();
        copyOptions.ignoreError();
        copyOptions.ignoreCase();
        return copyOptions;
    }
}
