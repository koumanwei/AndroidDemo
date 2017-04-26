package com.koumanwei.androiddemo.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.JsonObject;
import com.koumanwei.androiddemo.R;
import com.koumanwei.androiddemo.retrofit.api.RequestServices;
import com.koumanwei.androiddemo.retrofit.bean.User;
import com.koumanwei.androiddemo.util.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    private static final String TAG = "RetrofitActivity";
    public static final String URL_BASE = "http://192.168.1.169:8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        getUserInfoByPostMap();
    }

    private void getUserInfo() {
        // 1、获取Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                // Retrofit2 的baseUlr 必须以 /（斜线） 结束
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 2、生成接口的实现类
        RequestServices requestServices = retrofit.create(RequestServices.class);
        // 3、发送请求
        Call<User> call = requestServices.getUserInfo();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Logger.d(TAG, user.getName() + " " + user.getAge());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Logger.d(TAG, "请求出错");
            }
        });
    }

    private void getUserInfoByParam() {
        // 1、获取Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                // Retrofit2 的baseUlr 必须以 /（斜线） 结束
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 2、生成接口的实现类
        RequestServices requestServices = retrofit.create(RequestServices.class);
        // 3、发送请求
        Call<User> call = requestServices.getUserInfoByParam();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Logger.d(TAG, user.getName() + " " + user.getAge());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Logger.d(TAG, "请求出错");
            }
        });
    }

    private void getUserInfoByParamDynamicPath() {
        // 1、获取Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                // Retrofit2 的baseUlr 必须以 /（斜线） 结束
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 2、生成接口的实现类
        RequestServices requestServices = retrofit.create(RequestServices.class);
        // 3、发送请求
        Call<User> call = requestServices.getUserInfoBParamDynamicPath("info");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Logger.d(TAG, user.getName() + " " + user.getAge());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Logger.d(TAG, "请求出错");
            }
        });
    }

    private void getUserInfoBParamDynamicPathAndParam() {
        // 1、获取Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                // Retrofit2 的baseUlr 必须以 /（斜线） 结束
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 2、生成接口的实现类
        RequestServices requestServices = retrofit.create(RequestServices.class);
        // 3、发送请求
        Call<User> call = requestServices.getUserInfoBParamDynamicPathAndParam("info", 34, "man");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Logger.d(TAG, user.getName() + " " + user.getAge());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Logger.d(TAG, "请求出错");
            }
        });
    }

    private void getUserInfoBParamDynamicMap() {
        // 1、获取Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                // Retrofit2 的baseUlr 必须以 /（斜线） 结束
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 2、生成接口的实现类
        RequestServices requestServices = retrofit.create(RequestServices.class);
        // 3、发送请求
        Map<String, Object> map = new HashMap<>();
        map.put("name", "koumanwei");
        map.put("age", 26);
        Call<User> call = requestServices.getUserInfoBParamDynamicMap("info", map);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Logger.d(TAG, user.getName() + " " + user.getAge());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Logger.d(TAG, "请求出错");
            }
        });
    }

    private void getUserInfoString() {
        // 1、获取Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                // Retrofit2 的baseUlr 必须以 /（斜线） 结束
                .baseUrl(URL_BASE)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        // 2、生成接口的实现类
        final RequestServices requestServices = retrofit.create(RequestServices.class);
        // 3、发送请求
        Call<String> call = requestServices.getUserInfoString();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String body = response.body();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void getUserInfoResponseBody() {
        // 1、获取Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                // Retrofit2 的baseUlr 必须以 /（斜线） 结束
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 2、生成接口的实现类
        final RequestServices requestServices = retrofit.create(RequestServices.class);
        // 3、发送请求
        Call<ResponseBody> call = requestServices.getUserInfoResponseBody();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Response<ResponseBody> result = response;
                ResponseBody body = result.body();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void getUserInfoByPost() {
        // 1、获取Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                // Retrofit2 的baseUlr 必须以 /（斜线） 结束
                .baseUrl(URL_BASE)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        // 2、生成接口的实现类
        final RequestServices requestServices = retrofit.create(RequestServices.class);
        // 3、发送请求
        Call<String> call = requestServices.getUserInfoByPost("koumanwei", 26);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String body = response.body();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                String s = t.toString();
            }
        });
    }

    private void getUserInfoByPostMap() {
        // 1、获取Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                // Retrofit2 的baseUlr 必须以 /（斜线） 结束
                .baseUrl(URL_BASE)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        // 2、生成接口的实现类
        final RequestServices requestServices = retrofit.create(RequestServices.class);
        // 3、发送请求
        Map<String, Object> map = new HashMap<>();
        map.put("name", "koumanwei");
        map.put("age", 26);
        Call<String> call = requestServices.getUserInfoByPostMap(map);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String body = response.body();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                String s = t.toString();
            }
        });
    }
}
