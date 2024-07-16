
import java.sql.*;

class SqlDB{
    private Connection conn = null;
    private String url, user, password;
    private Statement stmt; 
    
    public SqlDB(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    public void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            // connect way #1
            String url = "jdbc:mysql://"+this.url +":3306/"+ this.user;
            String user = this.user;
            String password = this.password;
 
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
            stmt = conn.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Some sort of error, probably driver loading..");
            ex.printStackTrace();
        }
    }
    
    public void insert(String ClientName, String PhoneNum, String email, String date, String time, String ServiceType, String stylist){
        try{
            stmt.executeUpdate("INSERT INTO Stylist (StylistName, HourlyPrice, ListOfReservations) " + 
                               "VALUES ('" + ClientName + "', '" + PhoneNum + "', '" + email + "', '" + date + "', '" + time + "', '" + ServiceType + "', '" + stylist + "')"); 
        }
        catch (SQLException ex) {
            System.out.println("An error occurred while inserting data");
            ex.printStackTrace();
        }
    }
    
    public void query(){
        try{
            // a table containing the results
            ResultSet rs = stmt.executeQuery("SELECT `Client Name`, `Phone Number`, `Email`, `Date` , `Time`, `Service Type`, `Stylist`FROM Reservation"); 
            while (rs.next()) { // process one row after another
                String c = rs.getString("Client Name"); 
                String p = rs.getString ("Phone Number");
                String e = rs.getString("Email");
                String d = rs.getString("Date");
                String t = rs.getString("Time");
                String st = rs.getString("Service Type");
                String s = rs.getString("Stylist");
                System.out.println("Retrieved " + c + " " + p + " " + e+ " " + d+ " " + t+ " " + st+ " " + s); 
            } 
        }
        catch (SQLException ex) {
            System.out.println("An error occurred while querying data");
            ex.printStackTrace();
        }
    }
}
