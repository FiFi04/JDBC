package org.example.client.utils;

import org.example.client.repository.enums.Sex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PeselUtils {

    public static LocalDate setBirthdate(String personalIDNumber) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String year = "";
        String month = "";
        String day = "";
        String substring = personalIDNumber.substring(0, 6);
        String[] splitDate = substring.split("");
        for (int i = 0; i < splitDate.length; i++) {
            if (i < 2) {
                year += splitDate[i];
            } else if (i < 4) {
                month += splitDate[i];
            } else {
                day += splitDate[i];
            }
        }
        int monthValue = Integer.parseInt(month);
        if (monthValue > 72) {
            year = "18" + year;
            month = "0" + (monthValue - 80);
        } else if (monthValue > 52) {
            year = "22" + year;
            month = "0" + (monthValue - 60);
        } else if (monthValue > 32) {
            year = "21" + year;
            month = "0" + (monthValue - 40);
        } else if (monthValue > 12) {
            year = "20" + year;
            month = "0" + (monthValue - 20);
        } else {
            year = "19" + year;
        }
        String stringDate = day + "-" + month + "-" + year;
        return LocalDate.parse(stringDate, dateFormat);
    }

    public static Sex setPersonSex(String personalIDNumber) {
        int num = Integer.parseInt(personalIDNumber.substring(personalIDNumber.length() - 2, personalIDNumber.length() - 1));
        return num % 2 == 0 ? Sex.FEMALE : Sex.MALE;
    }
}