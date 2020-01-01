package fish.study.geekband1.Utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class DateUtils {
    public static void getDayOfWeek(){
        LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime dateTime = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime dateTime1 = date.withDayOfMonth(1);
        LocalDateTime dateTime2 = date.with(DayOfWeek.MONDAY);


        System.out.println(dateTime);
        System.out.println(dateTime1);
        System.out.println(dateTime2);
    }

    public static void main(String[] args) {
        getDayOfWeek();
    }
}
