package com.dsoftware.bankholidays;

import java.time.LocalDate;
import java.util.List;

public class BankCalendar {

    private final List<Holiday> holidays;

    public BankCalendar(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public boolean isHoliday(LocalDate day) {
        return holidays.stream().anyMatch(holiday -> holiday.isHoliday(day));
    }
}
