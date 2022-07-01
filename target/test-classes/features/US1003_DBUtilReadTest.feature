Feature: US1003 kullanici DBUtil ile HMC veri tabanina baglanir
  Scenario: kullanici DBUtil ile HMC veri tabanina bağlanma

    Given kullanici DBUtil ile HMC veri tabanina baglanir
    And kullanici DBUtil ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DBUtil ile "Price" sutunundaki verileri okur
   And DBUtil ile tum "Price" degerlerini sira numarasi ile yazdirir
    Then DBUtill ile 4. "Price" in 425 oldugunu test eder