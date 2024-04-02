package vn.phamthang.phamthang_hw_day06.interfaces.interface_register;

import vn.phamthang.phamthang_hw_day06.models.UserModel;

public interface IRegisterView {
    void register(UserModel model);
    void onRegisError(String error);
    void onRegisSuccess(UserModel model);
}
