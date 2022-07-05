package com.techproed.pojos;

import java.util.Map;

public class RestfulBookerPojo {

      /*
    https://restful-booker.herokuapp.com/booking
    request body {
                   "firstname": "Selim",
                   "lastname": "Ak",
                   "totalprice": 15000,
                   "depositpaid": true,
                   "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21"
                    }
                 }
   Status code is 200
    response body  {
                            "bookingid": 11,
                            "booking": {
                                "firstname": "Selim",
                                "lastname": "Ak",
                                "totalprice": 15000,
                                "depositpaid": true,
                                "bookingdates": {
                                    "checkin": "2020-09-09",
                                    "checkout": "2020-09-21"
                                }
                            }
                         }

       */

     private String firstname;
     private String lastname;
     private int totalprice;
     private boolean depositpaid;
     private RestfulBookerPojo bookingdates;
    private RestfulBookerPojo booking;
    private int bookingid;

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

    public RestfulBookerPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(RestfulBookerPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public RestfulBookerPojo() {
    }

    public RestfulBookerPojo(String firstname, String lastname, int totalprice, boolean depositpaid, RestfulBookerPojo bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }




    public RestfulBookerPojo(RestfulBookerPojo booking, int bookingid) {
        this.booking = booking;
        this.bookingid = bookingid;
    }

    @Override
    public String toString() {
        return "RestfulBookerPojo{" +
                "booking=" + booking +
                ", bookingid=" + bookingid +
                '}';
    }

    public RestfulBookerPojo getBooking() {
        return booking;
    }

    public void setBooking(RestfulBookerPojo booking) {
        this.booking = booking;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }



    public RestfulBookerPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }



}





