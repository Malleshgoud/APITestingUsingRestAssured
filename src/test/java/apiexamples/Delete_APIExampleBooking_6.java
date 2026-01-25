package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Delete_APIExampleBooking_6 {

	@Test
	public void test8_deleteresource()
	{

		RestAssured.
				given()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/{booking_id}").
				pathParam("booking_id", 5)

				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.contentType(ContentType.JSON).

				//perform http acrion
						when()
				.delete()
				//validate response
				.then()
				.log().
				all().
				assertThat().
				statusCode(201);



	}



}
