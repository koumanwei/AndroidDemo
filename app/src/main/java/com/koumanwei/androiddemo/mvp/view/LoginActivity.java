package com.koumanwei.androiddemo.mvp.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.koumanwei.androiddemo.MainActivity;
import com.koumanwei.androiddemo.R;
import com.koumanwei.androiddemo.mvp.bean.User;
import com.koumanwei.androiddemo.mvp.presenter.LoginPresenter;
import com.koumanwei.androiddemo.mvp.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_clear_password)
    Button btnClearPassword;
    private ProgressDialog progressDialog;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initListener();
        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void initListener() {
        // 清除密码
        btnClearPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clearUsernameAndPassword();
            }
        });
        // 登陆
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });
    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void clearUsername() {
        etUsername.setText("");
    }

    @Override
    public void clearPassword() {
        etPassword.setText("");
    }

    @Override
    public void showLoading() {
        progressDialog = ProgressDialog.show(this, null, "正在登陆中...");
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
    }
}
