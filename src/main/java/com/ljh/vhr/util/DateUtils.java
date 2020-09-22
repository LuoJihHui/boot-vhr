package com.ljh.vhr.util;

import com.ljh.vhr.constant.SystemConstant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LuoJiaHui
 * @date 2020/9/22 15:30
 * @description
 */
public class DateUtils {

    private DateUtils() {
    }

    /**
     * 时间戳格式化转String
     *
     * @param sourceDate
     * @return java.lang.String
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:19
     **/
    public static String formatTimestampToString(Date sourceDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.DATE_FORMAT);
        return simpleDateFormat.format(sourceDate);
    }
}
