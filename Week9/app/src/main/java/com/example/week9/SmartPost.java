package com.example.week9;

import java.util.Date;

public class SmartPost {
    private String place_id;
    private String name;
    private String city;
    private String address;
    private String country;
    private String postalCode;
    private String routingCode;
    private String availability;
    private String description;
    private String lat;
    private String lng;
    //0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday
    //wd = week day
    private Date wd0_opens = null;
    private Date wd0_closes =  null;
    private Date wd1_opens =  null;
    private Date wd1_closes =  null;
    private Date wd2_opens =  null;
    private Date wd2_closes =  null;
    private Date wd3_opens =  null;
    private Date wd3_closes = null;
    private Date wd4_opens =  null;
    private Date wd4_closes = null;
    private Date wd5_opens =  null;
    private Date wd5_closes = null;
    private Date wd6_opens =  null;
    private Date wd6_closes =  null;

    private Date[][] dateArray;



    SmartPost(String place_id, String name, String city, String address, String country, String postalCode, String routingCode, String availability, String description, String lat, String lng) {
        this.place_id = place_id;
        if(country.equals("FI")) {
            this.name = name.split(", ", 2)[1];
        } else {
            this.name = name;
        }

        this.city = city;
        this.address = address;
        this.country = country;
        this.postalCode = postalCode;
        this.routingCode = routingCode;
        this.availability = availability;
        this.parseAvailability(availability, country);
        this.formDateArray();
        this.description = description;
        this.lat = lat;
        this.lng = lng;
    }

    private void parseAvailability (String availability, String country) {
        if (country.equals("FI")) {
            String[] availabilityStrings = availability.split(",");

            for (String availabilityString : availabilityStrings) {
                availabilityString = availabilityString.trim();
                //Index 0 is always weekday, 1 is opening, 3 is closing time, except when 24h time is encountered. sigh.
                String[] splitted = availabilityString.split(" ");
                Date open;
                Date closes;
                if (splitted[0].equals("24h")) {
                    // 24/7 service.
                    this.wd1_opens = this.wd2_opens = this.wd3_opens = this.wd4_opens = this.wd5_opens = this.wd6_opens = this.wd0_opens
                            = new Date(100, 01, 01, 00, 00, 0);
                    this.wd1_closes = this.wd2_closes = this.wd3_closes = this.wd4_closes = this.wd5_closes = this.wd6_closes = this.wd0_closes
                            = new Date(100, 01, 01, 23, 59, 59);
                    continue;
                } else if (splitted[1].equals("24h")) {
                    // 24h service on specific day(s).
                    open = new Date(100, 01, 01, 00, 00, 0);
                    closes = new Date(100, 01, 01, 23, 59, 59);
                } else {
                    // Default case. No 24h service.
                    open = formDate(splitted[1]);
                    closes = formDate(splitted[3]);
                }


                switch (splitted[0]) {
                    //0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday
                    case "ma-ti":
                        this.wd1_opens = this.wd2_opens = open;
                        this.wd1_closes = this.wd2_closes = closes;
                        break;
                    case "ma-ke":
                        this.wd1_opens = this.wd2_opens = this.wd3_opens = open;
                        this.wd1_closes = this.wd2_closes = this.wd3_closes = closes;
                        break;
                    case "ma-to":
                        this.wd1_opens = this.wd2_opens = this.wd3_opens = this.wd4_opens = open;
                        this.wd1_closes = this.wd2_closes = this.wd3_closes = this.wd4_closes = closes;
                        break;
                    case "ma-pe":
                        this.wd1_opens = this.wd2_opens = this.wd3_opens = this.wd4_opens = this.wd5_opens = open;
                        this.wd1_closes = this.wd2_closes = this.wd3_closes = this.wd4_closes = this.wd5_closes = closes;
                        break;
                    case "ma-la":
                        this.wd1_opens = this.wd2_opens = this.wd3_opens = this.wd4_opens = this.wd5_opens = this.wd6_opens = open;
                        this.wd1_closes = this.wd2_closes = this.wd3_closes = this.wd4_closes = this.wd5_closes = this.wd6_closes = closes;
                        break;
                    case "ma-su":
                        this.wd1_opens = this.wd2_opens = this.wd3_opens = this.wd4_opens = this.wd5_opens = this.wd6_opens = this.wd0_opens = open;
                        this.wd1_closes = this.wd2_closes = this.wd3_closes = this.wd4_closes = this.wd5_closes = this.wd6_closes = this.wd0_closes = closes;
                        break;
                    case "ti-ke":
                        this.wd2_opens = this.wd3_opens = open;
                        this.wd2_closes = this.wd3_closes = closes;
                        break;
                    case "ti-to":
                        this.wd2_opens = this.wd3_opens = this.wd4_opens = open;
                        this.wd2_closes = this.wd3_closes = this.wd4_closes = closes;
                        break;
                    case "ti-pe":
                        this.wd2_opens = this.wd3_opens = this.wd4_opens = this.wd5_opens = open;
                        this.wd2_closes = this.wd3_closes = this.wd4_closes = this.wd5_closes = closes;
                        break;
                    case "ti-la":
                        this.wd2_opens = this.wd3_opens = this.wd4_opens = this.wd5_opens = this.wd6_opens = open;
                        this.wd2_closes = this.wd3_closes = this.wd4_closes = this.wd5_closes = this.wd6_closes = closes;
                        break;
                    case "ti-su":
                        this.wd2_opens = this.wd3_opens = this.wd4_opens = this.wd5_opens = this.wd6_opens = this.wd0_opens = open;
                        this.wd2_closes = this.wd3_closes = this.wd4_closes = this.wd5_closes = this.wd6_closes = this.wd0_closes = closes;
                        break;
                    case "ke-to":
                        this.wd3_opens = this.wd4_opens = open;
                        this.wd3_closes = this.wd4_closes = closes;
                        break;
                    case "ke-pe":
                        this.wd3_opens = this.wd4_opens = this.wd5_opens = open;
                        this.wd3_closes = this.wd4_closes = this.wd5_closes = closes;
                        break;
                    case "ke-la":
                        this.wd3_opens = this.wd4_opens = this.wd5_opens = this.wd6_opens = open;
                        this.wd3_closes = this.wd4_closes = this.wd5_closes = this.wd6_closes = closes;
                        break;
                    case "ke-su":
                        this.wd3_opens = this.wd4_opens = this.wd5_opens = this.wd6_opens = this.wd0_opens = open;
                        this.wd3_closes = this.wd4_closes = this.wd5_closes = this.wd6_closes = this.wd0_closes = closes;
                        break;
                    case "to-pe":
                        this.wd4_opens = this.wd5_opens = open;
                        this.wd4_closes = this.wd5_closes = closes;
                        break;
                    case "to-la":
                        this.wd4_opens = this.wd5_opens = this.wd6_opens = open;
                        this.wd4_closes = this.wd5_closes = this.wd6_closes = closes;
                        break;
                    case "to-su":
                        this.wd4_opens = this.wd5_opens = this.wd6_opens = this.wd0_opens = open;
                        this.wd4_closes = this.wd5_closes = this.wd6_closes = this.wd0_closes = closes;
                        break;
                    case "pe-la":
                        this.wd5_opens = this.wd6_opens = open;
                        this.wd5_closes = this.wd6_closes = closes;
                        break;
                    case "pe-su":
                        this.wd5_opens = this.wd6_opens = this.wd0_opens = open;
                        this.wd5_closes = this.wd6_closes = this.wd0_closes = closes;
                        break;
                    case "la-su":
                        this.wd6_opens = this.wd0_opens = open;
                        this.wd6_closes = this.wd0_closes = closes;
                        break;
                    case "ma":
                        this.wd1_opens = open;
                        this.wd1_closes = closes;
                        break;
                    case "ti":
                        this.wd2_opens = open;
                        this.wd2_closes = closes;
                        break;
                    case "ke":
                        this.wd3_opens = open;
                        this.wd3_closes = closes;
                        break;
                    case "to":
                        this.wd4_opens = open;
                        this.wd4_closes = closes;
                        break;
                    case "pe":
                        this.wd5_opens = open;
                        this.wd5_closes = closes;
                        break;
                    case "la":
                        this.wd6_opens = open;
                        this.wd6_closes = closes;
                        break;
                    case "su":
                        this.wd0_opens = open;
                        this.wd0_closes = closes;
                        break;
                    default:
                        System.out.println("SOMETHING WENT WRONG!");
                        System.out.println(availabilityString);
                        break;
                }

            }

        }
    }

    private Date formDate (String time) {
        String[] timeHandMin = time.split("\\.");
        int hour = Integer.parseInt(timeHandMin[0]);
        int min = Integer.parseInt(timeHandMin[1]);
        // Date here doesn't matter, only time is needed. So date is always 1.1.2000 and hours change.
        Date date = new Date(100, 01, 01, hour, min, 0);
        return date;
    }


    public String toString() {
        return name + "\n" + address + " " + city;
    }

    public String displayInformation() {
        return name + "\n\n" + address + "\n" + postalCode + " " + city + "\n\n" + description +
                "\n\n" + availability + "\n\n" + "Coordinates: (" + lat + ", " + lng + ")" ;
    }

    private void formDateArray () {
        this.dateArray = new Date[][]{
                {wd0_opens, wd0_closes},
                {wd1_opens, wd1_closes},
                {wd2_opens, wd2_closes},
                {wd3_opens, wd3_closes},
                {wd4_opens, wd4_closes},
                {wd5_opens, wd5_closes},
                {wd6_opens, wd6_closes}
        };
    }

    // Getters. Nothing to see here.
    public String getPlace_id() {
        return place_id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getRoutingCode() {
        return routingCode;
    }

    public String getAvailability() {
        return availability;
    }

    public String getDescription() {
        return description;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public Date[][] getDateArray () {
        return dateArray;
    }

}
