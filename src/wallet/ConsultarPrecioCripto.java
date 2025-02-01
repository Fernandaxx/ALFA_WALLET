package wallet;
import java.io.IOException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject; 

public class ConsultarPrecioCripto {

   private static final String URL_API = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum,usd-coin,tether,dogecoin&vs_currencies=usd";

   public double getPrecioCripto (String nomenclatura){
    double precio = -1;
    HttpClient cliente = HttpClient.newHttpClient();
     HttpRequest solicitud = HttpRequest.newBuilder()
       .uri(URI.create(URL_API))
               .GET()
               .build();
       try {
           HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
           if (respuesta.statusCode() == 200) {
               precio = parsear(respuesta.body(), nomenclatura);
           } else {
               //System.out.println("Error: " + respuesta.statusCode());
           }
       } catch (IOException | InterruptedException e) {
           e.printStackTrace();
       }
       return precio;
   }
   private static double parsear(String cuerpoRespuesta, String nomenclatura) {
       JSONObject json = new JSONObject(cuerpoRespuesta);
       double precio = -1;
        switch (nomenclatura){
            case "BTC":
            precio = json.getJSONObject("bitcoin").getDouble("usd");
            break;
            case "ETH":
            precio = json.getJSONObject("ethereum").getDouble("usd");
            break;
            case "USDC":
            precio= json.getJSONObject("usd-coin").getDouble("usd");
            break;
            case "USDT":
            precio = json.getJSONObject("tether").getDouble("usd");
            break;
            case "DOGE":
            precio = json.getJSONObject("dogecoin").getDouble("usd");
            break;
            default:
            break;
        }
        return precio;
    }
}


