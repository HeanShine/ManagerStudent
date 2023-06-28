package MenuOutput;

import Manager.ManagerClasses;
import Manager.ManagerStudent;
import Manager.ManagerUser;
import entity.User;

import java.util.Scanner;

public class ManagerCommon {
    ManagerStudent managerStudent;
    ManagerClasses managerClasses;
    ManagerUser managerUser;
    MenuAdmin menuAdmin;
    MenuMember menuMember;
    Scanner scanner = new Scanner(System.in);
    User user;

    public ManagerCommon() {
        managerStudent = new ManagerStudent();
        managerClasses = new ManagerClasses();
        managerUser = new ManagerUser();
        menuAdmin = new MenuAdmin();
        menuMember = new MenuMember();
        user = new User();
    }

    public void menuManager() {
        int choice = -1;
        do {
            System.out.println("=====Quan ly hoc sinh=====");
            System.out.println("1. Dang ky");
            System.out.println("2. Dang nhap");
            System.out.println("3. Sua thong tin user ");
            System.out.println("4. Xoa user ");
            System.out.println("5. Hien thi tat ca user ");
            System.out.println("0. Thoat");

            do {
                try {
                    System.out.println("Nhap lua chon cua ban: ");
                    Integer temp = Integer.parseInt(scanner.nextLine());
                    if (temp < 0 || temp > 5) {
                        System.err.println("ban da nhap sai lua chon");
                    } else {
                        choice = temp;
                    }
                } catch (Exception e) {
                    System.err.println("Ban dang nhap khong phai so");
                }
            } while (choice < 0 || choice > 5);

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    int taiKhoanSua = -1;
                    while (taiKhoanSua == -1) {
                        try {
                            System.out.println("Nhap tai khoan can sua: ");
                            taiKhoanSua = Integer.parseInt(scanner.nextLine());
                            if (managerUser.checkUser(taiKhoanSua) == false) {
                                System.err.println("Tai khoan khong ton tai");
                            }
                        } catch (Exception e) {
                            System.err.println("Ban dang nhap khong phai so");
                        }
                    }
                    User user = new User();
                    user.nhapThongTin();
                    managerUser.suaUser(taiKhoanSua, user);
                    break;
                case 4:
                    int taiKhoanXoa = -1;
                    while (taiKhoanXoa == -1) {
                        try {
                            System.out.println("Nhap tai khoan can xoa: ");
                            taiKhoanXoa = Integer.parseInt(scanner.nextLine());
                            if (managerUser.checkUser(taiKhoanXoa) == false) {
                                System.err.println("Tai khoan khong ton tai");
                            }
                        } catch (Exception e) {
                            System.err.println("Ban dang nhap khong phai so");
                        }
                    }
                    managerUser.xoaUser(taiKhoanXoa);
                    break;
                case 5:
                    managerUser.hienThiTatCaUser();
                    break;
                case 0:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Nhap sai, vui long nhap lai!");
                    break;
            }
        } while (choice != 0);
    }

    void register() {
        User user = new User();
        user.nhapThongTin();
        managerUser.themUser(user);
    }

    void login() {
        System.out.println("nhap tai khoan :");
        String taiKhoan = scanner.nextLine();
        System.out.println("nhap mat khau :");
        String matKhau = scanner.nextLine();

        boolean res = managerUser.login(taiKhoan, matKhau);
        if (!res) {
            System.out.println("Dang nhap that bai!");
        } else {
            if (managerUser.checkAdmin(taiKhoan, matKhau)) {
                menuAdmin.menuLopHocAdmin();
            } else {
                System.out.println("show menu user");
                menuMember.menuLopHocMember();
            }
        }
    }

}

