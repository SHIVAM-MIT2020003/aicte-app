package com.example.shivamgupta.aicte.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shivamgupta.aicte.Model.ApprovedInstitution;
import com.example.shivamgupta.aicte.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapterApprovedInstitute extends ArrayAdapter{
    static class ApprovedInstitueDataHandler{
        TextView aicteId;
        TextView intituteName;
        TextView address;
        TextView district;
        TextView institutionType;
        TextView women;
        TextView minority;
    }

    List list = new ArrayList();
    public ListViewAdapterApprovedInstitute(Context context, int resource) {
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
        ApprovedInstitueDataHandler approvedInstitueDataHandler;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.approved_institute_row_layout, parent, false);
            approvedInstitueDataHandler = new ApprovedInstitueDataHandler();
            approvedInstitueDataHandler.aicteId = (TextView) row.findViewById(R.id.approvedAicteID);
            approvedInstitueDataHandler.intituteName = (TextView) row.findViewById(R.id.approvedName);
            approvedInstitueDataHandler.address= (TextView) row.findViewById(R.id.approvedAddress);
            approvedInstitueDataHandler.district= (TextView) row.findViewById(R.id.approvedDistrict);
            approvedInstitueDataHandler.institutionType = (TextView) row.findViewById(R.id.approvedInstType);
            approvedInstitueDataHandler.women= (TextView) row.findViewById(R.id.approvedWomen);
            approvedInstitueDataHandler.minority = (TextView) row.findViewById(R.id.approvedMinority);
            row.setTag(approvedInstitueDataHandler);

        }else{
            approvedInstitueDataHandler = (ApprovedInstitueDataHandler) row.getTag();
        }
        ApprovedInstitution approvedInstitution = (ApprovedInstitution) this.getItem(position);
        approvedInstitueDataHandler.aicteId.setText(approvedInstitution.getAicteId());
        approvedInstitueDataHandler.intituteName.setText(approvedInstitution.getName());
        approvedInstitueDataHandler.address.setText(approvedInstitution.getAddress());
        approvedInstitueDataHandler.district.setText(approvedInstitution.getDistrict());
        approvedInstitueDataHandler.institutionType.setText(approvedInstitution.getInstitutionType());
        approvedInstitueDataHandler.women.setText(approvedInstitution.getWomen());
        approvedInstitueDataHandler.minority.setText(approvedInstitution.getMinority());
        return row;
    }
}
