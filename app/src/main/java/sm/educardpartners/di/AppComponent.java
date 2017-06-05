package sm.educardpartners.di;


import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import sm.educardpartners.network.EduApi;

@Singleton
@Component(modules = {AppModule.class, DataProviderModule.class})
public interface AppComponent {

    Application getAppContext();

    SharedPreferences getPreferences();

    EduApi getApi();

}
