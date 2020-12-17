package sample;

import javafx.beans.property.SimpleStringProperty;

public class CategoryType {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    public CategoryType(String id, String name){
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
