import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Base Currency (USD, INR, EUR): ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter Target Currency (USD, INR, EUR): ");
        String target = sc.next().toUpperCase();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        try {
            String apiUrl = "https://open.er-api.com/v6/latest/" + base;

            URL url = java.net.URI.create(apiUrl).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            String json = response.toString();

            String search = "\"" + target + "\":";
            int index = json.indexOf(search);

            if (index == -1) {
                System.out.println("Invalid target currency!");
                return;
            }

            int start = index + search.length();
            int end = json.indexOf(",", start);

            double rate = Double.parseDouble(json.substring(start, end));
            double convertedAmount = amount * rate;

            System.out.println("Converted Amount: "
                    + convertedAmount + " " + target);

        } catch (Exception e) {
            System.out.println("Conversion failed. Check internet or currency code.");
        }

        sc.close();
    }
}
