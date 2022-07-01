Feature: US1002 DBUtils ile database baglantisi yapma

  Scenario: TC02 DBUtils ile database baglantisi yapma

    Given DBU ile kullanici HMC veri tabanina baglanir
    And DBU ile kullanici "tHOTELROOM" tablosundaki "Price" verilerini alir
    And DBU ile kullanici "Price" sutunundaki verileri okur