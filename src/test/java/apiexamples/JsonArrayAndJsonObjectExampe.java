package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import org.json.JSONArray;

import static io.restassured.RestAssured.given;

public class JsonArrayAndJsonObjectExampe {
/* Response
{
    "firstname": "mallesh46655",
    "lastname": "goud566455",
    "gender": "male",
    "terms": true,
    "age": 45,
    "cities": [
        "hyd",
        "wgl"
    ],
    "address": {
        "flot": "14-0987",
        "street": "RaghavaNagar"
    },
    "Consent": [
        {
            "consentName": "maketing"
        },
        {
            "consentName": "mail"
        }
    ]
}
 */
    @Test
    public void test()
    {
// Build Request
        Response response= given()
                .log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/{id}")
                .pathParam("id",1)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then().log().all()
                .extract().response();

        String jsonResponse = response.asString();
        JSONObject obj = new JSONObject(jsonResponse);

// Extract simple value
        String firstname = obj.getString("firstname");

// Extract nested object
        JSONObject address = obj.getJSONObject("address");
        String street = address.getString("street");

// Extract array
        JSONArray cities = address.getJSONArray("cities");
        for (int i = 0; i < cities.length(); i++) {
            System.out.println(cities.getString(i));
        }

    }

    @Test
    public void consentarray()
    {
/*
"Consent": [
    { "consentName": "maketing" },
    { "consentName": "mail" }
]

 */

        Response response = given()
                .baseUri("https://example.com/api")
                .when()
                .get("/user/123")
                .then()
                .statusCode(200)
                .extract()
                .response();

// Convert response to JSONObject
        JSONObject jsonResponse = new JSONObject(response.asString());

// Extract Consent array
        JSONArray consentArray = jsonResponse.getJSONArray("Consent");

// Validate size
        Assert.assertEquals(consentArray.length(), 2);

// Validate each consentName
        Assert.assertEquals(consentArray.getJSONObject(0).getString("consentName"), "maketing");
        Assert.assertEquals(consentArray.getJSONObject(1).getString("consentName"), "mail");

// Loop through array (dynamic validation)
        for (int i = 0; i < consentArray.length(); i++) {
            String consentName = consentArray.getJSONObject(i).getString("consentName");
            System.out.println("Consent " + i + ": " + consentName);
        }

    }

}
