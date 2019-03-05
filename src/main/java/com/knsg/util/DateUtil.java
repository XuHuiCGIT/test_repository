package com.knsg.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 作者 hq.zheng:
 * @version 创建时间：2018-11-8 上午8:22:59
 * 时间工具类
 */
public class DateUtil {
    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author hq.zheng
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 获取当前月的第一天
     *
     * @return
     * @author hq.zheng
     */
    public static Date getThisMonthFirstDay(){
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
    }
    /**
     * 获取当前月的最后一天
     *
     * @return
     * @author hq.zheng
     */
    public static Date getThisMonthLastday(){
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return cale.getTime();
    }
    /**
     * 获取上月的第一天
     *
     * @return
     * @author hq.zheng
     */
    public static Date getPrecedMonthFirstDay(){
        Calendar cale = Calendar.getInstance();
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, -1);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
    }
    /**
     * 获取上月的最后一天
     *
     * @return
     * @author hq.zheng
     */
    public static Date getPrecedMonthLastday(){
        Calendar cale = Calendar.getInstance();
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return cale.getTime();
    }
    /**
     * 将字符串时间转成日期时间
     *
     * @param nowDate 当前时间
     * @param format 转的格式，如[yyyy-MM-dd],[yyyy年MM月dd日 HH时mm分ss秒]
     * @return
     * @author hq.zheng
     */
    public static Date formatStringToDate(String nowDate,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date=null;
        try {
            date=sdf.parse(nowDate);
        } catch (Exception e) {
            e.printStackTrace();
            return date;
        }
        return date;
    }
}