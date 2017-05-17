package sm.educardpartners.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sm.educardpartners.R;

public class EduPArt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_part);
        startActivity(new Intent(this,SimpleScannerActivity.class));
        finish();
    }
}
