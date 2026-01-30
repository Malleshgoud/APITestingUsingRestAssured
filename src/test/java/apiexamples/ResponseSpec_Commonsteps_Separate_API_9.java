package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResponseSpec_Commonsteps_Separate_API_9 {

    ResponseSpecification respsec;

    @BeforeClass
    public void setUpExpetation() {
        respsec= RestAssured.expect().statusCode(200)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(5000L));

    }

    @Test
    public void create_booking() {

        RestAssured.given().log().all()
                .baseUri("https://restful-booker.herokuapp.com/")

                .contentType(ContentType.JSON)
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
                .spec(respsec);


    }

    @Test
    public void create_booking2() {

        RestAssured.given().log().all()
                .baseUri("https://restful-booker.herokuapp.com/")

                .contentType(ContentType.JSON)
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
                .spec(respsec);


    }

}
