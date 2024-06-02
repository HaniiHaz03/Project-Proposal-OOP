//Name: Sara Eudora Binti Said 
//ID: 24000574
//Program: Computer Science
import java.util.Scanner; // Import Scanner for user input

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
