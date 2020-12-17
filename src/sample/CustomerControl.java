package sample;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CustomerControl {
    private final String url;
    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    Gson gson;
    Customer[] result;

    public CustomerControl(String url) throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        gson = new Gson();
        result = gson.fromJson(response.body(), Customer[].class);
        this.url = url;
    }

    int getSize(){
        return result.length;
    }

    String[] getCustomer(int index){
        String[] customer = new String[6];
        customer[0] = result[index].getIdCustomer();
        customer[1] = result[index].getFirstName();
        customer[2] = result[index].getLastName();
        customer[3] = result[index].getEmail();
        customer[4] = result[index].getPhoneNumber();
        customer[5] = result[index].getPassword();
        return customer;
    }
}
