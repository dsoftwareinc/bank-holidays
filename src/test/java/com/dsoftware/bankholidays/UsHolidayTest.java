package com.dsoftware.bankholidays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsHolidayTest {
    BankCalendar bankCalendar = USBankCalendarFactory.createBankCalendar();
    @ParameterizedTest
    @CsvSource({
            "2022-12-25", //christmas
            "2022-12-26", //christmas 1
            "2023-12-25", //christmas
            "2022-10-10", // Columbus Day
            "2023-10-09", // Columbus Day
            "2024-10-14", // Columbus Day
            "2025-10-13", // Columbus Day
            "2022-07-04", // Independence Day
            "2022-06-19",

    })
    void should_returnTrue_when_checkingIsAHoliday(LocalDate holiday) {
        assertTrue(bankCalendar.isHoliday(holiday));
    }

    @ParameterizedTest
    @CsvSource({
            "2022-11-25",
            "2025-10-12", // Columbus Day
            "2022-07-05", // Columbus Day
    })
    void should_returnFalse_when_checkingIsNotHoliday(LocalDate holiday) {
        assertFalse(bankCalendar.isHoliday(holiday));
    }
}
