package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Put_And_Patch_APIExampleBooking_5 {

	@Test
	public void test7_Patchexample()
	{

		// Build Request
		 RestAssured.given().log().all()
	.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/{id}")
		.pathParam("id",1)
				 .header("Content-Type","application/json")
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
				 .body("{\n" +
						 "    \"firstname\": \"Mallesh6789\"\n" +
						 "}")
		.patch()
		.then().log().all()
	   .statusCode(200);


	}

	@Test
	public  void test_putexample()
	{

		RestAssured.
				given()
				.log().all()

				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("/booking/1")
				.header("Content-Type","application/json")
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.body("{\r\n"
						+ "    \"firstname\": \"Specflow111\",\r\n"
						+ "    \"lastname\": \"Selenium453 C#\",\r\n"
						+ "    \"totalprice\": 111,\r\n"
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
				.put()
				//Valdate response
				.then()
				.log().all().statusCode(200);
	}



}
