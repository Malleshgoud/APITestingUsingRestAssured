package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostAPIExample_with_MethodChaning_2 {

   @Test
           public void test2() {

//Build request
      RestAssured.given().log().all()
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
              .then().log().all();



   }

}
