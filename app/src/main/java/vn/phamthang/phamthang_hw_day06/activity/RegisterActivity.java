package vn.phamthang.phamthang_hw_day06.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import vn.phamthang.phamthang_hw_day06.R;
import vn.phamthang.phamthang_hw_day06.interfaces.interface_register.IRegisterView;
import vn.phamthang.phamthang_hw_day06.models.UserModel;
import vn.phamthang.phamthang_hw_day06.presenter.RegisterPresenter;
import vn.phamthang.phamthang_hw_day06.utils.PrefManagement;

public class RegisterActivity extends AppCompatActivity implements IRegisterView {
    private EditText edtUsername,edtPassword,edtEmail,edtPhone;
    private TextView tvLogin;
    private Button btnSignUp;
    private RegisterPresenter registerPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        registerPresenter = new RegisterPresenter(this);

    }

    private void initView() {
        edtUsername = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        tvLogin = findViewById(R.id.tvLogin);
        btnSignUp = findViewById(R.id.btSignUp);

        tvLogin.setOnClickListener(v -> {
            finish();
        });
        btnSignUp.setOnClickListener(v -> {
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();
            String email = edtEmail.getText().toString();
            String phone = edtPhone.getText().toString();

            UserModel newUser = new UserModel();

            newUser.setUsername(username);
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setPhone(phone);

            register(newUser);


            finish();
        });
    }

    @Override
    public void register(UserModel model) {
        registerPresenter.addUser(model);
    }

    @Override
    public void onRegisError(String error) {
        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisSuccess(UserModel model) {
        Toast.makeText(this,"Đăng kí thành công", Toast.LENGTH_SHORT).show();

    }


}