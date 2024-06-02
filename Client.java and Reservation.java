//Name: Sara Eudora Binti Said 
//ID: 24000574
//Program: Computer Science
import java.util.Scanner; // Import Scanner for user input

public class Main {

  public static void main(String[] args) {
      
    Client client = new Client();
    client.enterClientDetails();
      
    System.out.println("\nClient Information ");
    System.out.println("Name: " + client.getName());
    System.out.println("Phone number: " + client.getPhoneNumber());
    System.out.println("Email: " + client.getEmail());
    
    Reservation reservation = new Reservation();
    reservation.EnterReservationDetails();
    
    System.out.println("\nClient reservation details  ");
    System.out.println("Date : " + reservation.getDate());
    System.out.println("Time: " + reservation.getTime());
    System.out.println("Hair Stylist name: " + reservation.getHairStylistName());
    System.out.println("Service type : " + reservation.getServiceType());

   
    }
      
}

public class Client {

  // Data fields to store client information
  private String name;
  private String phoneNumber;
  private String email; // Optional data field

  // Constructor to initialize client information
  public Client(String name, String phoneNumber, String email) {
    
  }

  // Method to get clients' details 
  
    public void enterClientDetails() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your name: ");
    name = scanner.nextLine();

    System.out.print("Enter your phone number: ");
    phoneNumber = scanner.nextLine();

    System.out.print("Enter your email : ");
    email = scanner.nextLine();
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

public class Reservation {
    
    private String date;
    private String time;
    private String serviceType;
    private String stylistName;
    
    
    //actions to get user's reservation details 
    public void EnterReservationDetails(){
        
        Scanner scanner = new Scanner(System.in);
     
        
        System.out.println("Enter reservation details ");
        
        System.out.println("Date : ");
        date = scanner.nextLine();
        
        System.out.println("Time slot : ");
        time  = scanner.nextLine();
        
        System.out.println("Type of Service  : ");
        serviceType = scanner.nextLine();
        
        System.out.println("Stylist name : ");
        stylistName = scanner.nextLine();
    
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
} 

