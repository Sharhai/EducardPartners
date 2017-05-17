package sm.educardpartners.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class HeadersInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder request = original.newBuilder();
//        request.addHeader("Content-Type", "application/x-www-form-urlencoded");
        request.method(original.method(), original.body());
        return chain.proceed(request.build());
    }
}