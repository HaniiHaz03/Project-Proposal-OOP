import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class FrontEndReservation extends Application {
    private Reservations reservationsList = new Reservations();
     // Create widgets
    private TextField nameField = new TextField();
    private TextField phoneNumField = new TextField();
    private TextField emailField = new TextField();
    private DatePicker datePicker = new DatePicker();
    private ChoiceBox<String> timeChoiceBox = new ChoiceBox<>();
    private ChoiceBox<String> serviceTypeChoiceBox = new ChoiceBox<>();
    private ChoiceBox<String> stylistNameChoiceBox = new ChoiceBox<>();
    private Label reservationDetailsLabel = new Label();

    @Override
    public void start(Stage stage) {
        // Setup the ChoiceBoxes
        timeChoiceBox.getItems().addAll("10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM");
        serviceTypeChoiceBox.getItems().addAll("Haircut", "Coloring", "Styling", "Facial");
        stylistNameChoiceBox.getItems().addAll("Barbara Pelvin", "Anna Hanna ", "Emma Stone", "Adam Rizq");

        // Create UI elements
        // Create a grid pane and set its properties
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(10);
        pane.setHgap(10);
        
        // Add widgets to the grid pane
        pane.add(new Label("Client Name:"), 0, 0);
        pane.add(nameField, 1, 0);
        pane.add(new Label("Phone Number:"), 0, 1);
        pane.add(phoneNumField, 1, 1);
        pane.add(new Label("Email:"), 0, 2);
        pane.add(emailField, 1, 2);
        pane.add(new Label("Date:"), 0, 3);
        pane.add(datePicker, 1, 3);
        pane.add(new Label("Time:"), 0, 4);
        pane.add(timeChoiceBox, 1, 4);
        pane.add(new Label("Service Type:"), 0, 5);
        pane.add(serviceTypeChoiceBox, 1, 5);
        pane.add(new Label("Stylist Name:"), 0, 6);
        pane.add(stylistNameChoiceBox, 1, 6);
        
        // Set an action for the button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(this::handleSubmitButtonClick);
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(this::handleCancelButtonClick);

        pane.add(submitButton, 0, 7);
        pane.add(cancelButton, 1, 7);
        pane.add(reservationDetailsLabel, 0, 8, 2, 1);

        // Setup the stage
        Scene scene = new Scene(pane, 400, 350);
        stage.setTitle("Client Reservation");
        stage.setScene(scene);
        stage.show();
    }

    private void handleSubmitButtonClick(ActionEvent event) {
        String clientName = nameField.getText();
        String phoneNum = phoneNumField.getText();
        String email = emailField.getText();
        String date = datePicker.getValue().toString();
        String time = timeChoiceBox.getValue();
        String serviceType = serviceTypeChoiceBox.getValue();
        String stylistName = stylistNameChoiceBox.getValue();

        // Create a new reservation
        Reservation reservation = new Reservation(date, time, serviceType, stylistName, clientName, phoneNum, email);
        reservationsList.addReservation(reservation);

        // Display the current reservation details
        displayReservationDetails(reservation);
    }

    private void handleCancelButtonClick(ActionEvent event) {
        nameField.clear();
        phoneNumField.clear();
        emailField.clear();
        datePicker.setValue(null);
        timeChoiceBox.setValue(null);
        serviceTypeChoiceBox.setValue(null);
        stylistNameChoiceBox.setValue(null);
        reservationDetailsLabel.setText("");
    }

    private void displayReservationDetails(Reservation reservation) {
        String details = "Reservation Details:\n" +
                         "Client Name: " + reservation.getClientName() + "\n" +
                         "Phone Number: " + reservation.getPhoneNum() + "\n" +
                         "Email: " + reservation.getEmail() + "\n" +
                         "Date: " + reservation.getDate() + "\n" +
                         "Time: " + reservation.getTime() + "\n" +
                         "Service Type: " + reservation.getServiceType() + "\n" +
                         "Stylist Name: " + reservation.getStylistName();
        reservationDetailsLabel.setText(details);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
