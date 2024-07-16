import java.sql.*;

class SqlDB {
   private Connection conn = null;
   private String url, user, password;
   private Statement stmt; 
   
   public SqlDB(String url, String user, String password) {
       this.url=url;
       this.user=user;
       this.password=password;
   }
   
   public void init(){
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            // connect way #1
            String url = "jdbc:mysql://" + this.url + ":3306/" + this.user;
            String user = this.user;
            String password = this.password;
 
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test1");
            }
            
            stmt = conn.createStatement();
 
        } catch (SQLException ex) {//catches only SQL exception
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
            System.out.println(ex);
        } catch (Exception ex) { //catch some other kind of error, especially connector loading
            System.out.println("Some sort of error, probably driver loading..");
            ex.printStackTrace();
        }

    }
    
    public void insert(String date, String time, String serviceType, String stylistName, String clientName, String phoneNum, String email){
        try{
        stmt.executeUpdate ( "INSERT INTO Reservation " + 
                            "VALUES ('"+date+"', '"+time+"', '"+serviceType+"','"+stylistName+"','"+clientName+"','"+phoneNum+"','"+email+"')"); 
        }catch (SQLException ex) {//catches only SQL exception
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
            System.out.println(ex);
        }

    }
    
    public void query(){
        try{
            //a table containing the results
            ResultSet rs = stmt.executeQuery ("SELECT date, time, serviceType, stylistName, clientName, phoneNum, email FROM Reservation"); 
            while (rs.next()) { // process one row  after another
                String date = rs.getString ("date");
                String time = rs.getString ("time");
                String service = rs.getString ("serviceType");
                String stylist = rs.getString ("stylistName");
                String client = rs.getString ("clientName");
                String phone = rs.getString ("phoneNum");
                String email = rs.getString ("email");
                System.out.println ("Retrieved " + date + " " + time + " " + service + " " + stylist + " " + stylist+ " " + client + " " + phone + " " + email + " " ); 
                    } 
        }catch (SQLException ex) {//catches only SQL exception
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
            System.out.println(ex);
        }


    }
       
   }