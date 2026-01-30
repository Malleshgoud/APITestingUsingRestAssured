package apiexamples;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPathExample_with_SOme_Exceptions_API_12 {
    @Test
    public void jsonexample()
    {
        String jsondata="{\n" +
                "    \"firstname\": \"mallesh46655\",\n" +
                "    \"lastname\": \"goud566455\"\n" +
                "}\n" +
                "    ";

        JsonPath jsonPath=new JsonPath(jsondata);
        String firstname=jsonPath.getString("firstname");
        System.out.println("firstname ..."+firstname);


        //if u are not sure what data type of jeson element type then use Object
        Object myfirstname=jsonPath.get("firstname");
        System.out.println("OBject my firstname.."+myfirstname);
    }

    @Test
    public void jsonexample_classcostexception()
    {
        String jsondata="{\n" +
                "    \"firstname\": \"mallesh46655\",\n" +
                "    \"lastname\": \"goud566455\",\n" +
                "    \"gender\":\"male\",\n" +
                "    \"terms\":true,\n" +
                "    \"age\":45\n" +
                "}\n" +
                "     ";


        JsonPath jsonPath=new JsonPath(jsondata);
        System.out.println((Object)jsonPath.get("$"));
        System.out.println(jsonPath.getString("$"));
        System.out.println(jsonPath.getString(""));

        //get json object from root in outut --- same output come for above 3 statement


        //String age=jsonPath.get("age"); //out put: java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String


        int age=jsonPath.getInt("age");
        System.out.println("age ..."+age);


        int elementnotthere=jsonPath.getInt("age456464");
        System.out.println("age ..."+elementnotthere); //java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "io


        int valuemine=34;
        String numberconvet=String.valueOf(valuemine);
        System.out.println("my converstion from Int to string.."+numberconvet);



        String name="mallesh";
        int myconvert=Integer.parseInt(name);
        System.out.println("my converstion from string to integer.."+myconvert); //output java.lang.NumberFormatException: For input string: "mallesh"




        //if u are not sure what data type of jeson element type then use Object
       // Object myfirstname=jsonPath.get("firstname");
        //System.out.println("OBject my firstname.."+myfirstname);
    }

}
