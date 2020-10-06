package com.shawn.mall.portal.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Date tools
 */
public class DateUtil {

    /**
     * Get datetime from Date datatype
     */
    public static Date getDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * Get date from Date datatype
     */
    public static Date getTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR,1970);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return calendar.getTime();
    }
}