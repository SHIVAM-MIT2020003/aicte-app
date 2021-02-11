package com.example.shivamgupta.aicte.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.shivamgupta.aicte.Model.ClosedCourse;
import com.example.shivamgupta.aicte.R;
import java.util.ArrayList;
import java.util.List;

public class ListViewAdatperClosedCourse extends ArrayAdapter{

        static class ClosedCourseDataHandler{
            TextView aicteId;
            TextView intituteName;
            TextView instituteType;
            TextView state;
            TextView district;
            TextView courseId;
            TextView university;
            TextView level;
            TextView course;
            TextView shift;
            TextView timing;
        }

        List list = new ArrayList();
        public ListViewAdatperClosedCourse(Context context, int resource) {
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
            ClosedCourseDataHandler closedCourseDataHandler;
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.closed_course_row_layout, parent, false);
                closedCourseDataHandler = new ClosedCourseDataHandler();
                closedCourseDataHandler.aicteId = (TextView) row.findViewById(R.id.closedCourseAicteId);
                closedCourseDataHandler.intituteName = (TextView) row.findViewById(R.id.closedCourseInstName);
                closedCourseDataHandler.instituteType  = (TextView) row.findViewById(R.id.closedCourseInstType);
                closedCourseDataHandler.state = (TextView) row.findViewById(R.id.closedCourseState);
                closedCourseDataHandler.district = (TextView) row.findViewById(R.id.closedCourseDistrict);
                closedCourseDataHandler.courseId= (TextView) row.findViewById(R.id.closedCourseCourseId);
                closedCourseDataHandler.university= (TextView) row.findViewById(R.id.closedCourseUniversity);
                closedCourseDataHandler.level= (TextView) row.findViewById(R.id.closedCourseLevel);
                closedCourseDataHandler.course= (TextView) row.findViewById(R.id.closedCourseCourse);
                closedCourseDataHandler.shift= (TextView) row.findViewById(R.id.closedCourseShift);
                closedCourseDataHandler.timing= (TextView) row.findViewById(R.id.closedCourseTiming);
                row.setTag(closedCourseDataHandler);

            }else{
                closedCourseDataHandler = (ClosedCourseDataHandler) row.getTag();
            }
            ClosedCourse closedCourse = (ClosedCourse) this.getItem(position);
            closedCourseDataHandler.aicteId.setText(closedCourse.getAicteId());
            closedCourseDataHandler.intituteName.setText(closedCourse.getInstituteName());
            closedCourseDataHandler.instituteType.setText(closedCourse.getInstituteType());
            closedCourseDataHandler.state.setText(closedCourse.getState());
            closedCourseDataHandler.district.setText(closedCourse.getDistrict());
            closedCourseDataHandler.courseId.setText(closedCourse.getCourseId());
            closedCourseDataHandler.university.setText(closedCourse.getUniversity());
            closedCourseDataHandler.level.setText(closedCourse.getLevel());
            closedCourseDataHandler.course.setText(closedCourse.getCourse());
            closedCourseDataHandler.shift.setText(closedCourse.getShift());
            closedCourseDataHandler.timing.setText(closedCourse.getTiming());
            return row;
        }
}

