package com.example.shivamgupta.aicte;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import com.example.shivamgupta.aicte.Model.NonResidentIndian;
import com.example.shivamgupta.aicte.Service.NonResidentIndianAPI;
import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class NriPioTpActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter listViewAdapter;
    List<NonResidentIndian> tableData;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nri_pio_tp);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);

        listView = (ListView) findViewById(R.id.listView);
        listViewAdapter = new ListViewAdapter(getApplicationContext(), R.layout.row_layout_activity);
        listView.setAdapter(listViewAdapter);
        getNonResidentIndianData();
        //new LoadingData().execute();
    }

/*
    class LoadingData extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            //showProgressDialog();
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://aicte.comeze.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                String yearText = "2016-2017";
                NonResidentIndianAPI service = retrofit.create(NonResidentIndianAPI.class);
                Call<List<NonResidentIndian>> call = service.getData(yearText.toString());
                call.enqueue(new Callback<List<NonResidentIndian>>() {
                    @Override
                    public void onResponse(Response<List<NonResidentIndian>> response, Retrofit retrofit) {
                        tableData = response.body();
                        hideProgressDialog();
                        for(int i = 0; i < tableData.size(); i++){
                            NonResidentIndian nonResidentIndian = tableData.get(i);
                            listViewAdapter.add(nonResidentIndian);
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        //hideProgressDialog();
                    }
                });
            } catch (Exception e) {
                Log.d("onResponse", "There is an error");
                e.printStackTrace();
                hideProgressDialog();
            }
            return null;
        }
    }
*/

    private void getNonResidentIndianData() {
        showProgressDialog();
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://aicte.comeze.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            String yearText = "2016-2017";
            NonResidentIndianAPI service = retrofit.create(NonResidentIndianAPI.class);
            Call<List<NonResidentIndian>> call = service.getData(yearText.toString());
            call.enqueue(new Callback<List<NonResidentIndian>>() {
                @Override
                public void onResponse(Response<List<NonResidentIndian>> response, Retrofit retrofit) {
                    tableData = response.body();
                    for(int i = 0; i < tableData.size(); i++){
                        NonResidentIndian nonResidentIndian = tableData.get(i);
                        listViewAdapter.add(nonResidentIndian);
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
