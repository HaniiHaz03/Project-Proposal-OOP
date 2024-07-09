
/*Name   : Nurul Haniizati binti Hazli*/
/*ID     : 24000182                   */
/*Program: Computer Science           */
public class Stylist {
    private String name;
    private String rate;
    private String reservations;

    public Stylist(String name, String rate, String reservations) {
        this.name = name;
        this.rate = rate;
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public String getRate() {
        return rate;
    }

    public String getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Rate: " + rate + ", Reservations: " + reservations;
    }
}

