//NAME: ZULAIKHA BINTI MOHD AZHAR
//ID: 24000918
//PROGRAM: BACHELOR OF COMPUTER SCIENCE

import java.util.*; // Import the java.util package for Scanner class

public class Main {

  public static void main(String[] args) {
    // Create a Scanner object to read user input
    Scanner scanner = new Scanner(System.in);

    // Create a Clients object, passing the scanner for user input
    Clients myClient = new Clients(scanner);

    int choice;

    do {
      // Display the menu options
      System.out.println("\nSaloon Reservation System");
      System.out.println("1. Add Client");
      System.out.println("2. Remove Client");
      System.out.println("3. Print Clients");
      System.out.println("4. Find Client");
      System.out.println("5. Exit");
      System.out.print("Enter a number: ");
      choice = scanner.nextInt();
      System.out.print("\n");

      // Handle user choice based on the entered number
      switch (choice) {
        case 1:
          myClient.addClient();
          break;
        case 2:
          myClient.removeClient();
          break;
        case 3:
          myClient.printClients();
          break;
        case 4:
          myClient.findClients();
          break;
        case 5:
          System.out.println("Exiting system...");
          break;
        default:
          System.out.println("Invalid number!");
      }
    } while (choice != 5);

  }
}
import java.util.*; // Import the java.util package for ArrayList and Scanner

public class Clients {

  // An ArrayList to store Client objects
  private ArrayList<Client> clients = new ArrayList<>();

  private Scanner scanner;

  // Constructor to store the scanner
  public Clients(Scanner scanner) {
    this.scanner = scanner; 
  }
  
  //ACTIONS: 
  
  // Action to add new client
  public void addClient() {
    System.out.print("Enter client name: ");
    String clientName = scanner.next(); // Read client name from user

    System.out.print("Enter client phone number: ");
    String phoneNumber = scanner.next(); // Read phone number from user

    // Create a new Client object and add it to the ArrayList
    clients.add(new Client(clientName, phoneNumber));

    System.out.println("Client successfully added!\n");
  }

  // Action to remove client
  public void removeClient() {
    System.out.print("Enter client name to remove: ");
    String clientName = scanner.next(); // Read client name from user

    // Find the index of the client with matching name
    int i = findClientIndex(clientName);

    if (i != -1) {
      // Client found, remove it from the list
      clients.remove(i);
      System.out.println("Client successfully removed!\n");
    } else {
      // Client not found
      System.out.println("Client not found!\n");
    }
  }

  // Action to print all clients
  public void printClients() {
    if (clients.isEmpty()) {
      System.out.println("No clients found.\n");
      return;
    }

    System.out.println("List of Clients:");
    // Loop through each Client object in the ArrayList and print details
    for (Client client : clients) {
      System.out.println("Name: " + client.getName() + ", Phone Number: " + client.getPhone());
    }
    System.out.println("\n");
  }

  // Action to find a specific client by name
  public void findClients() {
    System.out.print("Enter client name to find: ");
    String clientName = scanner.next(); // Read client name from user

    // Find the index of the client with matching name
    int i = findClientIndex(clientName);

    if (i != -1) {
      // Client found, print details
      Client client = clients.get(i);
      System.out.println("Name: " + client.getName() + ", Phone Number: " + client.getPhone() + "\n");
    } else {
      // Client not found
      System.out.println("Client not found!\n");
    }
  }

  // Helper method to find the index of a client with a specific name
  private int findClientIndex(String clientName) {
    // Loop through each Client object in the ArrayList
    for (int i = 0; i < clients.size(); i++) {
      // Check if the current client's name matches the input name
      if (clients.get(i).getName().equals(clientName)) {
        return i; // Client found, return the index
      }
    }
    return -1; // Client not found
  }
}

// Class to represent a Client with name and phone number
class Client {
  private String name;
  private String phone;

  // Constructor to initialize client details
  public Client(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  // Getter method to get the client's name
  public String getName() {
    return name;
  }

  // Getter method to get the client's phone number
  public String getPhone() {
    return phone;
  }
}
