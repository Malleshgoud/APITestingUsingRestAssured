package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Request_ResponseSpec_Example_API_10 {


    public static void main(String[] args) {

//Request spec
        RequestSpecification reqspech =

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
                                "}");
//Response spec
        ResponseSpecification respsec = RestAssured.expect().statusCode(200)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(5000L));

        //RestAssured.given().spec(reqspech)


        RestAssured.given(reqspech, respsec)
                .post()
                //validate the response
                .then().log().all();
        //.spec(respsec).extract().asPrettyString();

        //System.out.println(responsebody);

    }


}
