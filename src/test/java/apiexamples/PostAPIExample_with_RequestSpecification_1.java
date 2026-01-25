package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostAPIExample_with_RequestSpecification_1 {

   @Test
           public void test1() {

//Build request
       RequestSpecification reqspec = RestAssured.given();
       reqspec=reqspec.log().all();

       reqspec.baseUri("https://restful-booker.herokuapp.com/");
reqspec.basePath("/booking");
reqspec.body("{\n" +
        "    \"firstname\": \"mallesh00021675erew76\",\n" +
        "    \"lastname\": \"goud5675\",\n" +
        "    \"totalprice\": \"1000\",\n" +
        "    \"depositpaid\": true,\n" +
        "    \"bookingdates\": {\n" +
        "        \"checkin\": \"2018-01-01\",\n" +
        "        \"checkout\": \"2019-01-01\"\n" +
        "    },\n" +
        "    \"additionalneeds\": \"super bowls\"\n" +
        "}");
reqspec.contentType(ContentType.JSON);

       //http request and get resp
//once hit api we get response so we are calling Response interface here
Response resp=reqspec.post();

//validate response

      // ValidatableResponse validateresp=resp.then();
       //get all response details in conslole
       ValidatableResponse validateresp=resp.then().log().all();
       validateresp.statusCode(200);



   }

}
