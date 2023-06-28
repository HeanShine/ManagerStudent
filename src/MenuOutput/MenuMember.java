package MenuOutput;

import Manager.ManagerClasses;
import Manager.ManagerStudent;
import Manager.ManagerUser;

import java.util.Scanner;

public class MenuMember {
    ManagerUser managerUser;
    ManagerStudent managerStudent;
    ManagerClasses managerClasses;

    public MenuMember() {
        managerUser = new ManagerUser();
        managerStudent = new ManagerStudent();
        managerClasses = new ManagerClasses();
    }

    Scanner scanner = new Scanner(System.in);

    void menuLopHocMember() {
        int choice = -1;
        do {
            System.out.println("=====Quan ly lop hoc=====");
            System.out.println("1. Hien thi tat ca lop hoc");
            System.out.println("0. dang xuat");
            do {
                try {
                    System.out.println("Nhap lua chon cua ban: ");
                    Integer temp = Integer.parseInt(scanner.nextLine());
                    if (temp < 0 || temp > 1) {
                        System.err.println("ban da nhap sai lua chon");
                        break;
                    } else {
                        choice = temp;
                    }
                } catch (Exception e) {
                    System.err.println("Ban dang nhap khong phai so");
                }
            } while (choice < 0 || choice > 1);

            switch (choice) {
                case 1:
                    managerClasses.hienThiTatCaLopHoc();
                    menuHocSinhMember();
                    break;
                case 0:
                    managerUser.logout();
                    break;
                default:
                    System.out.println("Nhap sai, vui long nhap lai!");
                    break;
            }
        } while (choice != 0);
    }

    void menuHocSinhMember() {
        int choice = 0;
        do {
            System.out.println("=====Quan ly hoc sinh=====");
            System.out.println("1. Hien thi tat ca hoc sinh");
            System.out.println("2. Tim kiem hoc sinh thei lop ");
            System.out.println("3. Tim kiem hoc sinh theo ten ");
            System.out.println("0. dang xuat");


            do {
                try {
                    System.out.println("Nhap lua chon cua ban: ");
                    Integer temp = Integer.parseInt(scanner.nextLine());
                    if (temp < 0 || temp > 3) {
                        System.err.println("ban da nhap sai lua chon");
                        break;
                    } else {
                        choice = temp;
                    }
                } catch (Exception e) {
                    System.err.println("Ban dang nhap khong phai so");
                }
            } while (choice < 0 || choice > 3);


            switch (choice) {
                case 1:
                    managerStudent.hienThiTatCaHocSinh();
                    break;
                case 2:
                    int maLopHoc;
                    do {
                        System.out.println("Nhap ma lop hoc can tim kiem: ");
                        maLopHoc = Integer.parseInt(scanner.nextLine());
                        if (managerClasses.checkMaLopHoc(maLopHoc) == false) {
                            System.out.println("Ma lop hoc khong ton tai, vui long nhap lai!");
                            break;
                        }
                    } while (maLopHoc < 0);
                    managerStudent.timKiemHocSinhTheoLop(maLopHoc);
                    break;
                case 3:

                    System.out.println("Nhap ten hoc sinh can tim kiem: ");
                    String tenHocSinh = scanner.nextLine();
                    managerStudent.timKiemHocSinhTheoTen(tenHocSinh);
                    break;
                case 0:
                    managerUser.logout();
                    break;
                default:
                    System.out.println("Nhap sai, vui long nhap lai!");
                    break;
            }
        } while (choice != 0);
    }
}

