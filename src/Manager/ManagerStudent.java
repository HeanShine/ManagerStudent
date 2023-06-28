package Manager;

import Interface.IHocSinh;
import connectJDBC.ConnectJDBC;
import entity.HocSinh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerStudent extends ConnectJDBC implements IHocSinh {

    public void createTableHocSinh() {
        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE StudentTB ("
                    + "maLop INT(11) NOT NULL AUTO_INCREMENT,"
                    + "tenLop VARCHAR(255) NOT NULL,"
                    + "PRIMARY KEY (maLop))";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void themHocSinh(HocSinh hocSinh) {
        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "INSERT INTO StudentTB (TenHocSinh, Tuoi, LopHocID) VALUES " +
                    "(\"" + hocSinh.getTenHocSinh()
                    + "\", " + hocSinh.getTuoi()
                    + ", " + hocSinh.getMaLop() + ")";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void suaHocSinh(int maHocSinh, HocSinh hocSinh) {
        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "UPDATE StudentTB SET TenHocSinh = \"" + hocSinh.getTenHocSinh()
                    + "\", Tuoi = " + hocSinh.getTuoi()
                    + ", LopHocID = " + hocSinh.getMaLop()
                    + " WHERE idHocSinh = " + maHocSinh;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void xoaHocSinh(int maHocSinh) {
        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "DELETE FROM StudentTB WHERE idHocSinh = " + maHocSinh;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }


    @Override
    public void hienThiTatCaHocSinh() {
        Connection connection = getConnection();
        Statement statement = null; // thuc thi cau lenh sql
        ResultSet resultSet = null;
        try {

            statement = connection.createStatement(); // tao ra 1 doi tuong de thuc thi cau lenh sql
            String sql = "SELECT * FROM StudentTB";
            resultSet = statement.executeQuery(sql);
            // thuc thi cau lenh sql va tra ve 1 doi tuong resultSet
            while (resultSet.next()) {
                int maHocSinh = resultSet.getInt("IdHocSinh");
                String tenHocSinh = resultSet.getString("TenHocSinh");
                int tuoi = resultSet.getInt("Tuoi");
                int maLop = resultSet.getInt("LopHocID");

                System.out.println("Ma hoc sinh: " + maHocSinh);
                System.out.println("Ten hoc sinh: " + tenHocSinh);
                System.out.println("Tuoi: " + tuoi);
                System.out.println("Ma lop: " + maLop);
                System.out.println("====================================");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void timKiemHocSinhTheoLop(int maLopNhapVao) {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT StudentTB.*, ClassesTB.TenLop from ClassesTB INNER JOIN " +
                    "StudentTB On StudentTB.LopHocID = ClassesTB.Id where Id = " + maLopNhapVao;

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int maHocSinh = resultSet.getInt("IdHocSinh");
                String tenHocSinh = resultSet.getString("TenHocSinh");
                int tuoi = resultSet.getInt("Tuoi");
                String tenLop = resultSet.getString("TenLop");

                System.out.println("Ma hoc sinh: " + maHocSinh);
                System.out.println("Ten hoc sinh: " + tenHocSinh);
                System.out.println("Tuoi: " + tuoi);
                System.out.println("Ten lop: " + tenLop);
                System.out.println("====================================");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    // tim kiem hoc sinh theo ten gan giong dung upper va join 2 bang de lay du lieu ten lop
    // SELECT StudentTB.*, ClassesTB.TenLop from ClassesTB INNER JOIN StudentTB On StudentTB.LopHocID = ClassesTB.Id where TenHocSinh like '%a%' and TenLop = 'Lop 1'
    @Override
    public void timKiemHocSinhTheoTen(String tenHocSinh) {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT StudentTB.*, ClassesTB.TenLop from ClassesTB INNER JOIN " +
                    "StudentTB On StudentTB.LopHocID = ClassesTB.Id where TenHocSinh like '%" + tenHocSinh + "%'";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int maHocSinh = resultSet.getInt("IdHocSinh");
                String tenHocSinh1 = resultSet.getString("TenHocSinh");
                int tuoi = resultSet.getInt("Tuoi");
                String tenLop = resultSet.getString("TenLop");

                System.out.println("Ma hoc sinh: " + maHocSinh);
                System.out.println("Ten hoc sinh: " + tenHocSinh1);
                System.out.println("Tuoi: " + tuoi);
                System.out.println("Ten lop: " + tenLop);
                System.out.println("====================================");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    public boolean checkLopHoc(int idHocSinh) {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM StudentTB WHERE IdHocSinh = " + idHocSinh;
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return false;
    }
}