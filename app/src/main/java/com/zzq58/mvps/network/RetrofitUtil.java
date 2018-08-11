package com.zzq58.mvps.network;

import com.zzq58.mvps.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: iszengziqiang@163.com
 * @Date: 2018/8/7 上午11:30
 * @Desc: 网络请求对象解析器
 **/

public class RetrofitUtil {

    private Retrofit mRetrofit;

    public RetrofitUtil() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_PATH)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())//添加sting解析器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava适配器
                .build();
    }

    public static RetrofitUtil mRetrofitUtil;

    public static RetrofitUtil getInstance() {
        if (mRetrofitUtil == null) {
            synchronized (Object.class) {
                if (mRetrofitUtil == null) {
                    mRetrofitUtil = new RetrofitUtil();
                }
            }
        }
        return mRetrofitUtil;
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

}
