//Name: Sara Eudora Binti Said
//ID: 24000574
//Program: Computer Science

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
