package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RequstSpec_Commonsteps_Separate_API_8 {

    RequestSpecification reqspech;
    @BeforeClass
    public  void setuprequest()
    {
        reqspech= RestAssured.given().log().all()
                .baseUri("https://restful-booker.herokuapp.com/")

                .contentType(ContentType.JSON);

    }
   @Test
           public void create_booking() {

//Build request
     String resposbody= RestAssured.given()
              .spec(reqspech)
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

    @Test
    public void update_booking() {

//Build request
     RestAssured.given()
                .spec(reqspech)
                .basePath("booking/1")
                .body("{\n" +
                        "    \"firstname\": \"mallsh883333\",\n" +
                        "    \"lastname\": \"goud5675\",\n" +
                        "    \"totalprice\": \"1000\",\n" +
                        "    \"depositpaid\": true,\n" +
                        "    \"bookingdates\": {\n" +
                        "        \"checkin\": \"2018-01-01\",\n" +
                        "        \"checkout\": \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\": \"super bowls\"\n" +
                        "}")

                //hit request and get response
                .post()
                //validate the response
                .then()
                        .statusCode(200)
             .contentType(ContentType.JSON)
             .time(Matchers.lessThan(5000L));



    }

}
