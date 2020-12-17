package sample;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class CategoryControl {
    private final String url;
    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    Gson gson;
    Category[] result;

    public CategoryControl(String url){
        this.url = url;
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        gson = new Gson();
        result = gson.fromJson(response.body(), Category[].class);
    }

    int getSize(){
        return result.length;
    }

    String[] getCategory(int index){
        String[] delivery_men = new String[4];
        delivery_men[0] = result[index].getIdCategory();
        delivery_men[1] = result[index].getCatName();
        return delivery_men;
    }

    void addCategory(String u, String name) throws IOException {
        final URL url = new URL(u);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        // collect parameters
        final Map<String, String> parameters = new HashMap<>();
        parameters.put("name", name);
        Output(con, parameters);
    }

    private void Output(HttpURLConnection con, Map<String, String> parameters) throws IOException {
        con.setDoOutput(true);
        final DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(getParamsString(parameters));
        out.flush();
        out.close();

        final String content = readInputStream(con);
        con.disconnect();

        System.out.println(content);
    }

    void deleteCategory(String u,String name) throws IOException {
        final URL url = new URL(u);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        // collect parameters
        final Map<String, String> parameters = new HashMap<>();
        parameters.put("name", name);
        Output(con, parameters);
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
