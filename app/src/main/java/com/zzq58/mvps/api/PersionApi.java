package com.zzq58.mvps.api;

import com.zzq58.mvps.bean.IpBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PersionApi {

    @FormUrlEncoded
    @POST("LoginServlet")
    Observable<String> doLogin(@FieldMap Map<String, Object> map);

    @POST("v1/IpServlet")
    Observable<IpBean> doWebMsg();

}
