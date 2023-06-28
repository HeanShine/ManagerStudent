package entity;

import Manager.ManagerClasses;
import connectJDBC.ConnectJDBC;

import java.util.Scanner;

public class HocSinh extends ConnectJDBC {
    private int maHocSinh;
    private String tenHocSinh;
    private int tuoi;
    private int maLop;

    public HocSinh() {
    }

    public HocSinh(int maHocSinh, String tenHocSinh, int tuoi, int maLop) {
        this.maHocSinh = maHocSinh;
        this.tenHocSinh = tenHocSinh;
        this.tuoi = tuoi;
        this.maLop = maLop;
    }

    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public int getTuoi() {
        return tuoi;
    }


    public int getMaLop() {
        return maLop;
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten hoc sinh: ");
        this.tenHocSinh = scanner.nextLine();

        this.tuoi = -1;
        while (this.tuoi == -1) {
            try {
                System.out.println("nhap so tuoi hoc sinh");
                Integer temp = Integer.parseInt(scanner.nextLine());
                if (temp < 14 || temp > 18) {
                    System.err.println("ban da nhap duoi so tuoi");
                } else {
                    this.tuoi = temp;
                }
            } catch (Exception e) {
                System.err.println("Ban dang nhap khong phai so");
            }
        }

        ManagerClasses managerClasses = new ManagerClasses();
        this.maLop = -1;
        while (this.maLop == -1) {
            try {
                System.out.println("nhap ma lop hoc sinh");
                Integer temp = Integer.parseInt(scanner.nextLine());
                if (temp <= 0) {
                    System.err.println("ban da nhap duoi so tuoi");
                } else if (managerClasses.checkLopHoc(temp) == false) {
                    System.err.println("ma lop khong ton tai");
                } else {
                    this.maLop = temp;
                }
            } catch (Exception e) {
                System.err.println("Ban dang nhap khong phai so");
            }
        }
    }
}
