package com.example.shivamgupta.aicte.Service;

import com.example.shivamgupta.aicte.Model.NonResidentIndian;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface NonResidentIndianAPI {

    @FormUrlEncoded
    @POST("get_data.php")
    Call<List<NonResidentIndian>> getData(@Field("year") String year);

}
