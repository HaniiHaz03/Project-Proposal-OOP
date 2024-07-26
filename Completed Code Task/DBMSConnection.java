//Name: Sara Eudora Binti Said
//ID: 24000574
//Program: Computer Science

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class DBMSConnection {
    private Connection conn = null;
    private String url, user, password;

    public DBMSConnection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, user, password);
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

    public void insert(String clientName, String phoneNum, String email, String date, String time, String serviceType, String stylist) {
        String query = "INSERT INTO Reservation (`Client Name`, `Phone Number`, `Email`, `Date`, `Time`, `Service Type`, `Stylist`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, clientName);
            pstmt.setString(2, phoneNum);
            pstmt.setString(3, email);
            pstmt.setString(4, date);
            pstmt.setString(5, time);
            pstmt.setString(6, serviceType);
            pstmt.setString(7, stylist);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new reservation was inserted successfully!");
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

    public void remove(String clientName) {
        String query = "DELETE FROM Reservation WHERE `Client Name` = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, clientName);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Reservation for " + clientName + " was deleted successfully!");
            } else {
                System.out.println("No reservation found for " + clientName);
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

    public Reservation find(String clientName) {
        String query = "SELECT `Client Name`, `Phone Number`, `Email`, `Date`, `Time`, `Service Type`, `Stylist` FROM Reservation WHERE `Client Name` = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, clientName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Reservation(
                        rs.getString("Date"),
                        rs.getString("Time"),
                        rs.getString("Service Type"),
                        rs.getString("Stylist"),
                        rs.getString("Client Name"),
                        rs.getString("Phone Number"),
                        rs.getString("Email")
                );
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

    public List<Reservation> queryAll() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT `Client Name`, `Phone Number`, `Email`, `Date`, `Time`, `Service Type`, `Stylist` FROM Reservation";
        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                reservations.add(new Reservation(
                        rs.getString("Date"),
                        rs.getString("Time"),
                        rs.getString("Service Type"),
                        rs.getString("Stylist"),
                        rs.getString("Client Name"),
                        rs.getString("Phone Number"),
                        rs.getString("Email")
                ));
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
        return reservations;
    }
}

