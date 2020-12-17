package sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Delivery {

    @SerializedName("id_delievery_man")
    @Expose
    private String idDelieveryMan;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("delivery_phone_number")
    @Expose
    private String deliveryPhoneNumber;

    public String getIdDelieveryMan() {
        return idDelieveryMan;
    }

    public void setIdDelieveryMan(String idDelieveryMan) {
        this.idDelieveryMan = idDelieveryMan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDeliveryPhoneNumber() {
        return deliveryPhoneNumber;
    }

    public void setDeliveryPhoneNumber(String phoneNumber) {
        this.deliveryPhoneNumber = deliveryPhoneNumber;
    }

}