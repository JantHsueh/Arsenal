package cn.xuexuan.newui.model.http;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.xuexuan.newui.BuildConfig;
import cn.xuexuan.newui.app.Constants;
import cn.xuexuan.newui.model.bean.DailyBeforeListBean;
import cn.xuexuan.newui.model.bean.DailyListBean;
import cn.xuexuan.newui.model.bean.ZhiHuDetailBean;
import cn.xuexuan.newui.model.http.api.ZhiHuApis;
import cn.xuexuan.newui.util.SystemUtil;
import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jant on 2017/4/17.
 */

public class RetrofitHelper {

    private static OkHttpClient sOkHttpClient = null;
    private static ZhiHuApis sZhiHuApiService = null;


    public RetrofitHelper() {

        initOkHttp();
        sZhiHuApiService = getApiService(ZhiHuApis.HOST, ZhiHuApis.class);

    }

    private static void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            // https://drakeet.me/retrofit-2-0-okhttp-3-0-config
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        // http://www.jianshu.com/p/93153b34310e
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtil.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
//        Interceptor apikey = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                request = request.newBuilder()
//                        .addHeader("apikey",Constants.KEY_API)
//                        .build();
//                return chain.proceed(request);
//            }
//        }
//        设置统一的请求头部参数
//        builder.addInterceptor(apikey);
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        sOkHttpClient = builder.build();
    }

    private <T> T getApiService(String baseUrl, Class<T> clz) {

        Retrofit lRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(sOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return lRetrofit.create(clz);

    }

    public Observable<DailyBeforeListBean> fetchDailyBeforeListInfo(String date) {
        return sZhiHuApiService.getDailyBeforeList(date);
    }


    public Observable<DailyListBean> fetchDailyListInfo() {
        return sZhiHuApiService.getDailyList();
    }


    public Observable<ZhiHuDetailBean> fetchZhiHuDetail(long id) {
        return sZhiHuApiService.getDetailInfo(id);
    }

    public Observable<String> getNewsDetailCss(String url) {

        return sZhiHuApiService.getNewsDetailCss(url);
    }

}
