package com.example.shivamgupta.aicte;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.shivamgupta.aicte.Model.Faculty;
import java.util.ArrayList;
import java.util.List;

public class ListViewAdapterFaculty extends ArrayAdapter {

    static class FacultyDataHandler{
         TextView facultyId;
         TextView name;
         TextView gender;
         TextView designation;
         TextView dateOfJoining;
         TextView areaOfSpecialisation;
         TextView appointmentType;
         TextView instituteName;
    }

    List list = new ArrayList();
    public ListViewAdapterFaculty(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        FacultyDataHandler facultyDataHandler;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.faculty_row_activity, parent, false);
            facultyDataHandler = new FacultyDataHandler();
            facultyDataHandler.facultyId= (TextView) row.findViewById(R.id.facultyId);
            facultyDataHandler.name= (TextView) row.findViewById(R.id.facultyName);
            facultyDataHandler.gender= (TextView) row.findViewById(R.id.genderText);
            facultyDataHandler.designation= (TextView) row.findViewById(R.id.designationText);
            facultyDataHandler.dateOfJoining= (TextView) row.findViewById(R.id.joiningText);
            facultyDataHandler.areaOfSpecialisation = (TextView) row.findViewById(R.id.specializationText);
            facultyDataHandler.appointmentType= (TextView) row.findViewById(R.id.appointmentText);
            facultyDataHandler.instituteName= (TextView) row.findViewById(R.id.institute_name);
            row.setTag(facultyDataHandler);

        }else{
            facultyDataHandler = (FacultyDataHandler) row.getTag();
        }
        Faculty faculty = (Faculty) this.getItem(position);
        facultyDataHandler.facultyId.setText(faculty.getFacultyId());
        facultyDataHandler.name.setText(faculty.getName());
        facultyDataHandler.gender.setText(faculty.getGender());
        facultyDataHandler.designation.setText(faculty.getDesignation());
        facultyDataHandler.dateOfJoining.setText(faculty.getDateOfJoining());
        facultyDataHandler.areaOfSpecialisation.setText(faculty.getAreaOfSpecialisation());
        facultyDataHandler.appointmentType.setText(faculty.getAppointmentType());
        facultyDataHandler.instituteName.setText(faculty.getInstituteName());

        return row;
    }
}
