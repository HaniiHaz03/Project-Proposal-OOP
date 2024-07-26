public class Stylist {
    private String name;
    private float rate;
    private String reservation; // Single reservation type

    public Stylist(String name, float rate, String reservation) {
        this.name = name;
        this.rate = rate;
        this.reservation = reservation;
    }

    public String getName() {
        return name;
    }

    public float getRate() {
        return rate;
    }

    public String getReservation() {
        return reservation;
    }

    public float calculateTotalPrice() {
        float total = 0.0f;

        switch (reservation) {
            case "Coloring":
                total = rate * 3;  // Fixed time for coloring
                break;
            case "Facial":
                total = rate * 2;  // Fixed time for facial
                break; 
            case "Styling":
                total = rate * 4;  // Fixed time for styling
                break;
            case "Haircut":
                total = rate * 2;  // Fixed time for haircut
                break;
            default:
                System.out.println("Unknown reservation type: " + reservation);
                break;
        }

        return total;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + 
               "Rate: RM" + rate + "\n" + 
               "Reservation: " + reservation + "\n" +
               "Total Price: RM" + calculateTotalPrice();
    }
}



