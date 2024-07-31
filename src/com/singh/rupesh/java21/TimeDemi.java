package com.singh.rupesh.java21;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TimeDemi {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println(ZonedDateTime.now());
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.parse("2024-06-20T14:06:07");
        Long duration =Duration.between(startTime, endTime).toMinutes();
        System.out.println(duration);
    }
}
