package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetAPIExampleBooking_4 {

	@Test
	public void test4()
	{

	// Build Request
	RequestSpecification reqspec = RestAssured.given().log().all();
		reqspec.baseUri("https://restful-booker.herokuapp.com/");
		reqspec.basePath("booking/{id}");
		reqspec.pathParam("id",1);
	reqspec.contentType(ContentType.JSON);
	Response resp = reqspec.get();
	ValidatableResponse vresp = resp.then();
		vresp.statusCode(200);


}
	@Test
	public void test5_mehodchaning()
	{

		// Build Request
		 RestAssured.given().log().all()
	.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/{id}")
		.pathParam("id",1)
		.contentType(ContentType.JSON)
		.get()
		.then().log().all()
	   .statusCode(200);


	}

	@Test
	public void test6_bddformat()
	{

		// Build Request
		RestAssured
				.given()
				    .log().all()
				    .baseUri("https://restful-booker.herokuapp.com/")
				    .basePath("booking/{id}")
				    .pathParam("id",1)
				     .contentType(ContentType.JSON)
				.when()
				   .get()
				.then()
				    .log().all()
				.statusCode(200);


	}
	@Test
	public void test6_pathparam()
	{

		Map<String,String> params=new HashMap<>();
		params.put("booking","booking");
		params.put("bookingId","1");

		// Build Request
		RestAssured.
				given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("/{booking}/{bookingId}")
				//.pathParam("booking", "booking")
				//.pathParam("bookingId", 1)
				.pathParams(params)
				.contentType(ContentType.JSON)
				// Hit method tyoe
				.when()
				.get()

				// Valdate response
				.then()
				.log().all().statusCode(200);
	}


}
