package com.finleap.casestudy.feliperocha.openweatherapiclient.exception;

public class CityNotInTheListException extends RuntimeException {
    public CityNotInTheListException(String city) {
        super(city + " is not in the list");
    }
}
