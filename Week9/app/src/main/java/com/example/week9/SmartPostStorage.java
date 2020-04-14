package com.example.week9;

import java.util.ArrayList;
import java.util.Date;

public class SmartPostStorage {
    private static SmartPostStorage smartPostStorage = new SmartPostStorage();

    private ArrayList<SmartPost> smartPostLocations = null;

    private SmartPostStorage() { }

    public static SmartPostStorage getInstance() {
        return  smartPostStorage;
    }

    public ArrayList<SmartPost> getSmartPostLocations() {return  smartPostLocations;}

    public void downloadData () {
        XMLhandler xmlHander = XMLhandler.getInstance();
        smartPostLocations = xmlHander.getXML("http://iseteenindus.smartpost.ee/api/?request=destinations&country=FI&type=APT");

    }

    public ArrayList<SmartPost> filterData(int[] visitingDate, int[] openingTime, int[] closingTime) {
        Date date = new Date(visitingDate[2] - 1900, visitingDate[1], visitingDate[0], 03, 03, 3);
        int weekDay = date.getDay();
        System.out.println("WEEKDAY IS: " + date.getDay());
        System.out.println(date.toString());
        //dayOfMonth, (monthOfYear), year}
/*
        SmartPost testi = smartPostLocations.get(0);
        Date[][] openAndCloseTime = testi.getDateArray();
        System.out.println(openAndCloseTime[0][0].toString() + "\n" + openAndCloseTime[0][1].toString() + "\n\n" +
                openAndCloseTime[1][0].toString() + "\n" + openAndCloseTime[1][1].toString() + "\n\n" +
                openAndCloseTime[6][0].toString() + "\n" + openAndCloseTime[6][1].toString() + "\n\n");
*/      // Date here doesn't matter, only time is needed. So date is always 1.2.2000 and hours change.
        Date opens = new Date(100, 01, 01, openingTime[0], openingTime[1], 0);
        Date closes = new Date(100, 01, 01, closingTime[0], closingTime[1], 0);
        ArrayList<SmartPost> filteredSmartPostList = new ArrayList<SmartPost>();
        for (SmartPost smartPost : this.smartPostLocations) {
            // First index is weekday from 0-6, second is open and close time: 0 open 1 close.
            Date[][] openAndCloseTime = smartPost.getDateArray();
            // There are cases when smart post location isn't open on specific day meaning that open and close values are null.
            if (openAndCloseTime[weekDay][0] == null || openAndCloseTime[weekDay][1] == null) {
                continue;
            } else {
                if (openAndCloseTime[weekDay][0].before(opens) && openAndCloseTime[weekDay][1].after(closes) ) {
                    System.out.println("SUORITETTIIN SUCCESS!");
                    filteredSmartPostList.add(smartPost);
                }
            }

        }
        return filteredSmartPostList;
    }
}
