package com.example.shivamgupta.aicte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button button;
    Button getFacultyDataButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.nriPriGetData);
        getFacultyDataButton = (Button) findViewById(R.id.getFacultyDataButton);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                   Intent intent = new Intent(MainActivity.this, NriPioTpActivity.class);
                   startActivity(intent);
            }
        });
    }

    public void showData(View view){
        Intent intent = new Intent(this, FacultyActivity.class);
        startActivity(intent);
    }

    public void showClosedInstituteData(View view){
        Intent intent = new Intent(this, ClosedInstituteActivity.class);
        startActivity(intent);
    }

    public void showClosedCourseData(View view){
        Intent intent = new Intent(this, ClosedCourseActivity.class);
        startActivity(intent);
    }

    public void showApprovedInstitution(View view){
        Intent intent = new Intent(this, ApprovedInstituteActivity.class);
        startActivity(intent);
    }
}
