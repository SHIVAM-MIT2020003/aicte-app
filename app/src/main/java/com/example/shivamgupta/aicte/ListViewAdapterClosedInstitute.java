package com.example.shivamgupta.aicte;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.shivamgupta.aicte.Model.ClosedInstitute;
import java.util.ArrayList;
import java.util.List;

public class ListViewAdapterClosedInstitute extends ArrayAdapter
{
    static class ClosedInstituteDataHandler{
        TextView aicteID;
        TextView instituteName;
        TextView instituteType;
        TextView address;
        TextView state;
        TextView district;
        TextView city;
    }

    List list = new ArrayList();
    public ListViewAdapterClosedInstitute(Context context, int resource) {
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
        ClosedInstituteDataHandler closedInstituteDataHandler;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.closed_inst_row_activity, parent, false);

            closedInstituteDataHandler = new ClosedInstituteDataHandler();
            closedInstituteDataHandler.aicteID = (TextView) row.findViewById(R.id.closedAicteId);
            closedInstituteDataHandler.instituteName = (TextView) row.findViewById(R.id.closedInstituteName);
            closedInstituteDataHandler.instituteType= (TextView) row.findViewById(R.id.closedInstituteType);
            closedInstituteDataHandler.address = (TextView) row.findViewById(R.id.closedInstituteAddress);
            closedInstituteDataHandler.state = (TextView) row.findViewById(R.id.closedState);
            closedInstituteDataHandler.district = (TextView) row.findViewById(R.id.closedInstDistrict);
            closedInstituteDataHandler.city = (TextView) row.findViewById(R.id.closedInstCity);
            row.setTag(closedInstituteDataHandler);

        }else{
            closedInstituteDataHandler = (ClosedInstituteDataHandler) row.getTag();
        }
        ClosedInstitute institute = (ClosedInstitute) this.getItem(position);
        closedInstituteDataHandler.aicteID.setText(institute.getAicteID());
        closedInstituteDataHandler.instituteName.setText(institute.getInstituteName());
        closedInstituteDataHandler.instituteType.setText(institute.getInstituteType());
        closedInstituteDataHandler.address.setText(institute.getAddress());
        closedInstituteDataHandler.state.setText(institute.getState());
        closedInstituteDataHandler.district.setText(institute.getDistrict());
        closedInstituteDataHandler.city.setText(institute.getCity());
        return row;
    }
}
