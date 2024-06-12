//NAME : RAILYNN NISHALIA BINTI RHYMEI
//ID : 22005979 
//Bachelor of Computer Engineering with Honour

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Reservations {
    // private data, inaccessible for public to reach the data
    private int idReservations;
    private String guestName;
    private String dateReservations;
    private int guestNumbers;

    public Reservations(int idReservations, String guestName, String dateReservations, int guestNumbers) {
        this.idReservations = idReservations;
        this.guestName = guestName;
        this.dateReservations = dateReservations;
        this.guestNumbers = guestNumbers;
    }

    public int getIdReservations() {
        return idReservations;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getDateReservations() {
        return dateReservations;
    }

    public int getGuestNumbers() {
        return guestNumbers;
    }

    private List<Reservations> reservations = new ArrayList<>();
    private int nextId = 1;

    // ACTIONS 
    public Reservations addReservations(String guestName, String dateReservations, int guestNumbers) {
        Reservations reservation = new Reservations(nextId++, guestName, dateReservations, guestNumbers);
        reservations.add(reservation);
        return reservation;
    }

    public boolean removeReservations(int idReservations) {
        Reservations reservation = findReservations(idReservations);
        if (reservation != null) {
            reservations.remove(reservation);
            return true;
        }
        return false;
    }

    public void printReservations() {
        System.out.println("\nList of Reservations:");
        for (Reservations reservation : reservations) {
            System.out.println("ID: " + reservation.getIdReservations() +
                               ", Guest: " + reservation.getGuestName() +
                               ", Date: " + reservation.getDateReservations() +
                               ", Guests: " + reservation.getGuestNumbers());
        }
        System.out.println();
    }

    public Reservations findReservations(int idReservations) {
        for (Reservations reservation : reservations) {
            if (reservation.getIdReservations() == idReservations) {
                return reservation;
            }
        }
        return null;
    }
}
