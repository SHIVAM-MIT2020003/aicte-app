package com.example.shivamgupta.aicte.Service;

import com.example.shivamgupta.aicte.Model.ApprovedInstitution;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

public interface ApprovedInstituteAPI {

    @GET("approved.php")
    Call<List<ApprovedInstitution>> getData();

}
