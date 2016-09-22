package toolbox;

/**
 * Created by perrythomson on 7/28/16.
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

import static java.time.temporal.ChronoUnit.YEARS;


public class DateTime {

    public static void main(String[] args) {


        getCurrentDate();
        getCurrentDateTime();
        getCurrentDayMonthYear();
        getSpecificDate(2008, 8, 02);
        isSameDates(2008, 8, 02);
        isAnniversary(2008, 8, 02);
        getCurrentTime();
        addHours(24);
        addWeeks(4);
        subtractYears(2);
        getCurrentUTCClock();
        getCurrentLocalClock();
        isDateBefore(getCurrentDate(), getSpecificDate(2008,8,2));
        isDateAfter(getCurrentDate(), getSpecificDate(2008,8,2));
        isDateBetween(getSpecificDate(2008,8,2), getCurrentDate(), getSpecificDate(2009,8,2));
        daysBetweenDates(getSpecificDate(2008,8,2), getCurrentDate());
        printAllTimeZones();
        getCurrentZonedDateTime("MDT");
        howManyDaysInAMonth(2008, 8);
        isLeapYear(2016);
        defaultFormatting("20080802");
        customFormatting("Aug022008");
        dateToPrettyString(getCurrentDateTime());




    }

    private static LocalDate getCurrentDate() {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);
        return today;
    }

    private static LocalDateTime getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("The current Local date and time : " + now);
        return now;
    }

    private static void getCurrentDayMonthYear() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
    }

    private static LocalDate getSpecificDate(int year, int month, int day) {
        /**
         * This method is used to add three integers. T
         * @param int year This is the first parameter
         * @param int month This is the second parameter
         * @param int day This is the third parameter
         * @return int This returns concatenation of specificDate.
         */
        LocalDate specificDate = LocalDate.of(year, month, day);
        System.out.println("Your Date of birth is : " + specificDate);
        return specificDate;
    }

    private static boolean isSameDates(int year, int month, int day) {
        LocalDate testDate = getSpecificDate(year, month, day);
        LocalDate today = getCurrentDate();
        boolean isSameDate = false;
        if(testDate.equals(today)){
            System.out.printf("Today %s and date1 %s are the same date %n", today, testDate);
            isSameDate = true;
        } else {
            System.out.printf("Today %s and date1 %s are NOT the same date %n", today, testDate);
        }
        return isSameDate;
    }

    private static boolean isAnniversary(int year, int month, int day) {
        LocalDate originalDate = getSpecificDate(year, month, day);
        LocalDate today = getCurrentDate();
        boolean isAnnualRecurrance = false;
        MonthDay anniversary = MonthDay.of(originalDate.getMonth(), originalDate.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if(currentMonthDay.equals(anniversary)){
            System.out.println("Today is the anniversary!!");
            isAnnualRecurrance = true;
        } else {
            System.out.println("Today is NOT the anniversary.");
        }
        return isAnnualRecurrance;
    }


    private static LocalTime getCurrentTime() {
        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);
        return time;
    }

    private static LocalTime addHours(int hours) {
        LocalTime time = getCurrentTime();
        LocalTime newTime = time.plusHours(hours);
        System.out.println("Time after "+hours+" hours : " + newTime);
        return newTime;
    }

    private static LocalDate addWeeks(int weeks) {
        LocalDate today = getCurrentDate();
        LocalDate newDate = today.plus(weeks, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after "+weeks+" week(s) : " + newDate);
        return newDate;
    }

    private static LocalDate subtractYears(int years) {
        LocalDate today = getCurrentDate();
        LocalDate newDate = today.minus(1, YEARS);
        System.out.println("Date, "+years+" year(s) ago : " + newDate);
        return newDate;
    }

    private static Clock getCurrentUTCClock() {
        Clock clock = Clock.systemUTC();
        System.out.println("UTC Clock : " + clock);
        return clock;
    }

    private static Clock getCurrentLocalClock() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println("Local Time Zone Clock : " + clock);
        return clock;
    }

    private static boolean isDateBefore(LocalDate testDate, LocalDate isBeforeDate) {
        boolean isBefore = false;
        if(testDate.isBefore(isBeforeDate)){
            System.out.println(testDate+" is before "+isBeforeDate);
            isBefore = true;
        } else {
            System.out.println(testDate+" is NOT before "+isBeforeDate);
        }
        return isBefore;
    }

    private static boolean isDateAfter(LocalDate testDate, LocalDate isAfterDate) {
        boolean isBefore = false;
        if(testDate.isAfter(isAfterDate)){
            System.out.println(testDate+" is after "+isAfterDate);
            isBefore = true;
        } else {
            System.out.println(testDate+" is NOT after "+isAfterDate);
        }
        return isBefore;
    }

    private static boolean isDateBetween(LocalDate testDate, LocalDate rangeStartDate, LocalDate rangeEndDate) {
        boolean isDateWithinRange = false;
        if(isDateAfter(testDate,rangeStartDate) && isDateBefore(testDate,rangeEndDate)) {
            System.out.println(testDate+" is between "+rangeStartDate+" and "+rangeEndDate);
            isDateWithinRange = true;
        } else {
            System.out.println(testDate+" is NOT between "+rangeStartDate+" and "+rangeEndDate);
        }
        return isDateWithinRange;
    }

    private static int daysBetweenDates(LocalDate start, LocalDate end) {
        Period daysBetween = Period.between(start, end);
        System.out.println("There are "+daysBetween.getDays()+" days between "+start+" and "+end);
        System.out.println("There are "+daysBetween.getMonths()+" months between "+start+" and "+end);
        System.out.println("There are "+daysBetween.getYears()+" years between "+start+" and "+end);
        return daysBetween.getDays();
    }

    private static void printAllTimeZones() {
        String[] allTimeZones = TimeZone.getAvailableIDs();
        System.out.println("TIME ZONE: ---------------------------------------------- ");
        for(String timeZone : allTimeZones) {
            System.out.println("TIME ZONE: "+timeZone);
        }
        System.out.println("TIME ZONE: ---------------------------------------------- ");
    }

    private static ZonedDateTime getCurrentZonedDateTime(String timeZone) {
        ZoneId requestedZone = ZoneId.of(timeZone);
        LocalDateTime here = getCurrentDateTime();
        ZonedDateTime there = ZonedDateTime.of(here,requestedZone);
        System.out.println("The current date and time in "+requestedZone+" is: "+there);
        return there;
    }

    private static int howManyDaysInAMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year,month);
        int daysInMonth = yearMonth.lengthOfMonth();
        System.out.printf("Days in month year %s: %d%n", yearMonth, daysInMonth);
        return daysInMonth;
    }

    private static boolean isLeapYear(int year) {
        LocalDate today = getCurrentDate();
        LocalDate checkYear = getSpecificDate(year,today.getMonthValue(),today.getDayOfMonth());
        boolean isLeapYear = false;
        if(checkYear.isLeapYear()) {
            System.out.println(year+" is a leap year");
            isLeapYear = true;
        } else {
            System.out.println(year+" is NOT a leap year");
        }
        return isLeapYear;
    }

    private static void defaultFormatting(String basicIsoDate) {
        LocalDate formattedDate = LocalDate.parse(basicIsoDate, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", basicIsoDate, formattedDate);
    }

    private static void customFormatting(String prettyDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate formattedDate = LocalDate.parse(prettyDate, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", prettyDate, formattedDate);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", prettyDate);
            ex.printStackTrace();
        }
    }

    private static String dateToPrettyString(LocalDateTime myDateTime) {
        String prettyString = null;
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            prettyString = myDateTime.format(format);
            System.out.printf("Pretty date time String : %s %n", prettyString);
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", myDateTime);
            ex.printStackTrace();
        }
        return prettyString;
    }
}