package com.mys.apexcharts.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class TimeUtils {

    public static Date getDateByStr(String str, String simpleDateFormat) {
        if (str != null && simpleDateFormat != null && !simpleDateFormat.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);

            try {
                return sdf.parse(str);
            } catch (Exception var4) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String getFormatDate(Date date,String simpleDateFormat){
        if (date != null && simpleDateFormat != null && !simpleDateFormat.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
            return sdf.format(date);
        } else {
            return null;
        }
    }

    public static String getTimeZoneDateString(Date date, float timeZoneOffset, String simpleDateFormat) {
        if (date != null && simpleDateFormat != null && !simpleDateFormat.isEmpty()) {
            if (timeZoneOffset > 13.0F || timeZoneOffset < -12.0F) {
                timeZoneOffset = 0.0F;
            }
            int newTime = (int)(timeZoneOffset * 60.0F * 60.0F * 1000.0F);
            String[] ids = TimeZone.getAvailableIDs(newTime);
            Object timeZone;
            if (ids.length == 0) {
                timeZone = TimeZone.getDefault();
            } else {
                timeZone = new SimpleTimeZone(newTime, ids[0]);
            }
            SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
            sdf.setTimeZone((TimeZone)timeZone);
            return sdf.format(date);
        } else {
            return null;
        }
    }
}
