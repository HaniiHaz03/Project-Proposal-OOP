/*Name   : Nurul Haniizati binti Hazli*/
/*ID     : 24000182                   */
/*Program: Computer Science           */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class DBMSConnectionn {
    private Connection conn = null;
    private String url, user, password;

    public DBMSConnectionn(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(url, user, password);
        if (conn != null) {
            System.out.println("Connected to the database");
        }
        return conn;
    }

    public void closeConnection(Connection con, Statement stmt) throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
        System.out.println("Connection is closed");
    }

    public void insert(String name, float rate, String reservations) {
        String query = "INSERT INTO Stylist (`Stylist Name`, `Hourly Price`, `Reservations`) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setFloat(2, rate);
            stmt.setString(3, reservations);
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new stylist was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while inserting data");
            System.out.println("Error Message: " + ex.getMessage());
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("Error Code: " + ex.getErrorCode());
            ex.printStackTrace();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println("An error occurred while establishing the connection");
            ex.printStackTrace();
        }
    }

    public void remove(String name) {
        String query = "DELETE FROM Stylist WHERE `Stylist Name` = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Stylist " + name + " was deleted successfully!");
            } else {
                System.out.println("No stylist found for " + name);
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while deleting data");
            System.out.println("Error Message: " + ex.getMessage());
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("Error Code: " + ex.getErrorCode());
            ex.printStackTrace();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println("An error occurred while establishing the connection");
            ex.printStackTrace();
        }
    }

    public Stylist find(String name) {
        String query = "SELECT `Stylist Name`, `Hourly Price`, `Reservations` FROM Stylist WHERE `Stylist Name` = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Stylist(rs.getString("Stylist Name"), 
                                   rs.getFloat("Hourly Price"), 
                                   rs.getString("Reservations"));
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while finding data");
            System.out.println("Error Message: " + ex.getMessage());
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("Error Code: " + ex.getErrorCode());
            ex.printStackTrace();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println("An error occurred while establishing the connection");
            ex.printStackTrace();
        }
        return null;
    }

    public List<Stylist> query() {
        List<Stylist> stylists = new ArrayList<>();
        String query = "SELECT `Stylist Name`, `Hourly Price`, `Reservations` FROM Stylist";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                stylists.add(new Stylist(rs.getString("Stylist Name"), 
                                         rs.getFloat("Hourly Price"), 
                                         rs.getString("Reservations")));
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while querying data");
            System.out.println("Error Message: " + ex.getMessage());
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("Error Code: " + ex.getErrorCode());
            ex.printStackTrace();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println("An error occurred while establishing the connection");
            ex.printStackTrace();
        }
        return stylists;
    }
}




