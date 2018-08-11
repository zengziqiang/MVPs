package com.zzq58.mvps.network;

import com.zzq58.mvps.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Author: iszengziqiang@163.com
 * @Date: 2018/8/7 上午10:50
 * @Desc: 网络请求工具类string解析器
 **/

public class RetrofitManager {

    private Retrofit mRetrofit;

    public RetrofitManager() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_PATH)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())//添加sting解析器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava适配器
                .build();
    }

    public static RetrofitManager mRetrofitManager;

    public static RetrofitManager getInstance() {
        if (mRetrofitManager == null) {
            synchronized (Object.class) {
                if (mRetrofitManager == null) {
                    mRetrofitManager = new RetrofitManager();
                }
            }
        }
        return mRetrofitManager;
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

}
