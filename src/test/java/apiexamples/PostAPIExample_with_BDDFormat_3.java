package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PostAPIExample_with_BDDFormat_3 {

   @Test
           public void test3() {

//Build request
       RestAssured.
               given()
               .log().all()
               .baseUri("https://restful-booker.herokuapp.com/")
               .basePath("/booking")
               .body("{\r\n"
                       + "    \"firstname\": \"mallesh00021\",\r\n"
                       + "    \"lastname\": \"goud\",\r\n"
                       + "    \"totalprice\": \"1000\",\r\n"
                       + "    \"depositpaid\": true,\r\n"
                       + "    \"bookingdates\": {\r\n"
                       + "        \"checkin\": \"2018-01-01\",\r\n"
                       + "        \"checkout\": \"2019-01-01\"\r\n"
                       + "    },\r\n"
                       + "    \"additionalneeds\": \"super bowls\"\r\n"
                       + "}")
               .contentType(ContentType.JSON)
               //Hit method tyoe
               .when()
               .post()
               //Valdate response
               .then()
               .log().all().statusCode(200);

   }

}
