package com.example.admin.abcfashions.WebService;

import android.util.Log;

import com.example.admin.abcfashions.WebService.pojo.Marker;
import com.example.admin.abcfashions.WebService.pojo.Reg_User;
import com.example.admin.abcfashions.WebService.pojo.TransactionEvent;
import com.example.admin.abcfashions.WebService.pojo.User;

import java.util.List;

import de.greenrobot.event.EventBus;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 12/16/17.
 */

public class Communicator {
    private static final String TAG = "Communicator";
    private static final String SERVER_URL = "http://192.168.1.2/";
    private Interface service;

    public void loginPost(String username, String password) {

        rectroConnection();
        Call<User> login = service.post(username, password);
        login.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //     BusProvider.getInstance().post(new LoginEvent(response.body()));
                Log.e("response", response.body().getEmail().toString());
                EventBus.getDefault().post(new LoginEvent(response.body()));

                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // handle execution failures like no internet connectivity
                //   BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });

    }
    public void sentItems(TransactionEvent transactionEvent) {

        rectroConnection();
        Call<Reg_User> login = service.submit_items(transactionEvent);
        login.enqueue(new Callback<Reg_User>() {
            @Override
            public void onResponse(Call<Reg_User> call, Response<Reg_User> response) {
                //     BusProvider.getInstance().post(new LoginEvent(response.body()));
                Log.e("response", response.body().getResult());
                EventBus.getDefault().post(new RegUserEvent(response.body()));

                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<Reg_User> call, Throwable t) {
                // handle execution failures like no internet connectivity
                //   BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });

    }

    public void getMarkerList() {

        rectroConnection();
        Call<List<Marker>> markerlist = service.getMarkers();
        markerlist.enqueue(new Callback<List<Marker>>() {
            @Override
            public void onResponse(Call<List<Marker>> call, Response<List<Marker>> response) {
                //     BusProvider.getInstance().post(new LoginEvent(response.body()));
              //  Log.e("response", response.body().getEmail().toString());
                EventBus.getDefault().post(new MarkerEvent(response.body()));

                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<List<Marker>> call, Throwable t) {
                // handle execution failures like no internet connectivity
                //   BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }
    public void reg_user(String user_name,String uname,String contact,String email,String pwd) {

        rectroConnection();
        Call<Reg_User> markerlist = service.submit_users(user_name,uname,contact,email,pwd);
        markerlist.enqueue(new Callback<Reg_User>() {
            @Override
            public void onResponse(Call<Reg_User> call, Response<Reg_User> response) {
                //     BusProvider.getInstance().post(new LoginEvent(response.body()));
                //  Log.e("response", response.body().getEmail().toString());
                EventBus.getDefault().post(new RegUserEvent(response.body()));

                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<Reg_User> call, Throwable t) {
                // handle execution failures like no internet connectivity
                //   BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }

public void rectroConnection()
{
    //Here a logging interceptor is created
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);

    //The logging interceptor will be added to the http client
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(logging);

    //The Retrofit builder will have the client attached, in order to get connection logs
    Retrofit retrofit = new Retrofit.Builder()
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(SERVER_URL)
            .build();
    service = retrofit.create(Interface.class);
}

}