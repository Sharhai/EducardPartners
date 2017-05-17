package sm.educardpartners.network.interactor;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sm.educardpartners.App;

/**
 * Created by dsdmsa on 4/30/17.
 */

public class LoginInteractor {

    private Interaction mInteraction;

    public LoginInteractor(Interaction mInteraction) {
        this.mInteraction = mInteraction;
    }

    public void login(String name, String pas) {
        App.getAppComponent()
                .getApi()
                .login(name, pas)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(registerResponse -> {
                    mInteraction.onLoginSuccesfull();
                }, error -> {
                    mInteraction.onError("Error : " + error);
                });
    }

    public interface Interaction {

        void onError(String errorMsg);

        void onLoginSuccesfull();
    }

}
