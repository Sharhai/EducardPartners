package sm.educardpartners.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import sm.educardpartners.R;
import sm.educardpartners.network.interactor.RegisterInteractor;

public class RegisterActivity extends AppCompatActivity implements
        RegisterInteractor.Interaction {

    @BindView(R.id.et_email)
    EditText email;
    @BindView(R.id.et_name)
    EditText name;
    @BindView(R.id.et_pas)
    EditText pass;
    @BindView(R.id.et_repeat_pas)
    EditText rPass;
    @BindView(R.id.btn_reg)
    Button reg;
    @BindView(R.id.tv_bak)
    TextView back;

    private RegisterInteractor mRegisterInteractor = new RegisterInteractor(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        reg.setOnClickListener(v -> {
            mRegisterInteractor.register(
                    name.getText().toString(),
                    pass.getText().toString(),
                    email.getText().toString()
            );
        });

        back.setOnClickListener(v -> {
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        });
    }

    @Override
    public void onError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegistrationSuccesfull() {
        startActivity(new Intent(this,SimpleScannerActivity.class));
        finish();
    }
}
