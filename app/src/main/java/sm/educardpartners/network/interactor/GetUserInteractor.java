package sm.educardpartners.network.interactor;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sm.educardpartners.App;
import sm.educardpartners.models.User;

/**
 * Created by dsdmsa on 4/30/17.
 */

public class GetUserInteractor {

    private Interaction mInteraction;

    public GetUserInteractor(Interaction mInteraction) {
        this.mInteraction = mInteraction;
    }

    public void getUser(String id) {
        Log.d("TAG", id);
        App.getAppComponent()
                .getApi()
                .getUser(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(respomnse -> {
        Log.d("TAG", "respo");
                    mInteraction.onUserGetSuccesful(respomnse.body());
                }, error -> {
        Log.d("TAG", "err"+error.getMessage());
        Log.d("TAG", "err"+error.getCause());
                    mInteraction.onError("Error : " + error);
                });
    }

    public interface Interaction {

        void onError(String errorMsg);

        void onUserGetSuccesful(User user);
    }

}
