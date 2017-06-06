package sm.educardpartners.di;


import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import sm.educardpartners.network.EduApi;
import sm.educardpartners.network.HeadersInterceptor;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static sm.educardpartners.utils.Constants.ENDPOINT;

@Module
public class DataProviderModule {

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(){
        return  new OkHttpClient.Builder()
                .addNetworkInterceptor(new HeadersInterceptor())
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(BODY))
                .build();
    }

    @Singleton
    @Provides
    public Retrofit.Builder provideBuilder(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }


    @Provides
    public EduApi provideSocialTwistServices(Retrofit.Builder builder){
        return builder.baseUrl("http://"+ENDPOINT+":1161/").build().create(EduApi.class);
    }

}
