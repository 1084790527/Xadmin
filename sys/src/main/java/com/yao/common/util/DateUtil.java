package com.yao.common.util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : 妖妖
 * @date : 11:51 2020/3/22
 */
public class DateUtil {
    // 各种时间格式
    public static final SimpleDateFormat date_sdf = new SimpleDateFormat(
            "yyyy-MM-dd");
    // 各种时间格式
    public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
            "yyyyMMdd");
    public static final SimpleDateFormat yyyyMM = new SimpleDateFormat(
            "yyyyMM");
    public static final SimpleDateFormat HH = new SimpleDateFormat(
            "HH");
    public static final SimpleDateFormat mm = new SimpleDateFormat(
            "mm");
    // 各种时间格式
    public static final SimpleDateFormat date_sdf_wz = new SimpleDateFormat(
            "yyyy年MM月dd日");
    public static final SimpleDateFormat time_sdf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat yyyy_MM = new SimpleDateFormat(
            "yyyy-MM");
    public static final SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat(
            "yyyyMMddHHmmss");
    public static final SimpleDateFormat short_time_sdf = new SimpleDateFormat(
            "HH:mm");
    public static final  SimpleDateFormat datetimeFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    // 以毫秒表示的时间
    private static final long DAY_IN_MILLIS = 24 * 3600 * 1000;
    private static final long HOUR_IN_MILLIS = 3600 * 1000;
    private static final long MINUTE_IN_MILLIS = 60 * 1000;
    private static final long SECOND_IN_MILLIS = 1000;

    //date 转换 String yyyy-MM-dd HH:mm:ss
    public static String getyyyy_MM_ddHHmmss(Date date){
        if (date==null){
            return "";
        }
        return datetimeFormat.format(date);
    }
    public static String getyyyy_MM_ddHHmmss(){
        return datetimeFormat.format(new Date());
    }
    public static String getyyyyMM(Date date){
        if (date==null){
            return "";
        }
        return yyyyMM.format(date);
    }
    public static String getyyyyMM(int i){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, i);
        Date date = cal.getTime();
        return yyyyMM.format(date);
    }
    public static String getyyyyMMonOne(Date date){
        if (date==null){
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return yyyyMM.format(calendar.getTime());
    }
    //获取当前时间HH
    public static String getHH(){
        Date newDate=new Date();
        return HH.format(newDate);
    }
    public static String getyyyyMMdd(){
        return yyyyMMdd.format(new Date());
    }
    public static String getyyyyMMdd(int day){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        return yyyyMMdd.format(calendar.getTime());
    }
    public static String getyyyyMMdd(Date date){
        return yyyyMMdd.format(date);
    }
    //获取这个月yyyyMM
    public static String getyyyyMM(){
        Date newDate=new Date();
        return yyyyMM.format(newDate);
    }
    public static String getyyyy_MM(){
        Date newDate=new Date();
        return yyyy_MM.format(newDate);
    }
    //获取当天日期
    public static String getyyyyMMddHHmmss(){
        Date date=new Date();
        return yyyymmddhhmmss.format(date);
    }
    //今天开始时间
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }
    //今天结束时间
    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }
    public static String beforeDate(int day){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        return date_sdf.format(calendar.getTime());
    }
    //当月1号
    public static Date getDateByMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    //获取这个月的最后一天
    public static String getLastMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return date_sdf.format(calendar.getTime());
    }

    /**
     * 字符串转换成日期
     * @param str
     * @param sdf
     * @return
     */
    public static Date str2Date(String str, SimpleDateFormat sdf) {
        if (null == str || "".equals(str)) {
            return null;
        }
        Date date = null;
        try {
            date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取当天 星期几
    public static String getWeek(){
        String[] week = {"7","1","2","3","4","5","6"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return week[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }

    public static String getmm() {
        Date newDate=new Date();
        return mm.format(newDate);
    }

    @Test
    public void tt() throws ParseException {
//        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sf.format(getStartTime()));
//        System.out.println(sf.format(getEndTime()));
//        System.out.println(sf.format(getDateByMonth()));
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = f.parse("2020-05-17");
//        calendar.setTime(date);
////        {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"}
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//        System.out.println(getLastMonth());

//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        cal.add(Calendar.MONTH, -2);
//        Date date = cal.getTime();
//        System.out.println(getyyyyMM(date));
        System.out.println(beforeDate(-30));
    }

    public static String getyyyy_MM_dd(Date time) {
        if (time == null){
            return null;
        }
        return date_sdf.format(time);
    }
}








