package vn.phamthang.phamthang_hw_day06.interfaces.interface_login;

import vn.phamthang.phamthang_hw_day06.models.UserModel;

public interface ILoginView {
    void login(String username,String password);
    void onLoginSucces(UserModel model);
    void onLoginError(String error);
}
