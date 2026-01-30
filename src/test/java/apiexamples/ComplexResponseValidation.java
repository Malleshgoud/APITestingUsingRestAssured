package apiexamples;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ComplexResponseValidation {
    /*  ####### Response #####################
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
    public void test() {

    Response response = given()
            .baseUri("https://example.com/api")
            .when()
            .get("/user/123")  // replace with actual endpoint
            .then()
            .statusCode(200)
            .extract()
            .response();

    // Convert to JSONPath
    JsonPath js = response.jsonPath();

// ✅ Top-level fields
    Assert.assertEquals(js.getString("firstname"), "mallesh46655");
    Assert.assertEquals(js.getString("lastname"), "goud566455");
    Assert.assertEquals(js.getString("gender"), "male");
    Assert.assertTrue(js.getBoolean("terms"));
    Assert.assertEquals(js.getInt("age"), 45);

// ✅ Nested object validation (address)
    Assert.assertEquals(js.getString("address.street"), "RaghavaNagar");
    Assert.assertEquals(js.getString("address.flot"), "14-0987");

    // ✅ Nested array inside object
    List<String> addressCities = js.getList("address.cities");
    Assert.assertTrue(addressCities.contains("hyd"));
    Assert.assertTrue(addressCities.contains("warangal"));

    // ✅ Top-level array validation
    List<String> cities = js.getList("cities");
    Assert.assertTrue(cities.contains("hyd"));
    Assert.assertTrue(cities.contains("warangal"));

    // ✅ Array of objects (Consent)
    List<String> consents = js.getList("Consent.consentName");
    Assert.assertTrue(consents.contains("maketing"));
    Assert.assertTrue(consents.contains("mail"));
}
}
