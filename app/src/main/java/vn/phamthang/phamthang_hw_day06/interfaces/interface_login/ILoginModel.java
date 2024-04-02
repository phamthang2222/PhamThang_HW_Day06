package vn.phamthang.phamthang_hw_day06.interfaces.interface_login;

import vn.phamthang.phamthang_hw_day06.models.UserModel;

public interface ILoginModel {

    void loginSucces(UserModel model);
    void loginError(String error);
}
