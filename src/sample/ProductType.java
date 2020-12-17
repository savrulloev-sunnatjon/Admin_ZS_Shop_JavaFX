package sample;

import javafx.beans.property.SimpleStringProperty;

public class ProductType {
    private SimpleStringProperty id;
    private SimpleStringProperty prod_name;
    private SimpleStringProperty brand;
    private SimpleStringProperty category_id;
    private SimpleStringProperty size;
    private SimpleStringProperty color;
    private SimpleStringProperty price;
    private SimpleStringProperty quantity;
    private SimpleStringProperty img_url;

    public ProductType(String id, String prod_name, String brand, String category_id,String size,String color,String price,String quantity,String img_url){
        this.id = new SimpleStringProperty(id);
        this.prod_name = new SimpleStringProperty(prod_name);
        this.brand = new SimpleStringProperty(brand);
        this.category_id = new SimpleStringProperty(category_id);
        this.size = new SimpleStringProperty(size);
        this.color = new SimpleStringProperty(color);
        this.price = new SimpleStringProperty(price);
        this.quantity = new SimpleStringProperty(quantity);
        this.img_url = new SimpleStringProperty(img_url);
    }

    public String getImg_url() {
        return img_url.get();
    }

    public SimpleStringProperty img_urlProperty() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url.set(img_url);
    }

    public String getQuantity() {
        return quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getColor() {
        return color.get();
    }

    public SimpleStringProperty colorProperty() {
        return color;
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public String getCategory_id() {
        return category_id.get();
    }

    public SimpleStringProperty category_idProperty() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id.set(category_id);
    }

    public String getBrand() {
        return brand.get();
    }

    public SimpleStringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getProd_name() {
        return prod_name.get();
    }

    public SimpleStringProperty prod_nameProperty() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name.set(prod_name);
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

    public String getSize() {
        return size.get();
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }
}
