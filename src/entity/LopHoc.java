package entity;

import java.util.Scanner;

public class LopHoc {
    private int maLop;
    private String tenLop;

    public LopHoc() {
    }

    public LopHoc(int maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap ten lop: ");
        this.tenLop = scanner.nextLine();
    }
}
