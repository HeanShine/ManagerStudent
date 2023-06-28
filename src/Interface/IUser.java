package Interface;

import entity.User;

public interface IUser {
    public void themUser(User user);

    public void suaUser(int idUser, User user);
    public void xoaUser(int idUser);
    public void hienThiTatCaUser();
    public boolean login(String userName, String password);

}
