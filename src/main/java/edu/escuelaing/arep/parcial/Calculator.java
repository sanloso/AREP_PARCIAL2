package edu.escuelaing.arep.parcial;
import org.json.JSONObject;
import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.port;

public class Calculator
{
    public static void main( String[] args )
    {
        port(getPort());
        get("/sin", (req, res) -> sinFuction(req, res));
    }

    private static Object sinFuction(Request req, Response res) {
        System.out.println(req.queryParams());
        Double dato = Double.parseDouble(req.queryParams("value"));
        Double resultado = Math.sin(dato);
        JSONObject jsObject = new JSONObject();
        jsObject.put("Operation:", "Sin ");
        jsObject.put("Input: ",dato);
        jsObject.put("Output: ",resultado);

        return jsObject;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
