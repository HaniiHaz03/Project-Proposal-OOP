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
    
    public void insert(String styname, float rate, String reservations){
        try{
            stmt.executeUpdate("INSERT INTO Stylist (StylistName, HourlyPrice, ListOfReservations) " + 
                               "VALUES ('" + styname + "', '" + rate + "', '" + reservations + "')"); 
        }
        catch (SQLException ex) {
            System.out.println("An error occurred while inserting data");
            ex.printStackTrace();
        }
    }
    
    public void query(){
        try{
            // a table containing the results
            ResultSet rs = stmt.executeQuery("SELECT `Stylist Name`, `Hourly Price`, `List of Reservation` FROM Stylist"); 
            while (rs.next()) { // process one row after another
                String s = rs.getString("Stylist Name"); 
                float n = rs.getFloat("Hourly Price");
                String k = rs.getString("List of Reservation");
                System.out.println("Retrieved " + s + " " + n + " " + k); 
            } 
        }
        catch (SQLException ex) {
            System.out.println("An error occurred while querying data");
            ex.printStackTrace();
        }
    }
}

