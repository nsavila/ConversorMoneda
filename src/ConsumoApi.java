import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsumoApi {

    public double getExchangeRate(String baseCurrency, String monedaDestino) throws Exception {
        try {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5e421e3bc7ba7d6bc46dbc8d/latest/" + baseCurrency);
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error al obtener los datos de la API. Código de estado: " + response.statusCode());
            }

            // Analizar la respuesta en formato JSON
            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);
            Map<String, Double> conversionRates = moneda.getConversion_rates();
            Double tasaConversion = conversionRates.get(monedaDestino);

            if (tasaConversion == null) {
                throw new RuntimeException("Tasa de conversión no encontrada para la moneda de destino");
            }

            return tasaConversion;

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de conversión: " + e.getMessage(), e);
        }
    }
}