package apiexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeadersExamples_API_11 {

   @Test
           public void headerexamples() {

//Build request
      RestAssured.given().log().all()
              .baseUri("https://restful-booker.herokuapp.com/")
              .basePath("booking")
              .header("header1","valu1")
              .header("header2","valu2")
              .when()
              .get();


   }
    @Test
    public void headerexamples_object() {
        Header header=new Header("Header1","value1");
//Build request
        RestAssured.given().log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .header(header)
                .when()
                .get();

    }
    @Test
    public void headerexamples_headers_method() {

        RestAssured.given().log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .headers("h1","v1","h2","v2","h3","v3")
                .when()
                .get();

    }
    @Test
    public void headerexamples_Map() {

       Map<String,String> headermap=new HashMap<>();
        headermap.put("h1","v1");
        headermap.put("h2","v2");
        headermap.put("h3","v3");
        headermap.put("h4","v4");

        RestAssured.given().log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .headers(headermap)
                .when()
                .get();

    }
    @Test
    public void headerexamples_Arraylist() {

       List<Header> list=new ArrayList<>();

        Header header=new Header("header1","value1");
        Header header1=new Header("header2","value2");

        list.add(header);
        list.add(header1);

        Headers headers=new Headers(list);
        RestAssured.given().log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .headers(headers)
                .when()
                .get();

    }
}
