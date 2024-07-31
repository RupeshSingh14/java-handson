//package com.singh.rupesh.java21;
//
//import java.sql.Time;
//import java.time.LocalTime;
//import java.util.Calendar;
//import java.util.Locale;
//import java.util.Map;
//import java.util.TimeZone;
//import java.time.LocalDateTime;
//
//public class SchedulerDemo {
//
//
//    Calendar scheduler startTime = "2024-05-28T20:50:37.000Z";
//
//}
//
//    public String  getCronExp(final Map<String, Object> configMap) {
//
//        System.out.println(">>  getCronExp");
//
//        String exp = "";
//
//        final String type = (String) configMap.get(SCHEDULER_TYPE);
//        final String time = (String) configMap.get(TIME);
//        final String[] split = time.split(this.COLON);
//        String hour = split[0];
//        String min = split[1];
//
//        if ("00".equalsIgnoreCase(min)) {
//            min = ZERO;
//        }
//        if ("00".equalsIgnoreCase(hour)) {
//            hour = "0";
//        }
//        if ("daily".equalsIgnoreCase(type)) {
//
//            exp = this.ZERO + this.WHITE_SPACE + min + this.WHITE_SPACE + hour + this.WHITE_SPACE + this.ASTERISK + this.WHITE_SPACE + this.ASTERISK
//                    + this.WHITE_SPACE + "?";
//
//        } else if ("monthly".equalsIgnoreCase(type)) {
//            final String date = (String) configMap.get(START_DATE);
//            exp = this.ZERO + this.WHITE_SPACE + min + this.WHITE_SPACE + hour + this.WHITE_SPACE + date + this.WHITE_SPACE + this.ASTERISK + this.WHITE_SPACE
//                    + "?";
//
//        } else if ("weekly".equalsIgnoreCase(type)) {
//
//            final String dayOfWeek = (String) configMap.get(DAY_OF_WEEK);
//
//            exp = this.ZERO + this.WHITE_SPACE + min + this.WHITE_SPACE + hour + this.WHITE_SPACE + "?" + this.WHITE_SPACE + this.ASTERISK + this.WHITE_SPACE
//                    + dayOfWeek;
//        }
//
//        System.out.println("Latest cron  expression scheduler " + exp);
//        System.out.println("<<  getCronExp");
//        return exp;
//
//
//
//
//
//
//}
