//Name: Sara Eudora Binti Said
//ID: 24000574
//Program: Computer Science

public class Reservation {
    
    private String date;
    private String time;
    private String serviceType;
    private String stylistName;
    private String clientName; 
    
    public Reservation (String date, String time, String serviceType, String stylistName, Client client) {
        this.date = date;
        this.time = time;
        this.serviceType = serviceType;
        this.stylistName = stylistName;
        this.clientName = client.getName(); // create a link to the Client object
    }
  
    public String toString (){
        
        return "\n"+ getClientName() + " - "+ getServiceType() + " - " + getDate() + " - " + getTime() ;
        
    }

    
    // Getter methods to access reservation details
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getHairStylistName() {
        return stylistName;
    }
    public String getServiceType() {
        return serviceType;
    }
    public String getClientName() {
        return clientName;
  }
    
} 
