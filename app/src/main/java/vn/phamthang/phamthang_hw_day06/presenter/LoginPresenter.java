package vn.phamthang.phamthang_hw_day06.presenter;

import vn.phamthang.phamthang_hw_day06.interfaces.interface_login.ILoginModel;
import vn.phamthang.phamthang_hw_day06.interfaces.interface_login.ILoginView;
import vn.phamthang.phamthang_hw_day06.models.Database;
import vn.phamthang.phamthang_hw_day06.models.UserModel;

public class LoginPresenter implements ILoginModel {
    private ILoginView iLoginView;
    private Database database;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        database = Database.getInstance();
        database.setiLoginModel(this);

    }

    public void login(String username,String password){
        database.checkAuthentication(username,password);
    }
    @Override
    public void loginSucces(UserModel model) {
        iLoginView.onLoginSucces(model);
    }

    @Override
    public void loginError(String error) {
        iLoginView.onLoginError(error);

    }
}
