/*Name   : Nurul Haniizati binti Hazli*/
/*ID     : 24000182                   */
/*Program: Computer Science           */
import java.util.*;

public class Stylist {
    //declare variable stylist name, hourly rate and list of reservations
    private String stylistName;
    private double hourlyRate;
    private List<Reservation> reservations;
    
    //default Constructor
    public Stylist() {
        this.reservations = new ArrayList<>();
    }

    // Constructor with only name
    public Stylist(String stylistName) {
        this.stylistName = stylistName;
        this.reservations = new ArrayList<>();
    }
    // Constructor with name and hourly rate
    public Stylist(String stylistName, double hourlyRate) {
        // Initialize of stylist name, hourly rate dan  list of reservations
        this.stylistName = stylistName;
        this.hourlyRate = hourlyRate;
        this.reservations = new ArrayList<>();
    }
    
    // Constructor with name, hourly rate, and reservations
    public Stylist(String stylistName, double hourlyRate, List<Reservation> reservations) {
        this.stylistName = stylistName;
        this.hourlyRate = hourlyRate;
        this.reservations = reservations;
    }

     // Method to get stylist name and to set stylist name
    public String getName() {
        return stylistName;
    }

    public void setName(String stylistName) {
        this.stylistName = stylistName;
    }

    // Method to get hourly rate and set hourly rate
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    // Method to get list of reservationsn and to set list of reservations
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
    
    // To display the stylist detail
    public void displayStylistInfo() {
        System.out.println("\n********** Stylist Details **********");
        System.out.println("Stylist Name: " + stylistName);
        System.out.println("Hourly Rate: RM " + hourlyRate);
        System.out.println("Number of Reservations: " + reservations.size());  
    }
    
}

