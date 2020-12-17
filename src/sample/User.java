package sample;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class User {
    private final String url;
    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    Gson gson;
    Result result;

    public User(String url) throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        gson = new Gson();
        result = gson.fromJson(response.body(), Result.class);
        this.url = url;
    }

    String[] getProduct(){
        String []user = new String[9];
        user[0] = result.getIdProduct();
        user[1] = result.getProdName();
        user[2] = result.getBrand();
        user[3] = result.getCategoryId();
        user[4] = result.getSize();
        user[5] = result.getColor();
        user[6] = result.getPrice();
        user[7] = result.getQuantity();
        user[8] = result.getImgUrl();
        return user;
    }
}
