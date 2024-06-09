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
public class Reservation {
    
    private String date;
    private String time;
    private String serviceType;
    private String stylistName;
    private String clientName; 
    
    public Reservation (String date, String time, String serviceType, String stylistName, Client client) {
    this.date = date;
    this.time = time;
    this.serviceType = serviceType;
    this.stylistName = stylistName;
    this.clientName = client.getName(); // create a link to the Client object
  }
    public String toString (){
        
        return "\n"+ getClientName() + " - "+ getServiceType() + " - " + getDate() + " - " + getTime() ;
        
    }

    
    // Getter methods to access reservation details
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getHairStylistName() {
        return stylistName;
    }
    public String getServiceType() {
        return serviceType;
    }
    public String getClientName() {
        return clientName;
  }
    
} 
