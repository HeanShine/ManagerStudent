package entity;

import java.util.Scanner;

public class User {
    private int idUser;
    private String userName;
    private String password;
    private String Role;
    private String createDate;

    public User() {
    }

    public User(int idUser, String userName, String password, String Role, String createDate) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.Role = Role;
        this.createDate = createDate;
    }

// Các getter và setter

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String tenHocSinh) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String tenHocSinh) {
        this.password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String tenHocSinh) {
        this.Role = Role;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String tenHocSinh) {
        this.createDate = createDate;
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap tai khoan nguoi dung :");
        this.userName = scanner.nextLine();

        System.out.println("nhap mat khau nguoi dung :");
        this.password = scanner.nextLine();

        String regex = "^(admin|member)$";
        while (true) {
            System.out.println("nhap vai tro nguoi dung :");
            this.Role = scanner.nextLine();
            if (this.Role.matches(regex)) {
                break;
            }
            System.out.println("vai tro khong hop le");
        }
    }
}
