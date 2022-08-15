## Bank Holidays

Java library for determining whether a given day is a bankCalendar holiday

### Usage

``` java
LocalDate newYears = LocalDate.of(2022, 1, 1);
Bank bankCalendar = USBankFactory.createBankCalendar();
boolean isHoliday = bankCalendar.isHoliday(newYears);
```

### Using an Existing Bank

``` java
// This bankCalendar comes packaged with the Federal Reserve Bank holidays 
Bank bankCalendar = USBankFactory.createBankCalendar();
```

### Creating a Holiday

The Holiday interface can be used to create a new Holiday

``` java
class NewHoliday implements Holiday {
    
    @Override
    public boolean isHoliday(LocalDate day) {
        // Your logic for determining if 
        // the given day is a holiday goes here
        // ...
    }
}
```

### Creating a New Bank

``` java
List<Holiday> holidays = List.of(aHoliday, anotherHoliday);
Bank bankCalendar = new Bank(holidays);
```

### Existing Holidays

- Christmas
- Columbus Day
- Independence Day
- Juneteenth
- Labor Day
- Martin Luther King Day
- Memorial Day
- New Years Day
- Presidents Day
- Thanksgiving
- Veterans Day

### Contributing
Please feel free to submit a pull request with new holidays and banks
