package Interface;

import entity.HocSinh;

public interface IHocSinh {
    public void themHocSinh(HocSinh hocSinh);
    public void suaHocSinh(int maHocSinh, HocSinh hocSinh);
    public void xoaHocSinh(int maHocSinh);
    public void timKiemHocSinhTheoLop(int maLop);
    public void timKiemHocSinhTheoTen(String tenHocSinh);
    public void hienThiTatCaHocSinh();
}
