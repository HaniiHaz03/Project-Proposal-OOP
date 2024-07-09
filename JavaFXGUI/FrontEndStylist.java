import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class FrontEndStylist extends Application {
    private Label lblList = new Label("");
    private Stylists listOfStylists = new Stylists();
    private TextField txtName = new TextField("");
    private TextField txtRate = new TextField("");
    private TextField txtRsvp = new TextField("");
    private TextField txtRemoveName = new TextField("");
    private TextField txtFindName = new TextField("");

    @Override
    public void start(Stage stage) {
        // Create Buttons
        Button btnADD = new Button("ADD STYLIST");
        Button btnREMOVE = new Button("REMOVE STYLIST");
        Button btnFIND = new Button("FIND STYLIST");
        Button btnPRINT = new Button("PRINT STYLIST");

        // Create Labels
        Label lblName = new Label("Full Name =");
        Label lblRate = new Label("Hourly Rate =");
        Label lblRsvp = new Label("List Of Reservations =");
        Label lblRemoveName = new Label("Remove Stylist Name =");
        Label lblFindName = new Label("Find Stylist Name =");

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(400, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        // Set actions on the buttons
        btnADD.setOnAction(this::addButtonClick);
        btnREMOVE.setOnAction(this::removeButtonClick);
        btnFIND.setOnAction(this::findButtonClick);
        btnPRINT.setOnAction(this::printButtonClick);

        // Add the buttons, labels, and text fields to the pane
        pane.add(lblList, 0, 7, 4, 1); // span 4 columns for the label
        pane.add(btnADD, 0, 5);
        pane.add(btnREMOVE, 1, 5);
        pane.add(btnFIND, 0, 6);
        pane.add(btnPRINT, 1, 6);
        pane.add(lblName, 0, 0);
        pane.add(lblRate, 0, 1);
        pane.add(lblRsvp, 0, 2);
        pane.add(lblRemoveName, 0, 3);
        pane.add(lblFindName, 0, 4);
        pane.add(txtName, 1, 0);
        pane.add(txtRate, 1, 1);
        pane.add(txtRsvp, 1, 2);
        pane.add(txtRemoveName, 1, 3);
        pane.add(txtFindName, 1, 4);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 500, 400);
        stage.setTitle("STYLISTS");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    private void addButtonClick(ActionEvent event) {
        String name = txtName.getText().trim();
        String rate = txtRate.getText().trim();
        String rsvp = txtRsvp.getText().trim();

        if (!name.isEmpty() && !rate.isEmpty() && !rsvp.isEmpty()) {
            Stylist stylist = new Stylist(name, rate, rsvp);
            listOfStylists.addStylist(stylist);
            lblList.setText("Total stylists: " + listOfStylists.getCount());

            txtName.clear();
            txtRate.clear();
            txtRsvp.clear();

            System.out.println("**********************************");
            System.out.println("LIST OF STYLISTS: " + listOfStylists.getAllStylists());
            System.out.println("**********************************");
        }
    }

    private void removeButtonClick(ActionEvent event) {
        String nameToRemove = txtRemoveName.getText().trim();
        if (!nameToRemove.isEmpty()) {
            boolean removed = listOfStylists.removeStylist(nameToRemove);
            if (removed) {
                lblList.setText("Total stylists: " + listOfStylists.getCount());
            } else {
                lblList.setText("Stylist not found!");
            }
            txtRemoveName.clear();

            System.out.println("**********************************");
            System.out.println("LIST OF STYLISTS: " + listOfStylists.getAllStylists());
            System.out.println("**********************************");
        }
    }

    private void findButtonClick(ActionEvent event) {
        String nameToFind = txtFindName.getText().trim();
        if (!nameToFind.isEmpty()) {
            Stylist foundStylist = listOfStylists.findStylist(nameToFind);
            if (foundStylist != null) {
                lblList.setText(foundStylist.toString());
            } else {
                lblList.setText("Stylist not found!");
            }
            txtFindName.clear();
        }
    }

    private void printButtonClick(ActionEvent event) {
        StringBuilder stylistList = new StringBuilder("Stylists:\n");
        for (Stylist stylist : listOfStylists.getAllStylists()) {
            stylistList.append(stylist.toString()).append("\n");
        }
        lblList.setText(stylistList.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
