package com.boiechko.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertDate {

    public static Date convertDate(String dateString) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date dateUtil = null;
        try {

            dateUtil = format.parse(dateString);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert dateUtil != null;
        return new Date(dateUtil.getTime());
    }

}
