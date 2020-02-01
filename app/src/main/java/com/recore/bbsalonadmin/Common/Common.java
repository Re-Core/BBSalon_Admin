package com.recore.bbsalonadmin.Common;

import android.text.format.DateFormat;


import java.util.Calendar;
import java.util.Locale;

public class Common {
    public static final int PICK_IMAGE_REQUEST = 9999;

    public static final String ProductRef = "Product";
    public static final String CategorieRef = "Categories";
    public static final String ServiceRef = "Services";
    public static final String CommentsRef = "Comments";
    public static final String OrderRef = "Orders";
    public static final String UsersRef = "Users";
    public static final String adminView = "AdminView";
    public static final String userView = "UserView";
    public static final String cartRef = "CartList";
    public static final String AppointmentRef = "Appointments";

//    public static User currentUser;

    public static String timeAndYearStampToString(long time) {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        String date = DateFormat.format("yyyy-MM-dd \n hh:mm:ss a", calendar).toString();
        return date;
    }

    public static String timeStampToString(long time) {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        String date = DateFormat.format("yyyy-MM-dd \n hh:mm:ss a", calendar).toString();
        return date;
    }

}

