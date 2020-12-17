package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

public class Controller {
    public TableView<Person> userTable;
    public TableColumn<Person, String> userId = new TableColumn<>();
    public TableColumn<Person, String> userName;
    public TableColumn<Person, String> userLastName;
    public TableColumn<Person, String> userEmail;
    public TableColumn<Person, String> userPhone;
    public TableColumn<Person, String> userPass;
    public Tab DeliveryTab;
    public TextField DeliveryNameField;
    public TextField DeliverySurnameField;
    public TextField DeliveryPhoneField;
    public Button DeliveryAdd;
    public TableColumn<DeliveryPerson, String> DeliveryID;
    public TableColumn<DeliveryPerson, String> DeliveryNameColumn;
    public TableColumn<DeliveryPerson, String> DeliverySurnameColumn;
    public TableColumn<DeliveryPerson, String> DeliveryPhoneColumn;
    public TableView<DeliveryPerson> DeliveryTable;
    public Button DeliveryDelete;
    public TableColumn<IssuingPointType, String> saleColumnId;
    public TableColumn<IssuingPointType, String> saleColumnCity;
    public TableColumn<IssuingPointType, String> saleColumnStreet;
    public TableColumn<IssuingPointType, String> saleColumnHouse;
    public TextField saleCity;
    public TextField saleStreet;
    public TextField saleHouse;
    public Button saleAdd;
    public Button saleRemove;
    public Tab CustomerTab;
    public Tab IssuingTab;
    public TableView<IssuingPointType> IssuingTable;
    public TableView<CategoryType> CategoryTable;
    public TableColumn<CategoryType, String> CategoryIdColumn;
    public TableColumn<CategoryType, String> CategoryNameColumn;
    public TextField CategoryNameField;
    public Button CategoryAdd;
    public Button CategoryDelete;
    public Tab CategoryTab;
    public Tab ProductsTab;
    public TableColumn<ProductType, String> ProductIdColumn;
    public TableColumn<ProductType, String> ProductNameColumn;
    public TableColumn<ProductType, String> ProductBrandColumn;
    public TableColumn<ProductType, String> ProductCategoryColumn;
    public TableColumn<ProductType, String> ProductSizeColumn;
    public TableColumn<ProductType, String> ProductColorColumn;
    public TableColumn<ProductType, String> ProductPriceColumn;
    public TableColumn<ProductType, String> ProductImgUrlColumn;
    public TableColumn<ProductType, String> ProductQuantityColumn;
    public TextField ProductNameField;
    public TextField ProductBrandField;
    public TextField ProductCategoryField;
    public TextField ProductSizeField;
    public TextField ProductPriceField;
    public TextField ProductQuantityField;
    public TextField ProductColorField;
    public TextField ProductImgUrlField;
    public Button ProductAdd;
    public Button ProductRemove;
    public TableView<ProductType> ProductTable;
    public TableView<FinalOrderType> FinalTable;
    public TableColumn<FinalOrderType, String> FinalId;
    public TableColumn<FinalOrderType, String> FinalProductID;
    public TableColumn<FinalOrderType, String> FinalProductName;
    public TableColumn<FinalOrderType, String> FinalCustomerName;
    public TableColumn<FinalOrderType, String> FinalCustomerEmail;
    public TableColumn<FinalOrderType, String> FinalCustomerPhone;
    public TableColumn<FinalOrderType, String> FinalDeliveryName;
    public TableColumn<FinalOrderType, String> FinalDeliverySurname;
    public TableColumn<FinalOrderType, String> FinalDeliveryPhone;
    public TableColumn<FinalOrderType, String> FinalIssuingCity;
    public TableColumn<FinalOrderType, String> FinalIssuingStreet;
    public TableColumn<FinalOrderType, String> FinalIssuingHouse;
    public TableColumn<FinalOrderType, String> FinalDate;
    public Tab FinalOrderTab;
    public Hyperlink SultonBackInsta;
    public Hyperlink MyInsta;
    public Tab AboutUs;
    public Hyperlink ZSShop;
    public Hyperlink ZafarSultonov;
    DeliveryControl deliveryControl = null;
    IssuingPointControl issuingPointControl = null;
    CustomerControl customerControl = null;
    CategoryControl categoryControl = null;
    ProductsControl productsControl = null;
    FinalOrderControl finalOrderControl = null;
    @FXML
    void initialize(){
        ///<Customer panel>
        updateUser();
        CustomerTab.setOnSelectionChanged(event -> updateUser());
        ///<Customer panel/>

        ///<Delivery Panel>
        DeliveryTab.setOnSelectionChanged(event -> updateDeliveryMen());

        DeliveryAdd.setOnAction(actionEvent -> {
            String name = DeliveryNameField.getText();
            String surname = DeliverySurnameField.getText();
            String phone = DeliveryPhoneField.getText();
            try {
                deliveryControl.addDeliveryMan("https://zs-shop-kazan.herokuapp.com/deliveryadd.php",name,surname,phone);
                updateDeliveryMen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        DeliveryDelete.setOnAction(actionEvent -> {
            String phone = DeliveryPhoneField.getText();
            try {
                deliveryControl.deleteDeliveryMan("https://zs-shop-kazan.herokuapp.com/deletedelivery.php",phone);
                updateDeliveryMen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ///<Delivery Panel/>

        ///<Issuing Point>
        IssuingTab.setOnSelectionChanged(event -> updateIssuingPoint());

        saleAdd.setOnAction(actionEvent -> {
            String city = saleCity.getText();
            String street = saleStreet.getText();
            String house = saleHouse.getText();
            try {
                issuingPointControl.addIssuingPoint("https://zs-shop-kazan.herokuapp.com/issuing_pointadd.php",city,street,house);
                updateIssuingPoint();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        saleRemove.setOnAction(actionEvent -> {
            String city = saleCity.getText();
            String street = saleStreet.getText();
            String house = saleHouse.getText();
            try {
                issuingPointControl.deleteIssuingPoint("https://zs-shop-kazan.herokuapp.com/issuing_pointdelete.php",city,street,house);
                updateIssuingPoint();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ///<Issuing Point/>

        ///<Category Panel>
        CategoryTab.setOnSelectionChanged(event -> updateProductCategory());
        CategoryAdd.setOnAction(actionEvent -> {
            String name = CategoryNameField.getText();
            try {
                categoryControl.addCategory("https://zs-shop-kazan.herokuapp.com/categoryadd.php",name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateProductCategory();
        });
        CategoryDelete.setOnAction(actionEvent -> {
            String name = CategoryNameField.getText();
            try {
                categoryControl.deleteCategory("https://zs-shop-kazan.herokuapp.com/categorydelete.php",name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateProductCategory();
        });
        ///<Category Panel/>

        ///<Product Panel>
        ProductsTab.setOnSelectionChanged(event -> {
            if(ProductsTab.isSelected()){
                updateProducts();
            }
        });
        ProductAdd.setOnAction(actionEvent -> {
            String prod_name = ProductNameField.getText();
            String brand = ProductBrandField.getText();
            String category = ProductCategoryField.getText();
            String size = ProductSizeField.getText();
            String color = ProductColorField.getText();
            String price = ProductPriceField.getText();
            String quantity = ProductQuantityField.getText();
            String img_url = ProductImgUrlField.getText();
            try {
                productsControl.addProduct("https://zs-shop-kazan.herokuapp.com/productadd.php",prod_name,brand,category,size,color,price,quantity,img_url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateProducts();
        });
        ProductRemove.setOnAction(actionEvent -> {
            String prod_name = ProductNameField.getText();
            String brand = ProductBrandField.getText();
            String category = ProductCategoryField.getText();
            String size = ProductSizeField.getText();
            String color = ProductColorField.getText();
            String price = ProductPriceField.getText();
            try {
                productsControl.deleteProduct("https://zs-shop-kazan.herokuapp.com/productdelete.php",prod_name,brand,category,size,color,price);
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateProducts();
        });
        ///<Product Panel/>

        ///<Final Order>
        FinalOrderTab.setOnSelectionChanged(event -> updateFinalOrder());
        ///<Final Order/>

        ///<Sultonbek Instagram>
        SultonBackInsta.setOnAction(actionEvent -> {
            Main.hostServices.showDocument("https://www.instagram.com/sultonbekmuminov/");
        });
        ///<Sultonbek Instagram/>
        MyInsta.setOnAction(actionEvent -> {
            Main.hostServices.showDocument("https://www.instagram.com/sun_natjon/");
        });
        ZSShop.setOnAction(actionEvent -> {
            Main.hostServices.showDocument("http://zskazanshop.tilda.ws/");
        });
        ZafarSultonov.setOnAction(actionEvent -> {
            Main.hostServices.showDocument("https://www.instagram.com/zs_0999/");
        });
    }

    void updateFinalOrder(){
        finalOrderControl = new FinalOrderControl("https://zs-shop-kazan.herokuapp.com/finalorder.php");
        String[] finalOrders;
        FinalOrderType finalOrderType;
        ObservableList<FinalOrderType>finalOrderTypes = FXCollections.observableArrayList();
        for (int i = 0; i < finalOrderControl.getSize(); i++){
            finalOrders = finalOrderControl.getFinalOrders(i);
            finalOrderType = new FinalOrderType(
                    finalOrders[0],finalOrders[1],
                    finalOrders[2],finalOrders[3],
                    finalOrders[4],finalOrders[5],
                    finalOrders[6],finalOrders[7],
                    finalOrders[8],finalOrders[9],
                    finalOrders[10],finalOrders[11], finalOrders[12]
            );
            finalOrderTypes.add(finalOrderType);
        }
        FinalId.setCellValueFactory(new PropertyValueFactory<>("idFinalOrder"));
        FinalProductID.setCellValueFactory(new PropertyValueFactory<>("idProduct"));
        FinalProductName.setCellValueFactory(new PropertyValueFactory<>("prodName"));
        FinalCustomerName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        FinalCustomerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        FinalCustomerPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        FinalDeliveryName.setCellValueFactory(new PropertyValueFactory<>("name"));
        FinalDeliverySurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        FinalDeliveryPhone.setCellValueFactory(new PropertyValueFactory<>("deliveryPhoneNumber"));
        FinalIssuingCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        FinalIssuingStreet.setCellValueFactory(new PropertyValueFactory<>("street"));
        FinalIssuingHouse.setCellValueFactory(new PropertyValueFactory<>("house"));
        FinalDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        FinalTable.setItems(finalOrderTypes);
    }

    void updateProducts(){
        productsControl = new ProductsControl("https://zs-shop-kazan.herokuapp.com/product.php");
        String[] products;
        ProductType productType;
        ObservableList<ProductType>productTypes = FXCollections.observableArrayList();
        for (int i = 0; i < productsControl.getSize(); i++){
            products = productsControl.getProducts(i);
            productType = new ProductType(products[0],products[1],products[2],products[3],products[4],products[5],products[6],products[7],products[8]);
            productTypes.add(productType);
        }
        ProductIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("prod_name"));
        ProductBrandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        ProductCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category_id"));
        ProductSizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        ProductColorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        ProductPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        ProductQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ProductImgUrlColumn.setCellValueFactory(new PropertyValueFactory<>("img_url"));
        ProductTable.setItems(productTypes);
    }

    void updateProductCategory() {
        categoryControl = new CategoryControl("https://zs-shop-kazan.herokuapp.com/category.php");
        String[] categories;
        CategoryType categoryType;
        ObservableList<CategoryType>categoryTypes = FXCollections.observableArrayList();
        for (int i = 0; i < categoryControl.getSize(); i++){
            categories = categoryControl.getCategory(i);
            categoryType = new CategoryType(categories[0],categories[1]);
            categoryTypes.add(categoryType);
        }
        CategoryTable.setEditable(true);
        CategoryIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        CategoryNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        CategoryTable.setItems(categoryTypes);
    }

    void updateUser(){
        try {
            customerControl= new CustomerControl("https://zs-shop-kazan.herokuapp.com/users.php");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        String[] users;
        Person person;
        ObservableList<Person> data = FXCollections.observableArrayList();
        for (int i = 0; i < customerControl.getSize(); i++){
            users = customerControl.getCustomer(i);
            person = new Person(users[0],users[1],users[2],users[3],users[4],users[5]);
            data.add(person);
        }
        userTable.setEditable(true);
        userId.setCellValueFactory(new PropertyValueFactory<>("id"));
        userName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        userLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        userEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        userPhone.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        userPass.setCellValueFactory(new PropertyValueFactory<>("password"));
        userTable.setItems(data);
    }

    void updateDeliveryMen(){
        try {
            deliveryControl = new DeliveryControl("https://zs-shop-kazan.herokuapp.com/delivery_men.php");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        String[]deliveryMen;
        DeliveryPerson deliveryPerson;
        ObservableList<DeliveryPerson> deliveryPeople = FXCollections.observableArrayList();
        for (int j = 0; j < deliveryControl.getSize(); j++){
            deliveryMen = deliveryControl.getDeliveryMen(j);
            deliveryPerson = new DeliveryPerson(deliveryMen[0],deliveryMen[1],deliveryMen[2],deliveryMen[3]);
            deliveryPeople.add(deliveryPerson);
        }
        if (DeliveryTab.isSelected()){
            DeliveryTable.setEditable(true);
            DeliveryID.setCellValueFactory(new PropertyValueFactory<>("id"));
            DeliveryNameColumn.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            DeliverySurnameColumn.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            DeliveryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("delivery_phone_number"));
            DeliveryTable.setItems(deliveryPeople);
        }
    }

    void updateIssuingPoint(){
        try {
            issuingPointControl = new IssuingPointControl("https://zs-shop-kazan.herokuapp.com/issuing_point.php");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        String []issuingPoints;
        IssuingPointType issuingPointType;
        ObservableList<IssuingPointType> issuingPointTypes = FXCollections.observableArrayList();
        for (int k = 0; k < issuingPointControl.getSize(); k++){
            issuingPoints = issuingPointControl.getPoint(k);
            issuingPointType = new IssuingPointType(issuingPoints[0],issuingPoints[1],issuingPoints[2],issuingPoints[3]);
            issuingPointTypes.add(issuingPointType);
        }
        if (IssuingTab.isSelected()){
            IssuingTable.setEditable(true);
            saleColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            saleColumnCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            saleColumnStreet.setCellValueFactory(new PropertyValueFactory<>("street"));
            saleColumnHouse.setCellValueFactory(new PropertyValueFactory<>("house"));
            IssuingTable.setItems(issuingPointTypes);
        }
    }
}
