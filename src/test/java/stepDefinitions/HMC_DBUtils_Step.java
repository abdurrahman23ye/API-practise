package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class HMC_DBUtils_Step {
    @Given("DBU ile kullanici HMC veri tabanina baglanir")
    public void dbuIleKullaniciHMCVeriTabaninaBaglanir() {

        DBUtils.getConnection();
    }

    @And("DBU ile kullanici {string} tablosundaki {string} verilerini alir")
    public void dbuIleKullaniciTablosundakiVerileriniAlir(String table, String field) {

        String query = "SELECT " + field + " FROM " + table;
       DBUtils.executeQuery(query);
    }

    @And("DBU ile kullanici {string} sutunundaki verileri okur")
    public void dbuIleKullaniciSutunundakiVerileriOkur(String field) throws SQLException {

        DBUtils.getResultset().first();

        System.out.println(DBUtils.getResultset().getString(field));
    }

    @Given("kullanici DBUtil ile HMC veri tabanina baglanir")
    public void kullaniciDBUtilIleHMCVeriTabaninaBaglanir() {

        DBUtils.getConnection();
    }

    @And("kullanici DBUtil ile {string} tablosundaki {string} verilerini alir")
    public void kullaniciDBUtilIleTablosundakiVerileriniAlir(String table, String field) {

        String query = "SELECT " + field + " FROM " + table;
        DBUtils.executeQuery(query);

    }

    @And("kullanici DBUtil ile {string} sutunundaki verileri okur")
    public void kullaniciDBUtilIleSutunundakiVerileriOkur(String field) throws SQLException {

        DBUtils.getResultset().getString(field);
    }

    @And("DBUtil ile tum {string} degerlerini sira numarasi ile yazdirir")
    public void dbutilIleTumDegerleriniSiraNumarasiIleYazdirir(String field) throws SQLException {

        DBUtils.getResultset().last();
        int sonSatirNo= DBUtils.getResultset().getRow();
        DBUtils.getResultset().first();
        for (int i = 1; i <=sonSatirNo ; i++) {
            System.out.println(i+". kayit : "+DBUtils.getResultset().getString(field));
            DBUtils.getResultset().next();
        }
    }

    @And("kullanici DBUtils ile  {string} sutunundaki verileri okur")
    public void kullaniciDBUtilsIleSutunundakiVerileriOkur(String field) throws SQLException {

        DBUtils.getResultset().first();
        System.out.println(DBUtils.getResultset().getString("field"));
    }

    @Then("DBUtill ile {int}. {string} in {int} oldugunu test eder")
    public void dbutillIleInOldugunuTestEder(int istenenSiraNo, String field, int expectedDeger) throws SQLException {

        DBUtils.getResultset().absolute(istenenSiraNo);
        double actualDeger=DBUtils.getResultset().getDouble(field);
        System.out.println("expected deger : " + expectedDeger);
        System.out.println("actual deger : " + actualDeger);
        Assert.assertTrue(actualDeger==expectedDeger);
    }

    @Then("tHOTEL tablosunda IDHotel degeri {int} olan kaydin Email bilgisini {string} yapar")
    public void thotelTablosundaIDHotelDegeriOlanKaydinEmailBilgisiniYapar(int idHotel, String yeniEmail) {

        String updateQuery="UPDATE tHOTEL SET Email = '"+yeniEmail+"' WHERE IDHotel="+idHotel+";";
        DBUtils.executeQuery(updateQuery);
    }


}
