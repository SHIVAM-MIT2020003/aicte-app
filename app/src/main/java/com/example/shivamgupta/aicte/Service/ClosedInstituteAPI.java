package com.example.shivamgupta.aicte.Service;

import com.example.shivamgupta.aicte.Model.ClosedInstitute;
import java.util.List;
import retrofit.Call;
import retrofit.http.GET;

public interface ClosedInstituteAPI {

    @GET("closed_institute.php")
    Call<List<ClosedInstitute>> getClosedInstitute();

}
