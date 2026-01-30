package apiexamples;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexRequestPayload {
/*
    {
  "firstname": "mallesh46655",
  "address": {
    "cities": [
      "hyd",
      "warangal"
    ],
    "street": "RaghavaNagar",
    "flot": "14-0987"
  },
  "gender": "male",
  "cities": [
    "hyd",
    "warangal"
  ],
  "terms": true,
  "Consent": [
    {
      "consentName": "maketing"
    },
    {
      "consentName": "mail"
    }
  ],
  "age": 45,
  "lastname": "goud566455"
}
**/
    @Test
        public void testpayload() {

        //Cities
        List<String> city=new ArrayList<>();
        city.add("hyd");
        city.add("warangal");
    // Address Map
    Map<String, Object> address = new HashMap<>();
    address.put("flot", "14-0987");
    address.put("street", "RaghavaNagar");
        address.put("cities",city);
    // Consent List
    Map<String, Object> consent1 = new HashMap<>();
    consent1.put("consentName", "maketing");

    Map<String, Object> consent2 = new HashMap<>();
    consent2.put("consentName", "mail");

    List<Map<String, Object>> consentList = new ArrayList<>();
    consentList.add(consent1);
    consentList.add(consent2);

    // Main payload
    Map<String, Object> requestPayload = new HashMap<>();
    requestPayload.put("firstname", "mallesh46655");
    requestPayload.put("lastname", "goud566455");
    requestPayload.put("gender", "male");
    requestPayload.put("terms", true);
    requestPayload.put("age", 45);
    requestPayload.put("address", address);
    requestPayload.put("Consent", consentList);
        requestPayload.put("cities", city);

        RestAssured.given().log().all().body(requestPayload).get();
}

}
