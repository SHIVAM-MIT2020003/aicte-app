package com.example.shivamgupta.aicte.Service;

import com.example.shivamgupta.aicte.Model.ClosedCourse;
import java.util.List;
import retrofit.Call;
import retrofit.http.GET;
public interface ClosedCourseAPI {

    @GET("closed_course_data.php")
    Call<List<ClosedCourse>> getData();

}
