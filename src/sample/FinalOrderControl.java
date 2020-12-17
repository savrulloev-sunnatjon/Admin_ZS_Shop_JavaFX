package sample;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FinalOrderControl {
    private final String url;
    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    Gson gson;
    FinalOrder[] result;

    public FinalOrderControl(String url) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        gson = new Gson();
        result = gson.fromJson(response.body(), FinalOrder[].class);
        this.url = url;
    }

    int getSize(){
        return result.length;
    }

    String[] getFinalOrders(int index){
        String[] products = new String[13];
        products[0] = result[index].getIdFinalOrder();
        products[1] = result[index].getIdProduct();
        products[2] = result[index].getProdName();
        products[3] = result[index].getFirstName();
        products[4] = result[index].getEmail();
        products[5] = result[index].getPhoneNumber();
        products[6] = result[index].getName();
        products[7] = result[index].getSurname();
        products[8] = result[index].getDeliveryPhoneNumber();
        products[9] = result[index].getCity();
        products[10] = result[index].getStreet();
        products[11] = result[index].getHouse();
        products[12] = result[index].getDate();
        return products;
    }
}
