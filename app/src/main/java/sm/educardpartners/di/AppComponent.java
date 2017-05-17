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

//    ProfileRepository getProfileRepository();
//
//    void inject(SingInActivityPresenter __);
//
//    void inject(RegisterActivityPresenter __);
//
//    void inject(MapFragmentPresenter __);
//
//    void inject(ChatRoomFragmentPresenter __);
//
//    void inject(TimeLinePresenter __);
//
//    void inject(MainActivityPresenter __);
//
//    void inject(SearchResultActivityPresenter __);

//    void inject(SocialTwistApiInteractor __);
}
