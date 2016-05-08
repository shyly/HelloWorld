package cn.itcast.mobileplaybj83.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by flykozhang on 2016/5/6.
 */
public class StringUtil {
    private static final int HOUR = 60 * 60 * 1000;
    private static final int MIN = 60 * 1000;
    private static final int SEC = 1000;

    /*格式化duration*/
    public static String fromatDuration(int duration) {
        int hour = duration / HOUR;
        int min = duration % HOUR / MIN;
        int sec = duration % MIN / SEC;

        if(hour>0){
            /*01:01*/
            return String.format("%02d:%02d:%02d",hour,min,sec);
        }else{
            /*01:01*/
            return String.format("%02d:%02d",min,sec);
        }
    }

    /*格式化系统时间*/
    public static String fromatSystemTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
