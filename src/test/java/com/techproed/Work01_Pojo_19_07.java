package com.techproed;

public class Work01_Pojo_19_07 {

  /*  {
    “firstname”: “asd”,
    “lastname”: “sa”,
    “totalprice”: 111,
    “depositpaid”: true,
    “bookingdates”: {
        “checkin”: “2018-01-01”,
        “checkout”: “2019-01-01”
    },
    “additionalneeds”: “Breakfast”
    }

   */



   private String firstname;
   private String lastname;
   private int totalprice;
   private boolean depositpaid;
   private BookingDatesPojo bookingdates;
   private String additionalneeds;

   public Work01_Pojo_19_07(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDatesPojo bookingdates, String additionalneeds) {
      this.firstname = firstname;
      this.lastname = lastname;
      this.totalprice = totalprice;
      this.depositpaid = depositpaid;
      this.bookingdates = bookingdates;
      this.additionalneeds = additionalneeds;
   }

   public Work01_Pojo_19_07() {
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

   public BookingDatesPojo getBookingdates() {
      return bookingdates;
   }

   public void setBookingdates(BookingDatesPojo bookingdates) {
      this.bookingdates = bookingdates;
   }

   public String getAdditionalneeds() {
      return additionalneeds;
   }

   public void setAdditionalneeds(String additionalneeds) {
      this.additionalneeds = additionalneeds;
   }

   @Override
   public String toString() {
      return "$19_07_Work01_Pojo{" +
              "firstname='" + firstname + '\'' +
              ", lastname='" + lastname + '\'' +
              ", totalprice=" + totalprice +
              ", depositpaid=" + depositpaid +
              ", bookingdates=" + bookingdates +
              ", additionalneeds='" + additionalneeds + '\'' +
              '}';
   }
}
