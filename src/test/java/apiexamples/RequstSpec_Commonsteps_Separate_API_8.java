package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RequstSpec_Commonsteps_Separate_API_8 {

    @BeforeTest
    public  void beforetest()
    {

    }
   @Test
           public void test_resposne_extract_into_string() {

//Build request
     String resposbody= RestAssured.given()
              .baseUri("https://restful-booker.herokuapp.com/")
              .basePath("booking")
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
              .then()
              .extract()
              .body() //even if u commenst this u will get response it is default one we can get resposne with extract() method
              //.asString();
                      .asPrettyString();

       System.out.println(resposbody);



   }

}
