package vn.phamthang.phamthang_hw_day06.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import vn.phamthang.phamthang_hw_day06.R;
import vn.phamthang.phamthang_hw_day06.interfaces.interface_login.ILoginView;
import vn.phamthang.phamthang_hw_day06.models.UserModel;
import vn.phamthang.phamthang_hw_day06.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView{
    private EditText edtUsername, edtPassword;
    private TextView tvRegister;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        loginPresenter =new LoginPresenter(this);
    }

    private void initView() {
        edtUsername = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        tvRegister = findViewById(R.id.tvRegis);
        btnLogin = findViewById(R.id.btLogin);

        btnLogin.setOnClickListener(v -> {
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            login(username,password);
        });
        tvRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }


    @Override
    public void login(String username, String password) {
        loginPresenter.login(username,password);
    }

    @Override
    public void onLoginSucces(UserModel model) {
        Toast.makeText(this, "Login Success",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String error) {
        Toast.makeText(this, "Login Fail "+error,Toast.LENGTH_SHORT).show();
    }
}