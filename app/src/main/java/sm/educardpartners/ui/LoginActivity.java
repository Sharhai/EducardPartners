package sm.educardpartners.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import sm.educardpartners.R;
import sm.educardpartners.network.interactor.LoginInteractor;

public class LoginActivity extends AppCompatActivity implements LoginInteractor.Interaction {

    @BindView(R.id.etName)
    EditText name;
    @BindView(R.id.etPassword)
    EditText pass;
    @BindView(R.id.btn_login)
    Button login;
    @BindView(R.id.tvRegisterHere)
    TextView register;

    private LoginInteractor mLoginInteractor = new LoginInteractor(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        login.setOnClickListener(v -> {
            mLoginInteractor.login(
                    name.getText().toString(),
                    pass.getText().toString()
            );
        });

        register.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
            finish();
        });

    }

    @Override
    public void onError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccesfull() {
        startActivity(new Intent(this, SimpleScannerActivity.class));
        finish();
    }
}
