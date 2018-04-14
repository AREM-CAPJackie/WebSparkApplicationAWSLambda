package co.edu.escuelaing.arem.sparkwebapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import static spark.Spark.*;

public class RestController {

    //AWS API Gateway - Lambda function LINK
    public static final String LINK_API_GATEWAY_DEPLOY = "https://nebqnnjewe.execute-api.us-west-2.amazonaws.com/prod/square?value=";

    public static void main(String[] args) throws MalformedURLException {
        staticFileLocation("/static");
        port(8080);
        init();

        get("/square", (request, response) -> {
            Integer value = Integer.parseInt(request.queryParams("value"));

            URL link = new URL(LINK_API_GATEWAY_DEPLOY + value);
            String ans = "";
            try (BufferedReader reader
                    = new BufferedReader(new InputStreamReader(link.openStream()))) {
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    ans += inputLine;
                }
            } catch (IOException x) {
                System.err.println(x);
            }
            return ans;
        });
    }
}
