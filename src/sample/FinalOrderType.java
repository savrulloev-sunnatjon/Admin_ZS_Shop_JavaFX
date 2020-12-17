package sample;
import javafx.beans.property.SimpleStringProperty;

public class FinalOrderType {
    private SimpleStringProperty idFinalOrder;
    private SimpleStringProperty idProduct;
    private SimpleStringProperty prodName;
    private SimpleStringProperty firstName;
    private SimpleStringProperty email;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleStringProperty deliveryPhoneNumber;
    private SimpleStringProperty city;
    private SimpleStringProperty street;
    private SimpleStringProperty house;
    private SimpleStringProperty date;
    public FinalOrderType
            (
            String idFinalOrder,
            String idProduct,
            String prodName,
            String firstName,
            String email,
            String phoneNumber,
            String name,
            String surname,
            String deliveryPhoneNumber,
            String city,
            String street,
            String house,
            String date
            )
    {
        this.idFinalOrder = new SimpleStringProperty(idFinalOrder);
        this.idProduct = new SimpleStringProperty(idProduct);
        this.prodName = new SimpleStringProperty(prodName);
        this.firstName = new SimpleStringProperty(firstName);
        this.email = new SimpleStringProperty(email);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.deliveryPhoneNumber = new SimpleStringProperty(deliveryPhoneNumber);
        this.city = new SimpleStringProperty(city);
        this.street = new SimpleStringProperty(street);
        this.house = new SimpleStringProperty(house);
        this.date = new SimpleStringProperty(date);
    }

    public String getIdFinalOrder() {
        return idFinalOrder.get();
    }

    public SimpleStringProperty idFinalOrderProperty() {
        return idFinalOrder;
    }

    public void setIdFinalOrder(String idFinalOrder) {
        this.idFinalOrder.set(idFinalOrder);
    }

    public String getIdProduct() {
        return idProduct.get();
    }

    public SimpleStringProperty idProductProperty() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct.set(idProduct);
    }

    public String getProdName() {
        return prodName.get();
    }

    public SimpleStringProperty prodNameProperty() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName.set(prodName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getDeliveryPhoneNumber() {
        return deliveryPhoneNumber.get();
    }

    public SimpleStringProperty deliveryPhoneNumberProperty() {
        return deliveryPhoneNumber;
    }

    public void setDeliveryPhoneNumber(String deliveryPhoneNumber) {
        this.deliveryPhoneNumber.set(deliveryPhoneNumber);
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

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
