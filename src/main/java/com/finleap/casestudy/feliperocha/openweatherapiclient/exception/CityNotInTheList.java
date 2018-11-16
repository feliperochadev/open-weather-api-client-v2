package com.finleap.casestudy.feliperocha.openweatherapiclient.exception;

public class CityNotInTheList extends RuntimeException {
    public CityNotInTheList(String city) {
        super(city + " is not in the list");
    }
}
