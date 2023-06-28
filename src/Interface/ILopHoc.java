package Interface;

import entity.LopHoc;

public interface ILopHoc {
    public void themLopHoc(LopHoc lopHoc);
    public void suaLopHoc(int maLopHoc, LopHoc lopHoc);
    public void xoaLopHoc(int maLopHoc);
    public void hienThiTatCaLopHoc();
}
