/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 */
package fr.gouv.finances.oda.automatedTests.utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil extends BasePage
{
    // Get The Current Day
    public static String getCurrentDay()
    {
        // Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        // Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        log.info("Today Int: " + todayInt + "\n");
        // Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        log.info("Today Str: " + todayStr + "\n");
        return todayStr;
    }

    // Get The Current Day plus days. You can change this method based on your needs.
    public static String getCurrentDayPlus(int days)
    {
        LocalDate currentDate = LocalDate.now();
        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
        return Integer.toString(dayOfWeekPlus);
    }
    
    /**
     * Accesseur de l attribut date in java.
     *
     * @return date in java
     */
    // Get The Date in Java
    public static String getDateInJava()
    {
     // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
        
        //get current date time with Date()
        Date date = new Date();
        
        // Now format the date
        String date1= dateFormat.format(date).trim();
        
        // Print the Date
        log.info(date1);
        return date1;
    }

    /**
     * methode Click given day 
     *
     * @param elementList 
     * @param day         
     * @return 
     */
    // Click to given day
    public static String clickGivenDay(List<WebElement> elementList, String day)
    {
        // DatePicker is a table. Thus we can navigate to each cell
        // and if a cell matches with the current date then we will click it.
        /** Functional JAVA version of this method. */
        elementList.stream()
            .filter(element -> element.getText().contains(day))
            .findFirst()
            .ifPresent(WebElement::click);
        return day;
    }
}
