package Manager;

import Interface.IUser;
import connectJDBC.ConnectJDBC;
import entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManagerUser extends ConnectJDBC implements IUser {
    public Boolean isLogin = false;
    @Override
    public void themUser(User user) {

        Connection connection = getConnection(); // khai bao bien connection de lay ket noi
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "INSERT INTO user (username, password,role) VALUES" +
                    " (\"" + user.getUserName()
                    + "\"," +
                    "\"" + user.getPassword() + "\"," +
                    "\"" + user.getRole() + "\")";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void suaUser(int idUser, User user) {
        Connection connection = getConnection(); // khai bao bien connection de lay ket noi
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String sql = "UPDATE user SET username = \"" + user.getUserName() + "\"," +
                    "password = \"" + user.getPassword() + "\"," +
                    "role = \"" + user.getRole() + "\"" +
                    "WHERE id = " + idUser;
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public void xoaUser(int idUser) {
        Connection connection = getConnection(); // khai bao bien connection de lay ket noi
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "DELETE FROM user WHERE id = " + idUser;
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void hienThiTatCaUser() {
        Connection connection = getConnection(); // khai bao bien connection de lay ket noi
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM user";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("username: " + resultSet.getString("username"));
                System.out.println("password: " + resultSet.getString("password"));
                System.out.println("role: " + resultSet.getString("role"));
                System.out.println("created_at: " + resultSet.getString("created_at"));
                System.out.println("--------------------------");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }
    @Override
    public boolean login(String userName, String password) {
        Connection connection = getConnection(); // khai bao bien connection de lay ket noi
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM user WHERE username = \"" + userName +
                    "\" AND password = \"" + password + "\"";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                isLogin = true;
            } else {
                isLogin = false;
            }
            return isLogin;

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return false;
    }

    public boolean logout() {
        isLogin = false;
        System.out.println("Dang xuat thanh cong");
        return false;
    }

    public boolean checkAdmin(String userName, String password) {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM user WHERE username = \"" + userName +
                    "\" AND password = \"" + password + "\"";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                if (resultSet.getString("role").equals("admin")) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return false;
    }

    public boolean checkUser(int idUser) {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM user WHERE id = " + idUser;
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println("User ton tai");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        System.out.println("User khong ton tai");
        return false;
    }
}
