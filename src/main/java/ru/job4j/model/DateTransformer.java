package ru.job4j.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DateTransformer {

    private final Map<Integer, String> months = new HashMap<>();

    public DateTransformer() {
        months.put(1, "Января");
        months.put(2, "Февраля");
        months.put(3, "Марта");
        months.put(4, "Апреля");
        months.put(5, "Мая");
        months.put(6, "Июня");
        months.put(7, "Июля");
        months.put(8, "Августа");
        months.put(9, "Сентября");
        months.put(10, "Октября");
        months.put(11, "Ноября");
        months.put(12, "Декабря");
    }

    public String transformDate(LocalDateTime toTransform) {
        return toTransform.getDayOfMonth() + " "
               + months.get(toTransform.getMonthValue()) + " "
               + toTransform.getYear() + "г. в "
               + toTransform.getHour() + " ч. "
               + toTransform.getMinute() + " мин.";
    }
}
