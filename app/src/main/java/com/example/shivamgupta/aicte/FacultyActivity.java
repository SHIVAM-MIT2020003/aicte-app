package com.example.shivamgupta.aicte;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import com.example.shivamgupta.aicte.Model.Faculty;
import com.example.shivamgupta.aicte.Service.FacultyAPI;
import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class FacultyActivity extends AppCompatActivity {
    ProgressDialog progressDialog;

    List<Faculty> facultyTable;
    ListView listView;
    ListViewAdapterFaculty listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        listView = (ListView) findViewById(R.id.facultyListView);
        listViewAdapter = new ListViewAdapterFaculty(getApplicationContext(), R.layout.faculty_row_activity);
        listView.setAdapter(listViewAdapter);
        getFacultyData();
    }

    private void getFacultyData() {
        showProgressDialog();
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://aicte.comeze.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            FacultyAPI service = retrofit.create(FacultyAPI.class);
            Call<List<Faculty>> call = service.getFacultyData();
            call.enqueue(new Callback<List<Faculty>>() {
                @Override
                public void onResponse(Response<List<Faculty>> response, Retrofit retrofit) {
                    facultyTable = response.body();
                    for(int i = 0; i < facultyTable.size(); i++){
                        Faculty faculty = facultyTable.get(i);
                        listViewAdapter.add(faculty);
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
