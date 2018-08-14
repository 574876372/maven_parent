package com.sun.parent.common.utils;

import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.exception.biz.BizException;

import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class VeDate {



    public static Date StringToDate(String stirngDate) throws BizException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
             date = sdf.parse(stirngDate);
        } catch (ParseException e) {
            throw new BizException(CommonErrorCode.COMMON_001,e);
        }
        return date;
    }

    public static String StrToDate(String str) throws ParseException
    {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateFormat2=new SimpleDateFormat("yyyy-MM-dd");
        String result=dateFormat2.format(dateFormat.parse(str));
        return result;
    }
    /**
     * 将2018-01-23的字符串转换成20180123的格式 针对一个日期的操作
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static String DateToStr(String dateStr) throws ParseException
    {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2=new SimpleDateFormat("yyyyMMdd");
        Date parse = dateFormat.parse(dateStr);
        String format = dateFormat2.format(parse);
        return format;

    }

    /**
     * 两个时间之间的天数
     * 初始化的格式 2018-01-02
     long days = getDays("2018-01-22", "2018-01-02");
     * @param date1  2018-01-22
     * @param date2 2018-01-02
     * @return
     */
    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        java.util.Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }


    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param sdate
     * @return
     */
    public static String getWeek(String sdate) {
        // 再转换为时间
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    /*
     *某一天的日期转换
     */
    public static String getWeekStr(String sdate) {
        String str = "";
        str = getWeek(sdate);
        if ("1".equals(str)) {
            str = "星期日";
        } else if ("2".equals(str)) {
            str = "星期一";
        } else if ("3".equals(str)) {
            str = "星期二";
        } else if ("4".equals(str)) {
            str = "星期三";
        } else if ("5".equals(str)) {
            str = "星期四";
        } else if ("6".equals(str)) {
            str = "星期五";
        } else if ("7".equals(str)) {
            str = "星期六";
        }
        return str;
    }

    /**
     * List数据中 一次遍历多个日期
     * @param sdate
     * @return
     */
    public static List getWeekStrArray(List sdate) {
        System.out.println(sdate.size());
        List list=new ArrayList<>();
        String str = "";
        for(int i=0;i<sdate.size();i++)
        {
            String object = (String)sdate.get(i);
            str=getWeek(object);
            list.add(str);
        }
        if ("1".equals(str)) {
            str = "星期日";
        } else if ("2".equals(str)) {
            str = "星期一";
        } else if ("3".equals(str)) {
            str = "星期二";
        } else if ("4".equals(str)) {
            str = "星期三";
        } else if ("5".equals(str)) {
            str = "星期四";
        } else if ("6".equals(str)) {
            str = "星期五";
        } else if ("7".equals(str)) {
            str = "星期六";
        }
        return list;
    }


}