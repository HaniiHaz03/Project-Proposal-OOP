
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class DBSSConnection {
    private Connection conn = null;
    private final String url, user, password;

    public DBSSConnection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        if (conn != null) {
            System.out.println("Connected to the database");
        }
        return conn;
    }

    public void closeConnection(Connection con, Statement stmt, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
        System.out.println("Connection is closed");
    }

    public void insert(String clientName, String phoneNum, String email) {
        String query = "INSERT INTO Client (`Name`, `Phone Number`, `Email`) VALUES (?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, clientName);
            pstmt.setString(2, phoneNum);
            pstmt.setString(3, email);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new client was inserted successfully!");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("An error occurred while inserting data");
            ex.printStackTrace();
        }
    }

    public List<Client> queryAll() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT `Name`, `Phone Number`, `Email` FROM Client";
        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                clients.add(new Client(
                        rs.getString("Name"),
                        rs.getString("Phone Number"),
                        rs.getString("Email")
                ));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("An error occurred while querying data");
            ex.printStackTrace();
        }
        return clients;
    }

    public Client find(String name) {
        String query = "SELECT `Name`, `Phone Number`, `Email` FROM Client WHERE `Name` = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Client(
                            rs.getString("Name"),
                            rs.getString("Phone Number"),
                            rs.getString("Email")
                    );
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("An error occurred while finding a client");
            ex.printStackTrace();
        }
        return null;
    }

    public void remove(String name) {
        String query = "DELETE FROM Client WHERE `Name` = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Client removed successfully!");
            } else {
                System.out.println("No client found with the name: " + name);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("An error occurred while removing a client");
            ex.printStackTrace();
        }
    }
}
