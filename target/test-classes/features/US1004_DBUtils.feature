Feature: 1004
  Scenario: 1004
    Given kullanici DBUtil ile HMC veri tabanina baglanir
    And kullanici DBUtil ile "tHOTELROOM" tablosundaki "Price" verilerini alir
And kullanici DBUtils ile  "Price" sutunundaki verileri okur
And DBUtil ile tum "Price" degerlerini sira numarasi ile yazdirir