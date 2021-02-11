package com.example.shivamgupta.aicte;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.shivamgupta.aicte.Adapter.ListViewAdatperClosedCourse;
import com.example.shivamgupta.aicte.Model.ClosedCourse;
import com.example.shivamgupta.aicte.Service.ClosedCourseAPI;
import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ClosedCourseActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    List<ClosedCourse> closedCourses;
    ListView listView;
    ListViewAdatperClosedCourse listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_course);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        listView = (ListView) findViewById(R.id.closedCourseListView);
        listViewAdapter = new ListViewAdatperClosedCourse(getApplicationContext(), R.layout.closed_course_row_layout);
        listView.setAdapter(listViewAdapter);
        getClosedCourseData();
    }

    //http://aicte.comeze.com/closed_course_data.php

    private void getClosedCourseData() {
        showProgressDialog();
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://aicte.comeze.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ClosedCourseAPI service = retrofit.create(ClosedCourseAPI.class);
            Call<List<ClosedCourse>> call = service.getData();
            call.enqueue(new Callback<List<ClosedCourse>>() {
                @Override
                public void onResponse(Response<List<ClosedCourse>> response, Retrofit retrofit) {
                    closedCourses = response.body();
                    for(int i = 0; i < closedCourses.size(); i++){
                        ClosedCourse closedCourse = closedCourses.get(i);
                        listViewAdapter.add(closedCourse);
                    }

                    hideProgressDialog();
                }
                @Override
                public void onFailure(Throwable t) {
                    hideProgressDialog();
                }
            });
        } catch (Exception e) {
            Log.d("onResponse", "There is an error");
            e.printStackTrace();
            hideProgressDialog();
        }
    }

    private void hideProgressDialog() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private void showProgressDialog() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }
}
