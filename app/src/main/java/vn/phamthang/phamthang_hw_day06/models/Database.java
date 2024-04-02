package vn.phamthang.phamthang_hw_day06.models;

import java.util.ArrayList;

import vn.phamthang.phamthang_hw_day06.interfaces.interface_login.ILoginModel;
import vn.phamthang.phamthang_hw_day06.interfaces.interface_register.IRegisterModel;

public class Database {
    private ArrayList<UserModel> mListUser = new ArrayList<>();
    private static Database intances;
    private ILoginModel iLoginModel;
    private IRegisterModel iRegisterModel;

    public void setiLoginModel(ILoginModel iLoginModel) {
        this.iLoginModel = iLoginModel;
    }

    public void setiRegisterModel(IRegisterModel iRegisterModel) {
        this.iRegisterModel = iRegisterModel;
    }

    public static Database getInstance() {
        if (intances == null) {
            intances = new Database();
        }
        return intances;
    }

    public boolean isUserExited(String username) {
        for (UserModel userModel : mListUser) {
            if (userModel.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmailExited(String email) {
        for (UserModel userModel : mListUser) {
            if (userModel.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void register(UserModel model) {
        if (isUserExited(model.getUsername())) {
            iRegisterModel.onRegisError("Ten dang nhap da ton tai");
        }else{
            mListUser.add(model);
            iRegisterModel.onRegisSucces(model);
        }
    }

    public void checkAuthentication(String username, String password) {
        if (isUserExited(username)) {
            for (UserModel model : mListUser) {
                if (model.getUsername().equals(username)&&password.equals(model.getPassword())){
                    iLoginModel.loginSucces(model);
                    return;
                }
            }
            iLoginModel.loginError("Sai ten dang nhap hoac mat khau");
        }else {
            iLoginModel.loginError("Tai khoan chua duoc dang ki");
        }
    }

}
