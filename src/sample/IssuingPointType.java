package sample;

import javafx.beans.property.SimpleStringProperty;

public class IssuingPointType {
    private SimpleStringProperty id;
    private SimpleStringProperty city;
    private SimpleStringProperty street;
    private SimpleStringProperty house;
    public IssuingPointType(String id, String city, String street, String house){
        this.id = new SimpleStringProperty(id);
        this.city = new SimpleStringProperty(city);
        this.street = new SimpleStringProperty(street);
        this.house = new SimpleStringProperty(house);
    }

    public String getStreet() {
        return street.get();
    }

    public SimpleStringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getHouse() {
        return house.get();
    }

    public SimpleStringProperty houseProperty() {
        return house;
    }

    public void setHouse(String house) {
        this.house.set(house);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }
}
