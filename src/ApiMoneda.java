import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiMoneda {
    public CodigoMonedaRecord consultaCodigosMoneda(){
        URI urlApi = URI.create("https://v6.exchangerate-api.com/v6/031fa76b5e10a2f1b619c444/codes");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlApi)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CodigoMonedaRecord.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public MonedaRecord consultaCambioMoneda(String monedaBase, String monedaObjetivo, double monedaConversion){
        URI urlApi = URI.create("https://v6.exchangerate-api.com/v6/031fa76b5e10a2f1b619c444/pair/"+monedaBase+"/"+monedaObjetivo+"/"+monedaConversion);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlApi)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MonedaRecord.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
