package com.example.shivamgupta.aicte;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.shivamgupta.aicte.Model.NonResidentIndian;
import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter{

    static class DataHandler{
        TextView aicte_id;
        TextView institute_name;
        TextView state;
        TextView district;
        TextView institute_type;
        TextView program;
        TextView university_board;
        TextView level;
        TextView course_name;
        TextView approvedText;
        TextView seatNumText;
    }


    List list = new ArrayList();
    public ListViewAdapter(Context context, int resource) {
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
        DataHandler dataHandler;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout_activity, parent, false);
            dataHandler = new DataHandler();
            dataHandler.aicte_id= (TextView) row.findViewById(R.id.aicte_id);
            dataHandler.institute_name= (TextView) row.findViewById(R.id.institute_name);
            dataHandler.state = (TextView) row.findViewById(R.id.state);
            dataHandler.district = (TextView) row.findViewById(R.id.district);
            dataHandler.institute_type = (TextView) row.findViewById(R.id.institute_type);
            dataHandler.program = (TextView) row.findViewById(R.id.program);
            dataHandler.university_board = (TextView) row.findViewById(R.id.university_board);
            dataHandler.level = (TextView) row.findViewById(R.id.level);
            dataHandler.course_name = (TextView) row.findViewById(R.id.course_name);
            dataHandler.approvedText = (TextView) row.findViewById(R.id.approvedText);
            dataHandler.seatNumText = (TextView) row.findViewById(R.id.seatNumText);
            row.setTag(dataHandler);

        }else{
            dataHandler = (DataHandler) row.getTag();
        }
         NonResidentIndian  nonResidentIndian = (NonResidentIndian) this.getItem(position);

        dataHandler.aicte_id.setText(nonResidentIndian.getAicte_id());
        dataHandler.institute_name.setText(nonResidentIndian.getInstitute_name());
        dataHandler.state.setText(nonResidentIndian.getState());
        dataHandler.district.setText(nonResidentIndian.getDistrict());
        dataHandler.institute_type.setText(nonResidentIndian.getInstitute_type());
        dataHandler.program.setText(nonResidentIndian.getProgram());
        dataHandler.university_board.setText(nonResidentIndian.getUniv_board());
        dataHandler.level.setText(nonResidentIndian.getLevel());
        dataHandler.course_name.setText(nonResidentIndian.getCourse_name());
        dataHandler.approvedText.setText(nonResidentIndian.getApproved_intake());
        dataHandler.seatNumText.setText(nonResidentIndian.getShift());  // need some changes.
        return row;
    }
}

