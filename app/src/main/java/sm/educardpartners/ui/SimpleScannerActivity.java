package sm.educardpartners.ui;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;
import sm.educardpartners.R;

/**
 * Created by winify on 5/11/17.
 */

public class SimpleScannerActivity extends Activity {

    private static final String TAG = "SimpleScannerActivity";


    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_scaner);                // Set the scanner view as the content view
        ButterKnife.bind(this);
    }


}