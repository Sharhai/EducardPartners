package sm.educardpartners.network.interactor;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sm.educardpartners.App;

/**
 * Created by dsdmsa on 4/30/17.
 */

public class RegisterInteractor {

    private Interaction mInteraction;

    public RegisterInteractor(Interaction mInteraction) {
        this.mInteraction = mInteraction;
    }

    public void register(String name, String pas,String email) {
        App.getAppComponent()
                .getApi()
                .register(name, pas, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(registerResponse -> {
                    mInteraction.onRegistrationSuccesfull();
                }, error -> {
                    mInteraction.onError("Error : " + error);
                });
    }

    public interface Interaction {

        void onError(String errorMsg);

        void onRegistrationSuccesfull();
    }

}
