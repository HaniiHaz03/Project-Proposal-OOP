
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
  public static void main(String[] args{

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

    Stylist stylist1 = new Stylist("Ally", 45.0);
		Stylist stylist2 = new Stylist("Suzanne", 67.0);
		
		//Set data using setter method
		Stylist stylist3 = new Stylist();
		stylist3.setName("Mila");
		stylist3.setHourlyRate(30.0);	
	    
	    // Constructur with only name
		Stylist stylist = new Stylist("Zahir") ;
		stylist.setHourlyRate(50.0);
    stylist1.displayStylistInfo();
		stylist2.displayStylistInfo();
		stylist3.displayStylistInfo();
		
		stylist.displayStylistInfo();
    {
     Reservations reservationSystem = new Reservations(0, null, null, 0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Reservation");
            System.out.println("2. Remove Reservation");
            System.out.println("3. Print Reservations");
            System.out.println("4. Find Reservation");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            if (choice == 1) {
                System.out.print("Enter guest name: ");
                String guestName = scanner.nextLine();
                System.out.print("Enter reservation date: ");
                String dateReservations = scanner.nextLine();
                System.out.print("Enter number of guests: ");
                int guestNumbers = scanner.nextInt();
                Reservations res = reservationSystem.addReservations(guestName, dateReservations, guestNumbers);
                System.out.println("Added: " + res.getIdReservations());

            } else if (choice == 2) {
                System.out.print("Enter reservation ID to remove: ");
                int id = scanner.nextInt();
                if (reservationSystem.removeReservations(id)) {
                    System.out.println("Removed successfully.");
                } else {
                    System.out.println("Reservation not found.");
                }

            } else if (choice == 3) {
                reservationSystem.printReservations();

            } else if (choice == 4) {
                System.out.print("Enter reservation ID to find: ");
                int id = scanner.nextInt();
                Reservations res = reservationSystem.findReservations(id);
                if (res != null) {
                    System.out.println("Found: " + res.getGuestName() + " on " + res.getDateReservations());
                } else {
                    System.out.println("Reservation not found.");
                }

            } else if (choice == 5) {
                break;
            }
        }

        scanner.close();
        }

      {
        Scanner scanner = new Scanner(System.in);
        Stylists lists = new Stylists();                // lists is the object
        boolean run = true;

        while (run) {                               // using loop to continuously prompt the user for actions
            System.out.println("1. Add Stylist");
            System.out.println("2. Remove Stylist");
            System.out.println("3. Print Stylists");
            System.out.println("4. Find Stylist");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter stylist name to add: ");
                    String addName = scanner.nextLine();            
                    lists.addStylist(addName);                   // method to call the class with object
                    break;
                case 2:
                    System.out.print("Enter stylist name to remove: ");
                    String removeName = scanner.nextLine();         
                    lists.removeStylist(removeName);             // method to call the class with object
                    break;
                case 3:
                    lists.printStylist();                        // method to call the class with object
                    break;
                case 4:
                    System.out.print("Enter stylist name to find: ");
                    String findName = scanner.nextLine();
                    lists.findStylist(findName);                 // method to call the class with object
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    System.out.print("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

  
}
