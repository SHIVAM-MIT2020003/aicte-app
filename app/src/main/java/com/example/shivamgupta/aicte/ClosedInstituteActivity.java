package com.example.shivamgupta.aicte;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import com.example.shivamgupta.aicte.Model.ClosedInstitute;
import com.example.shivamgupta.aicte.Service.ClosedInstituteAPI;
import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ClosedInstituteActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    List<ClosedInstitute> closedInstituteTable;
    ListView listView;
    ListViewAdapterClosedInstitute listViewAdapterClosedInstitute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_institute);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);

        listView = (ListView) findViewById(R.id.closedInstituteListView);
        listViewAdapterClosedInstitute = new ListViewAdapterClosedInstitute(getApplicationContext(), R.layout.closed_inst_row_activity);
        listView.setAdapter(listViewAdapterClosedInstitute);

        getClosedInstituteData();
    }

    private void getClosedInstituteData() {
        showProgressDialog();
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://aicte.comeze.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            String yearText = "2016-2017";
            ClosedInstituteAPI service = retrofit.create(ClosedInstituteAPI.class);
            Call<List<ClosedInstitute>> call = service.getClosedInstitute();
            call.enqueue(new Callback<List<ClosedInstitute>>() {
                @Override
                public void onResponse(Response<List<ClosedInstitute>> response, Retrofit retrofit) {
                    closedInstituteTable = response.body();
                    for(int i = 0; i < closedInstituteTable.size(); i++){
                        ClosedInstitute closedInstitute = closedInstituteTable.get(i);
                        listViewAdapterClosedInstitute.add(closedInstitute);
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
