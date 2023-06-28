package Manager;

import Interface.ILopHoc;
import connectJDBC.ConnectJDBC;
import entity.LopHoc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManagerClasses extends ConnectJDBC implements ILopHoc {

    public void createTableLopHoc() {
        Connection connection = getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE ClassesTB ("
                    + "maLop INT(11) NOT NULL AUTO_INCREMENT,"
                    + "tenLop VARCHAR(255) NOT NULL,"
                    + "PRIMARY KEY (maLop))";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void themLopHoc(LopHoc lopHoc) {
        Connection connection = getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String sql = "INSERT INTO ClassesTB (tenLop) VALUES (\"" + lopHoc.getTenLop() + "\")";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void suaLopHoc(int maLopHoc, LopHoc lopHoc) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement(); //
            String sql = "UPDATE ClassesTB SET tenLop = \"" + lopHoc.getTenLop() +
                    "\" WHERE Id = " + maLopHoc;
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void xoaLopHoc(int maLopHoc) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM ClassesTB WHERE Id = " + maLopHoc;
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void hienThiTatCaLopHoc() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ClassesTB");

            while (resultSet.next()) {
                int maLop = resultSet.getInt("Id");
                String tenLop = resultSet.getString("tenLop");

                System.out.println("Ma lop: " + maLop + " Ten lop: " + tenLop);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public boolean checkLopHoc(int maLopHoc) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ClassesTB");

            while (resultSet.next()) {
                int maLop = resultSet.getInt("Id");
                if (maLop == maLopHoc) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkMaLopHoc(int maLopHoc) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ClassesTB");

            while (resultSet.next()) {
                int maLop = resultSet.getInt("Id");
                if (maLop == maLopHoc) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return false;
    }
}
