package vn.phamthang.phamthang_hw_day06.presenter;

import vn.phamthang.phamthang_hw_day06.interfaces.interface_register.IRegisterModel;
import vn.phamthang.phamthang_hw_day06.interfaces.interface_register.IRegisterView;
import vn.phamthang.phamthang_hw_day06.models.Database;
import vn.phamthang.phamthang_hw_day06.models.UserModel;

public class RegisterPresenter implements IRegisterModel{
    private IRegisterView iRegisterView;
    private Database database;

    public RegisterPresenter(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
        database = Database.getInstance();
        database.setiRegisterModel(this);
    }
    @Override
    public void addUser(UserModel user) {
        database.register(user);
    }
    @Override
    public void onRegisSucces(UserModel model) {
        iRegisterView.onRegisSucces(model);
    }

    @Override
    public void onRegisError(String error) {
        iRegisterView.onRegisError(error);
    }



}
