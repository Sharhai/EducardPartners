//package sm.educardpartners.network.interactor;
//
//import java.util.ArrayList;
//
//import dsdmsa.socialtwist.models.SearchResult;
//import dsdmsa.socialtwist.utils.StatusCodeUtils;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//
///**
// * Created by dsdmsa on 4/30/17.
// */
//
//public class SearchInteractor extends SocialTwistApiInteractor<SearchInteractor.Interaction>{
//
//    public SearchInteractor(Interaction interaction) {
//        super(interaction);
//    }
//
//    public void search(String key) {
//        api.searchUser(key)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(registerResponse -> {
//                    switch (StatusCodeUtils.getGeneralStatus(registerResponse.code())) {
//                        case Success:
//                            interactor.onSuccess(registerResponse.body());
//                            break;
//                        case ServerError:
//                            break;
//                        case ClientError:
//                            break;
//                        case Informational:
//                            break;
//                        case Redirection:
//                            break;
//                    }
//                }, error -> {
//                    interactor.onError(error.getCause().getLocalizedMessage());
//                });
//    }
//
//    public interface Interaction {
//
//        void onError(String errorMsg);
//
//        void onSuccess(ArrayList<SearchResult> body);
//    }
//
//}
