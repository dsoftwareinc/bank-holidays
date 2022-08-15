package com.dsoftware.bankholidays;

import java.time.LocalDate;

public interface Holiday {

    boolean isHoliday(LocalDate day);
}
