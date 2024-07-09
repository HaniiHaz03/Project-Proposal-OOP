import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/**
 * Write a description of class FrontEnd here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FrontEndClient extends Application
{
    Clients clients = new Clients();
    TextField nameTf = new TextField("    ");
    TextField phonenumTf = new TextField("    ");
    TextField emailTf = new TextField("    ");
    TextArea outputTa = new TextArea();
    
    String name = nameTf.getText();
    String phonenum = phonenumTf.getText();   
    String email = emailTf.getText();
    
    @Override
    public void start(Stage stage)
    {
        Button addClients = new Button("Add Client");
        Button removeClients = new Button("Remove Client");
        Button findClients = new Button("Find Client");
        Button printClients = new Button("Print Clients");
        
        Label nameLabel = new Label("Name: ");
        Label phonenumLabel = new Label("Phone Number: ");
        Label emailLabel = new Label("Email: ");
        
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);
        
        addClients.setOnAction(this::addClick);
        removeClients.setOnAction(this::removeClick);
        findClients.setOnAction(this::findClick);
        printClients.setOnAction(this::printClick);
        
        pane.add(nameLabel, 0, 0);
        pane.add(nameTf, 1, 0);
        pane.add(phonenumLabel, 0, 1);
        pane.add(phonenumTf, 1, 1);
        pane.add(emailLabel, 0, 2);
        pane.add(emailTf, 1, 2);
        pane.add(addClients, 0, 3);
        pane.add(removeClients, 1, 3);
        pane.add(findClients, 2, 3);
        pane.add(printClients, 3, 3);
        pane.add(outputTa, 1, 7, 2, 1);
        
        outputTa.setEditable(false);  // Make TextArea non-editable
        
        Scene scene = new Scene(pane, 300,100);
        stage.setTitle("OOP Project");
        stage.setScene(scene);
        
        stage.show();
    }
    
    public void addClick(ActionEvent event)
    {   
        String name = nameTf.getText();
        String phonenum = phonenumTf.getText();
        String email = emailTf.getText();
        Client newClient = new Client(name, phonenum, email);
        clients.addClient(newClient);
    }
    
    public void removeClick(ActionEvent event)
    {   
        String name = nameTf.getText();
        clients.removeClient(name);
    }    
    
    public void findClick(ActionEvent event)
    {
        String name = nameTf.getText();
        Client foundClient = clients.findClient(name);
        if(foundClient != null) {
            System.out.println("Client found: " + foundClient);
        }else{
            System.out.println("Client not found: " + name);
        }
    }
      
    public void printClick(ActionEvent event)
    {
        outputTa.clear();
        outputTa.appendText("Client List:\n");
        for (Client client : clients.getClients()) {
            outputTa.appendText(client + "\n");
        }
         //quiz:  add to NameList object
    }      
}


