package sample;

import com.google.gson.Gson;
import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class IssuingPointControl {
    private final String url;
    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    Gson gson;
    IssuingPoint[] result;

    public IssuingPointControl(String url) throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        gson = new Gson();
        result = gson.fromJson(response.body(), IssuingPoint[].class);
        this.url = url;
    }

    int getSize(){
        return result.length;
    }

    String[] getPoint(int index){
        String[] delivery_men = new String[4];
        delivery_men[0] = result[index].getIdIssueingPoint();
        delivery_men[1] = result[index].getCity();
        delivery_men[2] = result[index].getStreet();
        delivery_men[3] = result[index].getHouse();
        return delivery_men;
    }

    void addIssuingPoint(String u, String city, String street, String house) throws IOException {
        final URL url = new URL(u);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        // collect parameters
        final Map<String, String> parameters = new HashMap<>();
        parameters.put("city", city);
        parameters.put("street", street);
        parameters.put("house", house);

        con.setDoOutput(true);
        final DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(getParamsString(parameters));
        out.flush();
        out.close();

        final String content = readInputStream(con);
        con.disconnect();

        System.out.println(content);
    }

    void deleteIssuingPoint(String u,String city,String street, String house) throws IOException {
        final URL url = new URL(u);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        // collect parameters
        final Map<String, String> parameters = new HashMap<>();
        parameters.put("city", city);
        parameters.put("street", street);
        parameters.put("house", house);
        con.setDoOutput(true);
        final DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(getParamsString(parameters));
        out.flush();
        out.close();

        final String content = readInputStream(con);
        con.disconnect();

        System.out.println(content);
    }

    public static String readInputStream(final HttpURLConnection con){
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String getParamsString(final Map<String, String> params) {
        final StringBuilder result = new StringBuilder();

        params.forEach((name, value) -> {
            try {
                result.append(URLEncoder.encode(name, "UTF-8"));
                result.append('=');
                result.append(URLEncoder.encode(value, "UTF-8"));
                result.append('&');
            } catch (final UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });

        final String resultString = result.toString();
        return !resultString.isEmpty()
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

}
