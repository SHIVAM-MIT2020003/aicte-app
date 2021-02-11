package com.example.shivamgupta.aicte.Service;


import com.example.shivamgupta.aicte.Model.Faculty;
import java.util.List;
import retrofit.Call;
import retrofit.http.GET;

public interface FacultyAPI {


    @GET("faculty_data.php")
    Call<List<Faculty>> getFacultyData();

}
