package com.dsoftware.bankholidays;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class USBankCalendarFactory {

    private USBankCalendarFactory() {
    }

    public static BankCalendar createBankCalendar() {
        List<Holiday> holidays = List.of(
                new USNewYearsDay(),
                new USMartinLutherKingDay(),
                new USPresidentsDay(),
                new USMemorialDay(),
                new USJuneteenth(),
                new USIndependenceDay(),
                new USLaborDay(),
                new USColumbusDay(),
                new USVeteransDay(),
                new USThanksgiving(),
                new USChristmas());

        return new BankCalendar(holidays);
    }

    public static class USNewYearsDay implements Holiday {

        private static final int NEW_YEARS_DAY = 1;

        @Override
        public boolean isHoliday(LocalDate day) {
            if (isNewYearsDay(day)) return true;
            return isAMonday(day) && isDayAfterNewYearsDay(day);
        }

        private boolean isNewYearsDay(LocalDate day) {
            return isInJanuary(day) && day.getDayOfMonth() == NEW_YEARS_DAY;
        }

        private boolean isDayAfterNewYearsDay(LocalDate day) {
            return isInJanuary(day) && day.getDayOfMonth() == NEW_YEARS_DAY + 1;
        }

        private boolean isAMonday(LocalDate day) {
            return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
        }

        private boolean isInJanuary(LocalDate day) {
            return day.getMonth().equals(Month.JANUARY);
        }
    }

    public static class USPresidentsDay implements Holiday {

        @Override
        public boolean isHoliday(LocalDate day) {
            return isInFebruary(day)
                    && isAMonday(day)
                    && isThirdWeek(day);
        }

        private boolean isThirdWeek(LocalDate day) {
            return day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 3;
        }

        private boolean isInFebruary(LocalDate day) {
            return day.getMonth().equals(Month.FEBRUARY);
        }

        private boolean isAMonday(LocalDate day) {
            return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
        }
    }

    public static class USThanksgiving implements Holiday {

        @Override
        public boolean isHoliday(LocalDate day) {
            return isInNovember(day)
                    && isAThursday(day)
                    && isFourthWeek(day);
        }

        private boolean isInNovember(LocalDate day) {
            return day.getMonth().equals(Month.NOVEMBER);
        }

        private boolean isAThursday(LocalDate day) {
            return day.getDayOfWeek().equals(DayOfWeek.THURSDAY);
        }

        private boolean isFourthWeek(LocalDate day) {
            return day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 4;
        }
    }

    public static class USVeteransDay implements Holiday {

        private static final int VETERANS_DAY = 11;

        @Override
        public boolean isHoliday(LocalDate day) {
            if (isVeteransDay(day)) return true;
            return isAMonday(day) && isDayAfterVeteransDay(day);
        }

        private boolean isVeteransDay(LocalDate day) {
            return isInNovember(day) && day.getDayOfMonth() == VETERANS_DAY;
        }

        private boolean isDayAfterVeteransDay(LocalDate day) {
            return isInNovember(day) && day.getDayOfMonth() == VETERANS_DAY + 1;
        }

        private boolean isAMonday(LocalDate day) {
            return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
        }

        private boolean isInNovember(LocalDate day) {
            return day.getMonth().equals(Month.NOVEMBER);
        }
    }

    public static class USMemorialDay implements Holiday {

        private static final int JUNE_MONTH_NUMBER = 6;

        @Override
        public boolean isHoliday(LocalDate day) {
            LocalDate juneFirst = LocalDate.of(day.getYear(), JUNE_MONTH_NUMBER, 1);
            LocalDate lastMondayOfMay = juneFirst.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
            return day.equals(lastMondayOfMay);
        }
    }

    public static class USMartinLutherKingDay implements Holiday {

        @Override
        public boolean isHoliday(LocalDate day) {
            return isInJanuary(day)
                    && isAMonday(day)
                    && isThirdWeek(day);
        }

        private boolean isThirdWeek(LocalDate day) {
            return day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 3;
        }

        private boolean isInJanuary(LocalDate day) {
            return day.getMonth().equals(Month.JANUARY);
        }

        private boolean isAMonday(LocalDate day) {
            return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
        }
    }

    public static class USLaborDay implements Holiday {

        @Override
        public boolean isHoliday(LocalDate day) {
            return isInSeptember(day)
                    && isAMonday(day)
                    && isFirstWeek(day);
        }

        private boolean isInSeptember(LocalDate day) {
            return day.getMonth().equals(Month.SEPTEMBER);
        }

        private boolean isAMonday(LocalDate day) {
            return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
        }

        private boolean isFirstWeek(LocalDate day) {
            return day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 1;
        }
    }

    public static class USJuneteenth implements Holiday {
        private static final int JUNETEENTH_DAY = 19;

        @Override
        public boolean isHoliday(LocalDate day) {
            if (isJuneteenthDay(day)) return true;
            return isAMonday(day) && isDayAfterJuneteenthDay(day);
        }

        private boolean isJuneteenthDay(LocalDate day) {
            return isInJune(day) && day.getDayOfMonth() == JUNETEENTH_DAY;
        }

        private boolean isDayAfterJuneteenthDay(LocalDate day) {
            return isInJune(day) && day.getDayOfMonth() == JUNETEENTH_DAY + 1;
        }

        private boolean isAMonday(LocalDate day) {
            return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
        }

        private boolean isInJune(LocalDate day) {
            return day.getMonth().equals(Month.JUNE);
        }
    }

    public static class USIndependenceDay implements Holiday {

        private static final int INDEPENDENCE_DAY = 4;

        @Override
        public boolean isHoliday(LocalDate day) {
            if (isIndependenceDay(day)) return true;
            return isAMonday(day) && isDayAfterIndependenceDay(day);
        }

        private boolean isIndependenceDay(LocalDate day) {
            return isInJuly(day) && day.getDayOfMonth() == INDEPENDENCE_DAY;
        }

        private boolean isDayAfterIndependenceDay(LocalDate day) {
            return isInJuly(day) && day.getDayOfMonth() == INDEPENDENCE_DAY + 1;
        }

        private boolean isAMonday(LocalDate day) {
            return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
        }

        private boolean isInJuly(LocalDate day) {
            return day.getMonth().equals(Month.JULY);
        }
    }

    public static class USColumbusDay implements Holiday {

        @Override
        public boolean isHoliday(LocalDate day) {
            return isInOctober(day)
                    && isAMonday(day)
                    && isSecondWeek(day);
        }

        private boolean isInOctober(LocalDate day) {
            return day.getMonth().equals(Month.OCTOBER);
        }

        private boolean isAMonday(LocalDate day) {
            return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
        }

        private boolean isSecondWeek(LocalDate day) {
            return day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 2;
        }
    }

    public static class USChristmas implements Holiday {

        private static final int CHRISTMAS_DAY = 25;

        @Override
        public boolean isHoliday(LocalDate day) {
            if (isChristmasDay(day)) return true;
            return isAMonday(day) && isDayAfterChristmasDay(day);
        }

        private boolean isChristmasDay(LocalDate day) {
            return isInDecember(day) && day.getDayOfMonth() == CHRISTMAS_DAY;
        }

        private boolean isDayAfterChristmasDay(LocalDate day) {
            return isInDecember(day) && day.getDayOfMonth() == CHRISTMAS_DAY + 1;
        }

        private boolean isAMonday(LocalDate day) {
            return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
        }

        private boolean isInDecember(LocalDate day) {
            return day.getMonth().equals(Month.DECEMBER);
        }
    }

}
