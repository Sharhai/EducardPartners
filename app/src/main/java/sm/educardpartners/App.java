package sm.educardpartners;


import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import butterknife.ButterKnife;
import sm.educardpartners.di.AppComponent;
import sm.educardpartners.di.AppModule;
import sm.educardpartners.di.DaggerAppComponent;
import sm.educardpartners.di.DataProviderModule;

public class App extends Application {
    private static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .dataProviderModule(new DataProviderModule())
                .appModule(new AppModule(this))
                .build();
        if (BuildConfig.DEBUG) {
            ButterKnife.setDebug(BuildConfig.DEBUG);
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return;
            }
            LeakCanary.install(this);
        }
    }
    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
