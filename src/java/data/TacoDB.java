package data;

import java.sql.*;
import javax.naming.NamingException;

import business.User;
import java.time.LocalDate;
import java.util.LinkedHashMap;

public class TacoDB {

    public static int insert(User user) throws NamingException, SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO users (username, email, password) "
                + "VALUES (?, ?, ?, ?)";

        ps = connection.prepareStatement(query);

        //Because we're sending a null value to tell the DB to take the autoID
        //this needs to be setObject because setInt won't accept null
        ps.setObject(1, user.getUserID());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());

        int rows = ps.executeUpdate();

        ps.close();
        pool.freeConnection(connection);

        return rows;

    }

//    public static int update(User user) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//
//        String query = "UPDATE User SET "
//                + "FirstName = ?, "
//                + "LastName = ? "
//                + "WHERE Email = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, user.getFirstName());
//            ps.setString(2, user.getLastName());
//            ps.setString(3, user.getEmail());
//
//            return ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//            return 0;
//        } finally {
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
//    public static int delete(User user) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//
//        String query = "DELETE FROM User "
//                + "WHERE Email = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, user.getEmail());
//
//            return ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//            return 0;
//        } finally {
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
    public static LinkedHashMap<Integer, User> selectUsers() throws NamingException, SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM users";

        ps = connection.prepareStatement(query);

        rs = ps.executeQuery();

        LinkedHashMap<Integer, User> users = new LinkedHashMap<>();
        while (rs.next()) {
            Integer userID = rs.getInt("userID");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            User user = new User(userID, username, email, password);
            users.put(user.getUserID(), user);
        }

        rs.close();
        ps.close();
        pool.freeConnection(connection);

        return users;

    }

//    public static User selectUser(String email) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT * FROM User "
//                + "WHERE Email = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, email);
//            rs = ps.executeQuery();
//            User user = null;
//            if (rs.next()) {
//                user = new User();
//                user.setFirstName(rs.getString("FirstName"));
//                user.setLastName(rs.getString("LastName"));
//                user.setEmail(rs.getString("Email"));
//            }
//            return user;
//        } catch (SQLException e) {
//            System.out.println(e);
//            return null;
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
}
