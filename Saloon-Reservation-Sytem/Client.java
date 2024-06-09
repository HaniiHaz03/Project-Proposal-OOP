//Name: Sara Eudora Binti Said
//ID: 24000574
//Program: Computer Science
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

  public static void main(String[] args) {
    
    //Input from user  
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter client name: ");
    String name = scanner.nextLine();

    System.out.print("Enter client phone number: ");
    String phoneNumber = scanner.nextLine();

    System.out.print("Enter client email: ");
    String email = scanner.nextLine();

    System.out.println("Enter reservation details ");
   
    System.out.print("Date (DD-MM-YYYY): ");
    String date = scanner.nextLine(); 

    System.out.print("Time slot (e.g., 10:00 am): " );
    String time = scanner.nextLine(); 

    System.out.print("Enter Service Type (e.g., haircut): ");
    String serviceType = scanner.nextLine();

    System.out.print("Stylist name : ");
    String stylistName = scanner.nextLine();

    // Create a Client object
    Client client = new Client(name, phoneNumber, email);
    
    System.out.println("\nClient Information ");
    System.out.println("Name: " + client.getName());
    System.out.println("Phone number: " + client.getPhoneNumber());
    System.out.println("Email: " + client.getEmail());
    
    //TODO: Currently, reservations are stored in memory. 
    // In the future, this ArrayList can be used to implement 
    // functionalities like saving reservations to a file.
   ArrayList <Reservation > reservations  = new ArrayList <>();    
   Reservation reservation = new Reservation(date, time, serviceType, stylistName, client);
   reservations.add(reservation);


    System.out.println("\nClient reservation details");
    System.out.println("Date: " + reservation.getDate());
    System.out.println("Time: " + reservation.getTime());
    System.out.println("Hair Stylist name: " + reservation.getHairStylistName());
    System.out.println("Service type: " + reservation.getServiceType());
    
    
    System.out.println("\n\nSummary of your reservation ");
   
    for (Reservation r : reservations){
        System.out.println(r);
        
    }

  }
  
}
import java.util.Scanner; // Import Scanner for user input

public class Client {

  // Data fields to store client information
  private String name;
  private String phoneNumber;
  private String email; 

  // Constructor to initialize client information
  public Client(String name, String phoneNumber, String email) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  
  // Getter methods to access client information
  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }
  
}
