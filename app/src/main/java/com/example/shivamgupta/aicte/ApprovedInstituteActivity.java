package com.example.shivamgupta.aicte;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import com.example.shivamgupta.aicte.Adapter.ListViewAdapterApprovedInstitute;
import com.example.shivamgupta.aicte.Model.ApprovedInstitution;
import com.example.shivamgupta.aicte.Service.ApprovedInstituteAPI;
import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ApprovedInstituteActivity extends AppCompatActivity {


    ProgressDialog progressDialog;
    List<ApprovedInstitution> approvedInstitutions;
    ListView listView;
    ListViewAdapterApprovedInstitute listViewAdapterApprovedInstitute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved_institute);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        listView = (ListView) findViewById(R.id.approvedInstitutionListView);
        listViewAdapterApprovedInstitute = new ListViewAdapterApprovedInstitute(getApplicationContext(), R.layout.closed_course_row_layout);
        listView.setAdapter(listViewAdapterApprovedInstitute);
        getApprovedInstituteData();
    }

    private void getApprovedInstituteData() {
        showProgressDialog();
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://aicte.comeze.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApprovedInstituteAPI service = retrofit.create(ApprovedInstituteAPI.class);
            Call<List<ApprovedInstitution>> call = service.getData();
            call.enqueue(new Callback<List<ApprovedInstitution>>() {
                @Override
                public void onResponse(Response<List<ApprovedInstitution>> response, Retrofit retrofit) {
                    approvedInstitutions = response.body();
                    for(int i = 0; i < approvedInstitutions.size(); i++){
                        ApprovedInstitution closedCourse = approvedInstitutions.get(i);
                        listViewAdapterApprovedInstitute.add(closedCourse);
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
