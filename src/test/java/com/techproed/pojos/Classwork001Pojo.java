package com.techproed.pojos;

import java.util.HashMap;
import java.util.Map;

public class Classwork001Pojo {

  /*   "firstname": "John",
             "lastname": "Doe",
             "totalprice": 11111,
             "depositpaid": true,
             "bookingdates": {
        "checkin": "2021-09-09",
                "checkout": "2021-09-21"

   */

    /*       "bookingdates": {
        "checkin": "2021-09-09",
                "checkout": "2021-09-21"

      */



   private Map bookingDates;



    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;

    public Classwork001Pojo( String firstname, String lastname, int totalprice, boolean depositpaid,Map bookingDates) {
        this.bookingDates = bookingDates;
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
    }

    public Map getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(Map bookingDates) {
        this.bookingDates = bookingDates;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    @Override
    public String toString() {
        return "Classwork001Pojo{" +
                "bookingDates=" + bookingDates +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                '}';
    }

    public Classwork001Pojo() {
    }
}
