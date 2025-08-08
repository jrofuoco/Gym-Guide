package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.MyViewHolder> implements Filterable {

    private Context context;
    private ArrayList attendance_id, attendance_name, attendance_date, attendance_time;

    // For filtering
    private List<String> filteredId, filteredName, filteredDate, filteredTime;

    AttendanceAdapter(Context context,
                      ArrayList attendance_id,
                      ArrayList attendance_name,
                      ArrayList attendance_date,
                      ArrayList attendance_time) {
        this.context = context;
        this.attendance_id = attendance_id;
        this.attendance_name = attendance_name;
        this.attendance_date = attendance_date;
        this.attendance_time = attendance_time;

        // Initialize filtered lists with the original data
        this.filteredId = new ArrayList<>(attendance_id);
        this.filteredName = new ArrayList<>(attendance_name);
        this.filteredDate = new ArrayList<>(attendance_date);
        this.filteredTime = new ArrayList<>(attendance_time);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_attendance, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(filteredId.get(position)));
        holder.name.setText(String.valueOf("Name: " + filteredName.get(position)));
        holder.date.setText(String.valueOf("Date: " + filteredDate.get(position)));
        holder.time.setText(String.valueOf("AM/PM: " + filteredTime.get(position)));
    }

    @Override
    public int getItemCount() {
        return filteredId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id, name, date, time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idAttendanceTxt);
            name = itemView.findViewById(R.id.nameAttendanceTxt);
            date = itemView.findViewById(R.id.dateAttendanceTxt);
            time = itemView.findViewById(R.id.timeAttendanceTxt);
        }
    }

    // Filter implementation
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString().toLowerCase();

                filteredId.clear();
                filteredName.clear();
                filteredDate.clear();
                filteredTime.clear();

                if (query.isEmpty()) {
                    filteredId.addAll(attendance_id);
                    filteredName.addAll(attendance_name);
                    filteredDate.addAll(attendance_date);
                    filteredTime.addAll(attendance_time);
                } else {
                    for (int i = 0; i < attendance_name.size(); i++) {
                        if (attendance_name.get(i).toString().toLowerCase().contains(query) ||
                                attendance_date.get(i).toString().toLowerCase().contains(query)) {
                            filteredId.add(attendance_id.get(i).toString());
                            filteredName.add(attendance_name.get(i).toString());
                            filteredDate.add(attendance_date.get(i).toString());
                            filteredTime.add(attendance_time.get(i).toString());
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredId;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                notifyDataSetChanged();
            }
        };
    }
}
