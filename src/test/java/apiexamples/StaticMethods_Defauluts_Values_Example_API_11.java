package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StaticMethods_Defauluts_Values_Example_API_11 {

    @BeforeTest
    public void setUp()
    {
        RestAssured.baseURI="https://restful-booker.herokuapp.com/";
        RestAssured.basePath="booking";
    }
   @Test
           public void test2() {

//Build request
      RestAssured.given().log().all()

              .body("{\n" +
                      "    \"firstname\": \"mallesh00021675erew76\",\n" +
                      "    \"lastname\": \"goud5675\",\n" +
                      "    \"totalprice\": \"1000\",\n" +
                      "    \"depositpaid\": true,\n" +
                      "    \"bookingdates\": {\n" +
                      "        \"checkin\": \"2018-01-01\",\n" +
                      "        \"checkout\": \"2019-01-01\"\n" +
                      "    },\n" +
                      "    \"additionalneeds\": \"super bowls\"\n" +
                      "}")
              .contentType(ContentType.JSON)
              //hit request and get response
              .post()
              //validate the response
              .then().log().all();



   }

}
