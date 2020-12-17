module Admin {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires httpclient;
    requires org.apache.commons.httpclient;
    requires org.apache.httpcomponents.httpclient.fluent;
    requires httpcore;
    opens sample;
}