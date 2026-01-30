package apiexamples;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.util.List;

public class JsonPathExample_NestedJsonobjects_API_13 {
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
                "    \"age\":45,\n" +
                "    \"address\":\n" +
                "    {\n" +
                "        \"flot\":\"14-0987\",\n" +
                "        \"street\":\"RaghavaNagar\"\n" +
                "    },\n" +
                "    \"Consent\":\n" +
                "    [\n" +
                "        {\n" +
                "            \"consentName\":\"maketing\"\n" +
                "        },\n" +
                "         {\n" +
                "            \"consentName\":\"mail\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n" +
                "    ";


        JsonPath jsonPath=new JsonPath(jsondata);

      Object obj=jsonPath.get("address");
        System.out.println(obj);

        System.out.println(jsonPath.getString("firstname"));

        System.out.println(jsonPath.getString("address.flot"));

        System.out.println(jsonPath.getString("Consent[0].consentName"));

    }


    @Test
    public void jsonarray_example() {
        String jsonarray = "[\n" +
                "     \"10\",\n" +
                "        \"20\",\n" +
                "        \"30\"\n" +
                "]";

        JsonPath jsonPath = new JsonPath(jsonarray);
        System.out.println(jsonPath.getString("[0]"));
        System.out.println(jsonPath.getList("$").size());

    }
    @Test
            public void filelocationjson() {
        String jsonfilepath = System.getProperty("user.dir")+"/src/test/java/payloads/user.json";
        System.out.println(System.getProperty("user.dir"));
        File jsonfile = new File(jsonfilepath);
        JsonPath jsonpath = new JsonPath(jsonfile);
        System.out.println(jsonpath.getString("[0].firstname"));

        List<String> allfirstname=jsonpath.getList("firstname");
        System.out.println(allfirstname);

    }

}
