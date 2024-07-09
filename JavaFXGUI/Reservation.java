
//Name: Sara Eudora Binti Said
//ID: 24000574
//Program: Computer Science
public class Reservation {
    private String date;
    private String time;
    private String serviceType;
    private String stylistName;
    private String clientName;
    private String phoneNum;
    private String email;

    public Reservation(String date, String time, String serviceType, String stylistName, String clientName, String phoneNum, String email) {
        this.date = date;
        this.time = time;
        this.serviceType = serviceType;
        this.stylistName = stylistName;
        this.clientName = clientName;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getStylistName() {
        return stylistName;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Reservation Details:\n" +
               "Client Name: " + clientName + "\n" +
               "Phone Number: " + phoneNum + "\n" +
               "Email: " + email + "\n" +
               "Date: " + date + "\n" +
               "Time: " + time + "\n" +
               "Service Type: " + serviceType + "\n" +
               "Stylist Name: " + stylistName;
    }
}


