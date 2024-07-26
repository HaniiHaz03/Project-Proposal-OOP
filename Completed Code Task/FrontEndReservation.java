

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.List;

public class FrontEndReservation extends Application {
    private DBMSConnection dbConnection = new DBMSConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12719044", "sql12719044", "PQUSjvXBEP");

    private TextField nameField = new TextField();
    private TextField phoneNumField = new TextField();
    private TextField emailField = new TextField();
    private DatePicker datePicker = new DatePicker();
    private ChoiceBox<String> timeChoiceBox = new ChoiceBox<>();
    private ChoiceBox<String> serviceTypeChoiceBox = new ChoiceBox<>();
    private ChoiceBox<String> stylistNameChoiceBox = new ChoiceBox<>();
    private Label reservationDetailsLabel = new Label();
    private TextArea outputArea = new TextArea();

    private String name;
    private String phoneNum;
    private String email;

    public FrontEndReservation() {}

    public FrontEndReservation(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    @Override
    public void start(Stage stage) {
        timeChoiceBox.getItems().addAll("10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM");
        serviceTypeChoiceBox.getItems().addAll("Haircut", "Coloring", "Styling", "Facial");
        stylistNameChoiceBox.getItems().addAll("Barbara Pelvin", "Anna Hanna", "Emma Stone", "Adam Rizq");

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(10);
        pane.setHgap(10);

        pane.add(new Label("Client Name:"), 0, 0);
        nameField.setText(name);
        pane.add(nameField, 1, 0);
        pane.add(new Label("Phone Number:"), 0, 1);
        phoneNumField.setText(phoneNum);
        pane.add(phoneNumField, 1, 1);
        pane.add(new Label("Email:"), 0, 2);
        emailField.setText(email);
        pane.add(emailField, 1, 2);
        pane.add(new Label("Date:"), 0, 3);
        pane.add(datePicker, 1, 3);
        pane.add(new Label("Time:"), 0, 4);
        pane.add(timeChoiceBox, 1, 4);
        pane.add(new Label("Service Type:"), 0, 5);
        pane.add(serviceTypeChoiceBox, 1, 5);
        pane.add(new Label("Stylist Name:"), 0, 6);
        pane.add(stylistNameChoiceBox, 1, 6);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(this::handleAddButtonClick);

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(this::handleCancelButtonClick);

        Button removeButton = new Button("Remove");
        removeButton.setOnAction(this::handleRemoveButtonClick);

        Button printAllButton = new Button("Print All");
        printAllButton.setOnAction(this::handlePrintAllButtonClick);

        Button findButton = new Button("Find");
        findButton.setOnAction(this::handleFindButtonClick);

        pane.add(submitButton, 0, 7);
        pane.add(cancelButton, 1, 7);
        pane.add(removeButton, 0, 8);
        pane.add(printAllButton, 1, 8);
        pane.add(findButton, 0, 9);
        pane.add(reservationDetailsLabel, 0, 10, 2, 1);
        pane.add(outputArea, 0, 11, 2, 1);

        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Client Reservation");
        stage.setScene(scene);
        stage.show();
    }
    public ChoiceBox<String> getStylistName(){
        return stylistNameChoiceBox;
    }
     public ChoiceBox<String> getReservations(){
        return serviceTypeChoiceBox;
    }

    private void handleAddButtonClick(ActionEvent event) {
        String clientName = nameField.getText();
        String phoneNum = phoneNumField.getText();
        String email = emailField.getText();
        String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
        String time = timeChoiceBox.getValue();
        String serviceType = serviceTypeChoiceBox.getValue();
        String stylist = stylistNameChoiceBox.getValue();

        if (clientName.isEmpty() || phoneNum.isEmpty() || email.isEmpty() || date.isEmpty() || time == null || serviceType == null || stylist == null) {
            reservationDetailsLabel.setText("Please fill out all fields.");
            return;
        }

        dbConnection.insert(clientName, phoneNum, email, date, time, serviceType, stylist);
        clearFields();
        reservationDetailsLabel.setText("Reservation added successfully!");
        
           // Open FrontEndStylist with chosen stylist's name
        FrontEndStylist stylistWindow = new FrontEndStylist(stylist, serviceType);
        Stage stylistStage = new Stage();
        stylistWindow.start(stylistStage);
        
    }

    private void handleCancelButtonClick(ActionEvent event) {
        clearFields();
    }

    private void handleRemoveButtonClick(ActionEvent event) {
        String clientName = nameField.getText();
        if (clientName.isEmpty()) {
            reservationDetailsLabel.setText("Please enter a client name to remove.");
            return;
        }

        dbConnection.remove(clientName);
        reservationDetailsLabel.setText("Client removed successfully!");
        clearFields();
    }

    private void handlePrintAllButtonClick(ActionEvent event) {
        List<Reservation> reservations = dbConnection.queryAll();
        outputArea.clear();
        for (Reservation reservation : reservations) {
            outputArea.appendText(reservation.toString() + "\n");
        }
        reservationDetailsLabel.setText("All reservations printed.");
    }

    private void handleFindButtonClick(ActionEvent event) {
        String clientName = nameField.getText();
        if (clientName.isEmpty()) {
            reservationDetailsLabel.setText("Please enter a client name to find.");
            return;
        }

        Reservation reservation = dbConnection.find(clientName);
        if (reservation != null) {
            outputArea.setText(reservation.toString());
            reservationDetailsLabel.setText("Reservation found.");
        } else {
            outputArea.setText("No reservation found for " + clientName);
            reservationDetailsLabel.setText("No reservation found.");
        }
    }

    private void clearFields() {
        nameField.clear();
        phoneNumField.clear();
        emailField.clear();
        datePicker.setValue(null);
        timeChoiceBox.setValue(null);
        serviceTypeChoiceBox.setValue(null);
        stylistNameChoiceBox.setValue(null);
        reservationDetailsLabel.setText("");
        outputArea.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}




