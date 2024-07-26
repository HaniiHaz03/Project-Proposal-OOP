
import java.util.ArrayList;
import java.util.List;

class Reservations {
    private List<Reservation> reservations;

    public Reservations() {
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservationByName(String clientName) {
        reservations.removeIf(reservation -> reservation.getClientName().equals(clientName));
    }

    public Reservation findReservationByName(String clientName) {
        for (Reservation reservation : reservations) {
            if (reservation.getClientName().equals(clientName)) {
                return reservation;
            }
        }
        return null;
    }

    public void printReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public List<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }
}