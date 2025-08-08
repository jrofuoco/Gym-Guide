package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {

    private Context context;
    private ArrayList sched_id, sched_date, sched_Start, sched_ampm, usernameSchedText, emailSchedText, lastname;
    private ProgramScheduleDatabaseHelper databaseHelper; // Add a reference to the database helper

    ScheduleAdapter(Context context,
                    ArrayList sched_id,
                    ArrayList sched_date,
                    ArrayList sched_Start,
                    ArrayList sched_ampm,
                    ArrayList usernameSchedText,
                    ArrayList emailSchedText,
                    ArrayList lastname,
                    ProgramScheduleDatabaseHelper databaseHelper) {
        this.context = context;
        this.sched_id = sched_id;
        this.sched_date = sched_date;
        this.sched_Start = sched_Start;
        this.sched_ampm = sched_ampm;
        this.usernameSchedText = usernameSchedText;
        this.emailSchedText = emailSchedText;
        this.lastname = lastname;
        this.databaseHelper = databaseHelper; // Initialize the database helper
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_schedule, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.idTxt1.setText(String.valueOf(sched_id.get(position)));
        holder.dateTxt.setText(String.valueOf("Date: " + sched_date.get(position)));
        holder.timeStartTxt.setText(String.valueOf("Time Start: " + sched_Start.get(position)));
        holder.ampmTxt.setText(String.valueOf("AM/PM: " + sched_ampm.get(position)));
        holder.usernameTxt.setText(String.valueOf("Name: " + usernameSchedText.get(position) + " " + lastname.get(position)));
        holder.emailTxt.setText(String.valueOf("Email: " + emailSchedText.get(position)));

        // Set an OnClickListener for the item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item click here
                String clickedName = String.valueOf(usernameSchedText.get(position)) + " " + String.valueOf(lastname.get(position));
                showDeleteConfirmationDialog(clickedName, String.valueOf(sched_id.get(position)));
            }
        });
    }

    private void showDeleteConfirmationDialog(String name, String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Record");
        builder.setMessage("Are you sure you want to delete the record for " + name + "?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Perform delete operation here
                boolean isDeleted = databaseHelper.deleteRecordByEmail(id);

                if (isDeleted) {
                    String message = "Record for " + name + " deleted.";
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    // Refresh your RecyclerView or update the data accordingly
                    // For example, you can call notifyDataSetChanged()
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "Error deleting record", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public int getItemCount() {
        return sched_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idTxt1, dateTxt, timeStartTxt, ampmTxt, usernameTxt, emailTxt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idTxt1 = itemView.findViewById(R.id.idAttendanceTxt);
            dateTxt = itemView.findViewById(R.id.dateAttendanceTxt);
            timeStartTxt = itemView.findViewById(R.id.timeAttendanceTxt);
            ampmTxt = itemView.findViewById(R.id.ampmTxt);
            usernameTxt = itemView.findViewById(R.id.nameAttendanceTxt);
            emailTxt = itemView.findViewById(R.id.emailSchedText);
        }
    }
}
