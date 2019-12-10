package testintegration;

import com.gurock.testrail.APIClient;
import org.json.simple.JSONObject;

public class Program {
    public static void main(String[] args) throws Exception
    {
        APIClient client = new APIClient("https://alicorpdigital.testrail.io/");
        client.setUser("..");
        client.setPassword("..");


        JSONObject c = (JSONObject) client.sendGet("get_case/1");
        System.out.println(c.get("title"));

        System.out.println("TODO OK");


    }
}
