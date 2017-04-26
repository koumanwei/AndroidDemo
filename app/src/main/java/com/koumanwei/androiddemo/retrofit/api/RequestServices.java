package com.koumanwei.androiddemo.retrofit.api;

import com.koumanwei.androiddemo.retrofit.bean.User;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by koumanwei on 2017/4/24.
 */

public interface RequestServices {
    // 请求的路径
    @GET("user/info")
    Call<User> getUserInfo();

    // 请求的路径+请求的参数
    @GET("user/info?name=kou&age=28")
    Call<User> getUserInfoByParam();

    // 请求的路径（动态）
    @GET("user/{info}?name=kou&age=28")
    Call<User> getUserInfoBParamDynamicPath(@Path("info") String info);

    // 请求的路径（动态）+ 请求参数（动态）
    @GET("user/{info}")
    Call<User> getUserInfoBParamDynamicPathAndParam(@Path("info") String info, @Query("age") int age, @Query("name") String name);

    // 请求的路径（动态）+ 请求参数（Map）
    @GET("user/{info}")
    Call<User> getUserInfoBParamDynamicMap(@Path("info") String info, @QueryMap Map<String, Object> options);

    // 返回值类型为字符串
    @GET("user/info?name=kou&age=28")
    Call<String> getUserInfoString();

    @GET("user/info?name=kou&age=28")
    Call<ResponseBody> getUserInfoResponseBody();

    // post请求
    @FormUrlEncoded
    @POST("user/info")
    Call<String> getUserInfoByPost(@Field("name") String name, @Field("age") int age);

    // post请求+请求参数（Map）
    @FormUrlEncoded
    @POST("user/info")
    Call<String> getUserInfoByPostMap(@FieldMap Map<String, Object> options);
}
