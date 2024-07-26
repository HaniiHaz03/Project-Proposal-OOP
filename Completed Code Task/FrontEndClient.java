//Name: Sara Eudora Binti Said
//ID: 24000574
//Program: Computer Science
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.List;

public class FrontEndClient extends Application {
    private TextField nameTf = new TextField();
    private TextField phonenumTf = new TextField();
    private TextField emailTf = new TextField();
    private TextArea outputArea = new TextArea();
    private Label statusLabel = new Label();
    private DBSSConnection dbConnection = new DBSSConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12719044", "sql12719044", "PQUSjvXBEP");

    @Override
    public void start(Stage stage) {
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");
        Button removeButton = new Button("Remove");
        Button findButton = new Button("Find");
        Button printAllButton = new Button("Print All");

        Label nameLabel = new Label("Name: ");
        Label phonenumLabel = new Label("Phone Number: ");
        Label emailLabel = new Label("Email: ");

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        submitButton.setOnAction(this::handleSubmitClick);
        cancelButton.setOnAction(this::handleCancelClick);
        removeButton.setOnAction(this::handleRemoveClick);
        findButton.setOnAction(this::handleFindClick);
        printAllButton.setOnAction(this::handlePrintAllClick);

        pane.add(nameLabel, 0, 0);
        pane.add(nameTf, 1, 0);
        pane.add(phonenumLabel, 0, 1);
        pane.add(phonenumTf, 1, 1);
        pane.add(emailLabel, 0, 2);
        pane.add(emailTf, 1, 2);
        pane.add(submitButton, 0, 3);
        pane.add(cancelButton, 1, 3);
        pane.add(removeButton, 0, 4);
        pane.add(findButton, 1, 4);
        pane.add(printAllButton, 0, 5);
        pane.add(statusLabel, 0, 6, 2, 1);
        pane.add(outputArea, 0, 7, 2, 1);

        Scene scene = new Scene(pane, 400, 400);
        stage.setTitle("Client Information");
        stage.setScene(scene);
        stage.show();
    }

    private void handleSubmitClick(ActionEvent event) {
        String name = nameTf.getText();
        String phonenum = phonenumTf.getText();
        String email = emailTf.getText();

        // Insert client data into the database
        dbConnection.insert(name, phonenum, email);

        // Launch FrontEndReservation with the entered details
        FrontEndReservation frontEndReservation = new FrontEndReservation(name, phonenum, email);
        Stage stage = new Stage();
        frontEndReservation.start(stage);

        // Optionally close the current window
        
    }

    private void handleCancelClick(ActionEvent event) {
        nameTf.clear();
        phonenumTf.clear();
        emailTf.clear();
    }

    private void handleRemoveClick(ActionEvent event) {
        String name = nameTf.getText();
        if (name.isEmpty()) {
            statusLabel.setText("Please enter a name to remove.");
            return;
        }

        dbConnection.remove(name);
        statusLabel.setText("Client removed successfully!");
        clearFields();
    }

    private void handleFindClick(ActionEvent event) {
        String name = nameTf.getText();
        if (name.isEmpty()) {
            statusLabel.setText("Please enter a name to find.");
            return;
        }

        Client client = dbConnection.find(name);
        if (client != null) {
            outputArea.setText(client.toString());
            statusLabel.setText("Client found.");
        } else {
            outputArea.setText("No client found with name: " + name);
            statusLabel.setText("No client found.");
        }
    }

    private void handlePrintAllClick(ActionEvent event) {
        List<Client> clients = dbConnection.queryAll();
        outputArea.clear();
        for (Client client : clients) {
            outputArea.appendText(client.toString() + "\n");
        }
        statusLabel.setText("All clients printed.");
    }

    private void clearFields() {
        nameTf.clear();
        phonenumTf.clear();
        emailTf.clear();
        outputArea.clear();
        statusLabel.setText("");
    }

    public static void main(String[] args) {
        launch(args);
    }
}



