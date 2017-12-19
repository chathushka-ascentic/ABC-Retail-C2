package com.example.admin.abcfashions.WebService;

import com.example.admin.abcfashions.WebService.pojo.Marker;
import com.example.admin.abcfashions.WebService.pojo.Reg_User;
import com.example.admin.abcfashions.WebService.pojo.TransactionEvent;
import com.example.admin.abcfashions.WebService.pojo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by admin on 12/16/17.
 */

public interface Interface {

    @FormUrlEncoded
    @POST("/geo/geo_rajitha/mobile_login.php")
    Call<User> post(
            @Field("uname") String username,
            @Field("pwd") String password
    );


    @FormUrlEncoded
    @POST("/geo/geo_rajitha/user_signup_mobile.php")
    Call<Reg_User> submit_users(
                    @Field("user_name") String user_name,
                    @Field("uname") String uname,
                    @Field("contact") String contact,
                    @Field("email") String email,
                    @Field("pwd") String pwd
            );


    @POST("/geo/geo_rajitha/transaction_service.php")
    Call<Reg_User> submit_items(@Body TransactionEvent transactionEvent);


    @GET("/geo/geo_rajitha/marker_service.php")
    Call<List<Marker>> getMarkers();

}
