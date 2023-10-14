import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {
    public static void main(String[] args) {
        try {
            String apiKey = "7d49d2495b7cd2fa6b32463d4dd6da35"; 

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the base currency (e.g., USD): ");
            String baseCurrency = reader.readLine().toUpperCase();
            System.out.print("Enter the target currency (e.g., EUR): ");
            String targetCurrency = reader.readLine().toUpperCase();

           
            String apiUrl = "https://api.exchangeratesapi.io/latest?base=" + baseCurrency + "&symbols=" + targetCurrency + "&access_key=" + apiKey;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                BufferedReader apiReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = apiReader.readLine()) != null) {
                    response.append(line);
                }
                apiReader.close();

                JSONObject exchangeRates = new JSONObject(response.toString());
                double exchangeRate = exchangeRates.getJSONObject("rates").getDouble(targetCurrency);

                System.out.print("Enter the amount in " + baseCurrency + ": ");
                double inputAmount = Double.parseDouble(reader.readLine());

                double convertedAmount = inputAmount * exchangeRate;

                System.out.println(inputAmount + " " + baseCurrency + " is equal to " + convertedAmount + " " + targetCurrency);
            } else {
                System.out.println("Error: Unable to fetch exchange rates. HTTP response code: " + responseCode);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid numeric amount.");
        }
    }
}
