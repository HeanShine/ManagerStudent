package MenuOutput;

import Manager.ManagerClasses;
import Manager.ManagerStudent;
import Manager.ManagerUser;
import entity.HocSinh;
import entity.LopHoc;

import java.util.Scanner;

public class MenuAdmin {
    ManagerUser managerUser;
    ManagerStudent managerStudent;
    ManagerClasses managerClasses;

    public MenuAdmin() {
        managerUser = new ManagerUser();
        managerStudent = new ManagerStudent();
        managerClasses = new ManagerClasses();
    }

    Scanner scanner = new Scanner(System.in);

    void menuLopHocAdmin() {
        int choice = -1;
        do {
            System.out.println("=====Quan ly lop hoc=====");
            System.out.println("1. Them lop hoc");
            System.out.println("2. Sua lop hoc");
            System.out.println("3. Xoa lop hoc");
            System.out.println("4. Hien thi tat ca lop hoc");
            System.out.println("0. dang xuat");
            do {
                try {
                    System.out.println("Nhap lua chon cua ban: ");
                    Integer temp = Integer.parseInt(scanner.nextLine());
                    if (temp < 0 || temp > 4) {
                        System.err.println("ban da nhap sai lua chon");
                        break;
                    } else {
                        choice = temp;
                    }
                } catch (Exception e) {
                    System.err.println("Ban dang nhap khong phai so");
                }
            } while (choice < 0 || choice > 4);

            switch (choice) {
                case 1:
                    LopHoc lopHoc = new LopHoc();
                    lopHoc.nhapThongTin();
                    managerClasses.themLopHoc(lopHoc);
                    break;
                case 2:
                    int maLopHocCanSua = -1;
                    while (maLopHocCanSua < 0) {
                        try {
                            System.out.println("Nhap ma lop hoc can sua: ");
                            maLopHocCanSua = Integer.parseInt(scanner.nextLine());
                            if (managerClasses.checkLopHoc(maLopHocCanSua) == false) {
                                System.err.println("Ma lop hoc khong ton tai !");
                            }
                        } catch (Exception e) {
                            System.err.println("Ban dang nhap khong phai so !");
                        }
                    }
                    LopHoc lopHoc1 = new LopHoc();
                    lopHoc1.nhapThongTin();
                    managerClasses.suaLopHoc(maLopHocCanSua, lopHoc1);
                    break;
                case 3:
                    int maLopHocCanXoa = -1;
                    while (maLopHocCanXoa < 0) {
                        try {
                            System.out.println("Nhap ma lop hoc can xoa: ");
                            maLopHocCanXoa = Integer.parseInt(scanner.nextLine());
                            if (managerClasses.checkLopHoc(maLopHocCanXoa) == false) {
                                System.err.println("Ma lop hoc khong ton tai !");
                            }
                        } catch (Exception e) {
                            System.err.println("Ban dang nhap khong phai so !");
                        }
                    }
                    managerClasses.xoaLopHoc(maLopHocCanXoa);
                    break;
                case 4:
                    managerClasses.hienThiTatCaLopHoc();
                    menuHocSinhAdmin();
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

    void menuHocSinhAdmin() {
        int choice = -1;
        do {
            System.out.println("=====Quan ly hoc sinh=====");
            System.out.println("1. Them hoc sinh");
            System.out.println("2. Sua hoc sinh");
            System.out.println("3. Xoa hoc sinh");
            System.out.println("4. Hien thi tat ca hoc sinh");
            System.out.println("5. Tim kiem hoc sinh thei lop ");
            System.out.println("6. Tim kiem hoc sinh theo ten ");
            System.out.println("0. dang xuat");

            do {
                try {
                    System.out.println("Nhap lua chon cua ban: ");
                    Integer temp = Integer.parseInt(scanner.nextLine());
                    if (temp < 0 || temp > 6) {
                        System.err.println("ban da nhap sai lua chon");
                        break;
                    } else {
                        choice = temp;
                    }
                } catch (Exception e) {
                    System.err.println("Ban dang nhap khong phai so");
                }
            } while (choice < 0 || choice > 6);

            switch (choice) {
                case 1:
                    HocSinh hocSinh = new HocSinh();
                    hocSinh.nhapThongTin();
                    managerStudent.themHocSinh(hocSinh);
                    break;
                case 2:
                    int maHocSinhCanSua = -1;
                    while (maHocSinhCanSua < 0) {
                        try {
                            System.out.println("Nhap ma hoc sinh can sua: ");
                            maHocSinhCanSua = Integer.parseInt(scanner.nextLine());
                            if (managerStudent.checkLopHoc(maHocSinhCanSua) == false) {
                                System.err.println("Ma hoc sinh khong ton tai !");
                                return;
                            }
                        } catch (Exception e) {
                            System.err.println("Ban dang nhap khong phai so !");
                        }
                    }

                    HocSinh hocSinh1 = new HocSinh();
                    hocSinh1.nhapThongTin();
                    managerStudent.suaHocSinh(maHocSinhCanSua, hocSinh1);
                    break;
                case 3:
                    int maHocSinhCanXoa = -1;
                    while (maHocSinhCanXoa < 0) {
                        try {
                            System.out.println("Nhap ma hoc sinh can xoa: ");
                            maHocSinhCanXoa = Integer.parseInt(scanner.nextLine());
                            if (managerStudent.checkLopHoc(maHocSinhCanXoa) == false) {
                                System.err.println("Ma hoc sinh khong ton tai !");
                                return;
                            }
                        } catch (Exception e) {
                            System.err.println("Ban dang nhap khong phai so !");
                        }
                    }
                    int maHocSinh1 = scanner.nextInt();
                    managerStudent.xoaHocSinh(maHocSinh1);
                    break;
                case 4:
                    managerStudent.hienThiTatCaHocSinh();
                    break;
                case 5:
                    int maLopHoc = -1;
                    while (maLopHoc < 0) {
                        try {
                            System.out.println("Nhap ma lop hoc can tim kiem: ");
                            maLopHoc = Integer.parseInt(scanner.nextLine());
                            if (managerClasses.checkLopHoc(maLopHoc) == false) {
                                System.err.println("Ma lop hoc khong ton tai !");
                                return;
                            }
                        } catch (Exception e) {
                            System.err.println("Ban dang nhap khong phai so !");
                        }
                    }
                    managerStudent.timKiemHocSinhTheoLop(maLopHoc);
                    break;
                case 6:
                    scanner.nextLine();
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
