package sm.educardpartners.di;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    Application app;
    public AppModule(Application app) {
        this.app = app;
    }
    @Provides
    @Singleton
    Application provideApp() {
        return app;
    }
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return app.getApplicationContext().getSharedPreferences("SHARED_PREFS_NAME", Context.MODE_PRIVATE);
    }
}
