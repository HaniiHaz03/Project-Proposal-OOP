import java.util.ArrayList;
import java.util.List;

public class Reservations {
    private List<Reservation> reservations;

    public Reservations() {
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }
}