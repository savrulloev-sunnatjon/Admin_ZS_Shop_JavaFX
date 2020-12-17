package sample;

import javafx.beans.property.SimpleStringProperty;

public class DeliveryPerson {
    private SimpleStringProperty id;
    private SimpleStringProperty first_name;
    private SimpleStringProperty last_name;
    private SimpleStringProperty delivery_phone_number;
    public DeliveryPerson(String id, String first_name, String last_name, String delivery_phone_number){
        this.id = new SimpleStringProperty(id);
        this.first_name = new SimpleStringProperty(first_name);
        this.last_name = new SimpleStringProperty(last_name);
        this.delivery_phone_number = new SimpleStringProperty(delivery_phone_number);
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

    public String getFirst_name() {
        return first_name.get();
    }

    public SimpleStringProperty first_nameProperty() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public SimpleStringProperty last_nameProperty() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    public String getDelivery_phone_number() {
        return delivery_phone_number.get();
    }
    public SimpleStringProperty delivery_phone_numberProperty() {
        return delivery_phone_number;
    }
    public void setDelivery_phone_number(String delivery_phone_number) {
        this.delivery_phone_number.set(delivery_phone_number);
    }
}
