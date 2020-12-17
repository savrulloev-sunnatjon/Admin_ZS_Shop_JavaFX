package sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IssuingPoint {

    @SerializedName("id_issueing_point")
    @Expose
    private String idIssueingPoint;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("house")
    @Expose
    private String house;

    public String getIdIssueingPoint() {
        return idIssueingPoint;
    }

    public void setIdIssueingPoint(String idIssueingPoint) {
        this.idIssueingPoint = idIssueingPoint;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

}