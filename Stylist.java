
/*Name   : Nurul Haniizati binti Hazli*/
/*ID     : 24000182                   */
/*Program: Computer Science           */

import java.util.List; // library for list and array list
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) {
		
		Stylist stylist1 = new Stylist("Ally", 45.0);
		Stylist stylist2 = new Stylist("Suzanne", 67.0);
		
		stylist1.getReservations().add(reservation1);
                stylist1.getReservations().add(reservation2);
		stylist1.displayStylistInfo();
		stylist2.displayStylistInfo();
		
	}
}

public class Stylist {
    //declare variable stylist name, hourly rate and list of reservations
    private String stylistName;
    private double hourlyRate;
    private List<Reservation> reservations;

    // Constructor 
    public Stylist(String stylistName, double hourlyRate) {
        // Initialize of stylist name, hourly rate dan array list of reservations
        this.stylistName = stylistName;
        this.hourlyRate = hourlyRate;
        this.reservations = new ArrayList<>();
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
    
    // To display the stylist detail
    public void displayStylistInfo() {
        System.out.println("\n********** Stylist Details **********");
        System.out.println("Stylist Name: " + stylistName);
        System.out.println("Hourly Rate: RM" + hourlyRate);
        System.out.println("Number of Reservations: " + reservations.size());  
    }
}

