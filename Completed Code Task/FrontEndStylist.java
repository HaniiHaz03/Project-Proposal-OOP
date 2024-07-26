/*Name   : Nurul Haniizati binti Hazli*/
/*ID     : 24000182                   */
/*Program: Computer Science           */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.List;

public class FrontEndStylist extends Application {
    private DBMSConnectionn dbConnection = new DBMSConnectionn(
            "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12719044", 
            "sql12719044", "PQUSjvXBEP"
    );

    private Label lblList = new Label();
    private Stylists listOfStylists = new Stylists();
    private TextField txtName = new TextField("");
    private TextField txtRate = new TextField("");
    private TextField txtRsvp = new TextField("");
    private TextField txtRemoveName = new TextField("");
    private TextField txtFindName = new TextField("");
    private TextArea outputArea = new TextArea();
   
    private String selectedStylistName;
    private String selectedReservations;

    public FrontEndStylist() {
        // Default constructor
    }

    public FrontEndStylist(String stylistName,String reservation) {
        this.selectedStylistName = stylistName;
        this.selectedReservations = reservation;
    }


    @Override
    public void start(Stage stage) {
        // Create Labels
        Label lblName = new Label("Stylist Name =");
        Label lblRate = new Label("Hourly Price =");
        Label lblRsvp = new Label("Reservation =");
        
        // Set the selected stylist name if available
        if (selectedStylistName != null && !selectedStylistName.isEmpty()) {
            txtName.setText(selectedStylistName);
        }
        if (selectedReservations != null && !selectedReservations.isEmpty()) {
            txtRsvp.setText(selectedReservations);
        }

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(500, 400);
        pane.setVgap(10);
        pane.setHgap(10);

        // Set actions on the buttons
        Button btnADD = new Button("Add");
        btnADD.setOnAction(this::addButtonClick);
        
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(this::cancelButtonClick);
        
        Button btnREMOVE = new Button("Remove");
        btnREMOVE.setOnAction(this::removeButtonClick);
        
        Button btnFIND = new Button("Find");
        btnFIND.setOnAction(this::findButtonClick);
        
        Button btnPRINT = new Button("Print");
        btnPRINT.setOnAction(this::printButtonClick);

        // Add the buttons, labels, and text fields to the pane
        pane.add(lblName, 0, 0);
        pane.add(txtName, 1, 0);
        pane.add(lblRate, 0, 1);
        pane.add(txtRate, 1, 1);
        pane.add(lblRsvp, 0, 2);
        pane.add(txtRsvp, 1, 2);
        pane.add(btnADD, 0, 5);
        pane.add(btnREMOVE, 1, 5);
        pane.add(btnFIND, 0, 6);
        pane.add(btnPRINT, 1, 6);
        pane.add(cancelButton, 0, 7);
        pane.add(lblList, 0, 8, 2, 1);
        pane.add(outputArea, 0, 9, 2, 1);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 500, 400);
        stage.setTitle("Stylist");
        stage.setScene(scene);
        stage.show();
    }

    private void addButtonClick(ActionEvent event) {
        String name = txtName.getText();
        String rateStr = txtRate.getText();
        String rsvp = txtRsvp.getText();
        if (name.isEmpty() || rateStr.isEmpty() || rsvp.isEmpty()) {
            lblList.setText("Please fill out all fields.");
            return;
        }

        try {
            float rate = Float.parseFloat(rateStr);
            dbConnection.insert(name, rate, rsvp);
            listOfStylists.addStylist(new Stylist(name, rate, rsvp));
            clearFields();
            lblList.setText("Stylist added successfully!");
        } catch (NumberFormatException e) {
            lblList.setText("Invalid rate format.");
        }
    }

    private void cancelButtonClick(ActionEvent event) {
        clearFields();
        lblList.setText("");
    }

    private void removeButtonClick(ActionEvent event) {
        String nameToRemove = txtName.getText();
        if (nameToRemove.isEmpty()) {
            lblList.setText("Please enter a name to remove.");
            return;
        }

        dbConnection.remove(nameToRemove);
        listOfStylists.removeStylist(nameToRemove);
        txtName.clear();
        lblList.setText("Stylist removed successfully!");
    }

    private void findButtonClick(ActionEvent event) {
        String nameToFind = txtName.getText();
        if (nameToFind.isEmpty()) {
            lblList.setText("Please enter a name to find.");
            return;
        }

        Stylist foundStylist = dbConnection.find(nameToFind);
        if (foundStylist != null) {
            outputArea.setText(foundStylist.toString());
            lblList.setText("Stylist found.");
        } else {
            lblList.setText("Stylist not found!");
        }
        txtName.clear();
    }

    private void printButtonClick(ActionEvent event) {
        StringBuilder stylistList = new StringBuilder("Stylists:\n");
        List<Stylist> stylists = dbConnection.query();
        outputArea.clear();
        for (Stylist stylist : stylists) {
            outputArea.appendText(stylist.toString() +"\n");
        }
        lblList.setText("All stylists printed.");
      
    }

    private void clearFields() {
        txtName.clear();
        txtRate.clear();
        txtRsvp.clear();
        outputArea.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
