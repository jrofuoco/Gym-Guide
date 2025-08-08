package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> implements Filterable {

    private Context context;
    private Activity activity;
    private ArrayList<String> _id, first_name, last_name,
            address, gender, age, email, password;

    // Filtered lists
    private ArrayList<String> filtered_id, filtered_first_name, filtered_last_name,
            filtered_address, filtered_gender, filtered_age, filtered_email, filtered_password;

    CustomAdapter(Activity activity, Context context, ArrayList<String> _id, ArrayList<String> first_name,
                  ArrayList<String> last_name, ArrayList<String> address, ArrayList<String> gender,
                  ArrayList<String> age, ArrayList<String> email, ArrayList<String> password) {
        this.activity = activity;
        this.context = context;
        this._id = _id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.password = password;

        // Initialize filtered lists with the original data
        this.filtered_id = new ArrayList<>(_id);
        this.filtered_first_name = new ArrayList<>(first_name);
        this.filtered_last_name = new ArrayList<>(last_name);
        this.filtered_address = new ArrayList<>(address);
        this.filtered_gender = new ArrayList<>(gender);
        this.filtered_age = new ArrayList<>(age);
        this.filtered_email = new ArrayList<>(email);
        this.filtered_password = new ArrayList<>(password);
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        // Use filtered lists instead of original lists
        holder.idTxt.setText(String.valueOf(filtered_id.get(position)));
        holder.usernameText.setText(String.valueOf("Name: " + filtered_first_name.get(position)) + " " + String.valueOf(filtered_last_name.get(position)));
        holder.addressText.setText(String.valueOf("Address: " + filtered_address.get(position)));
        holder.genderText.setText(String.valueOf("Gender: " + filtered_gender.get(position)));
        holder.emailText.setText(String.valueOf("Email: " + filtered_email.get(position)));
        holder.passwordText.setText(String.valueOf("Password: " + filtered_password.get(position)));
        holder.ageText.setText(String.valueOf("Age: " + filtered_age.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(filtered_id.get(position)));
                intent.putExtra("firstname", String.valueOf(filtered_first_name.get(position)));
                intent.putExtra("address", String.valueOf(filtered_address.get(position)));
                intent.putExtra("gender", String.valueOf(filtered_gender.get(position)));
                intent.putExtra("email", String.valueOf(filtered_email.get(position)));
                intent.putExtra("password", String.valueOf(filtered_password.get(position)));
                intent.putExtra("lastname", String.valueOf(filtered_last_name.get(position)));
                intent.putExtra("age", String.valueOf(filtered_age.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filtered_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idTxt, usernameText, addressText, genderText, emailText,
                passwordText, ageText;

        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idTxt = itemView.findViewById(R.id.idAttendanceTxt);
            usernameText = itemView.findViewById(R.id.nameAttendanceTxt);
            addressText = itemView.findViewById(R.id.addressText);
            genderText = itemView.findViewById(R.id.genderText);
            emailText = itemView.findViewById(R.id.emailSchedText);
            passwordText = itemView.findViewById(R.id.passwordText);
            ageText = itemView.findViewById(R.id.ageText);
            mainLayout = itemView.findViewById(R.id.main_Layout);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString().toLowerCase().replaceAll("\\s", "");

                ArrayList<String> filteredList_id = new ArrayList<>();
                ArrayList<String> filteredList_first_name = new ArrayList<>();
                ArrayList<String> filteredList_last_name = new ArrayList<>();
                ArrayList<String> filteredList_address = new ArrayList<>();
                ArrayList<String> filteredList_gender = new ArrayList<>();
                ArrayList<String> filteredList_age = new ArrayList<>();
                ArrayList<String> filteredList_email = new ArrayList<>();
                // ... (initialize other filtered lists)

                ArrayList<String> archived_id = new ArrayList<>();
                ArrayList<String> archived_first_name = new ArrayList<>();
                ArrayList<String> archived_last_name = new ArrayList<>();
                ArrayList<String> archived_address = new ArrayList<>();
                ArrayList<String> archived_gender = new ArrayList<>();
                ArrayList<String> archived_age = new ArrayList<>();
                ArrayList<String> archived_email = new ArrayList<>();
                // ... (initialize other lists for archived items)

                for (int i = 0; i < _id.size(); i++) {
                    String firstNameWithoutSpaces = first_name.get(i).toLowerCase().replaceAll("\\s", "");
                    String lastNameWithoutSpaces = last_name.get(i).toLowerCase().replaceAll("\\s", "");

                    if (last_name.get(i).toLowerCase().contains("[archived]")) {
                        // Add archived items to the archived lists
                        archived_id.add(_id.get(i));
                        archived_first_name.add(first_name.get(i));
                        archived_last_name.add(last_name.get(i));
                        archived_address.add(address.get(i));
                        archived_gender.add(gender.get(i));
                        archived_age.add(age.get(i));
                        archived_email.add(email.get(i));
                        // ... (add other items to archived lists)
                    } else if (_id.get(i).toLowerCase().contains(query)
                            || firstNameWithoutSpaces.contains(query)
                            || lastNameWithoutSpaces.contains(query)
                            || gender.get(i).toLowerCase().contains(query)
                            || age.get(i).toLowerCase().contains(query)
                            || address.get(i).toLowerCase().contains(query)
                            || email.get(i).toLowerCase().contains(query)
                        //to add other conditions for filtering
                    ) {
                        // Add non-archived items to the filtered lists
                        filteredList_id.add(_id.get(i));
                        filteredList_first_name.add(first_name.get(i));
                        filteredList_last_name.add(last_name.get(i));
                        filteredList_address.add(address.get(i));
                        filteredList_gender.add(gender.get(i));
                        filteredList_age.add(age.get(i));
                        filteredList_email.add(email.get(i));
                        // ... (add other items to filtered lists)
                    }
                }

                // Combine filtered and archived lists
                filteredList_id.addAll(archived_id);
                filteredList_first_name.addAll(archived_first_name);
                filteredList_last_name.addAll(archived_last_name);
                filteredList_address.addAll(archived_address);
                filteredList_gender.addAll(archived_gender);
                filteredList_age.addAll(archived_age);
                filteredList_email.addAll(archived_email);
                // ... (add other items to filtered lists)

                FilterResults filterResults = new FilterResults();
                filterResults.values = new ArrayList[]{
                        filteredList_id,
                        filteredList_first_name,
                        filteredList_last_name,
                        filteredList_address,
                        filteredList_gender,
                        filteredList_age,
                        filteredList_email
                        // ... (initialize other filtered lists)
                };
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filtered_id.clear();
                filtered_first_name.clear();
                filtered_last_name.clear();
                filtered_address.clear();
                filtered_gender.clear();
                filtered_age.clear();
                filtered_email.clear();
                // ... (clear other filtered lists)

                ArrayList<String> filteredList_id = ((ArrayList<String>[]) filterResults.values)[0];
                ArrayList<String> filteredList_first_name = ((ArrayList<String>[]) filterResults.values)[1];
                ArrayList<String> filteredList_last_name = ((ArrayList<String>[]) filterResults.values)[2];
                ArrayList<String> filteredList_address = ((ArrayList<String>[]) filterResults.values)[3];
                ArrayList<String> filteredList_gender = ((ArrayList<String>[]) filterResults.values)[4];
                ArrayList<String> filteredList_age = ((ArrayList<String>[]) filterResults.values)[5];
                ArrayList<String> filteredList_email = ((ArrayList<String>[]) filterResults.values)[6];
                // ... (initialize other filtered lists)

                filtered_id.addAll(filteredList_id);
                filtered_first_name.addAll(filteredList_first_name);
                filtered_last_name.addAll(filteredList_last_name);
                filtered_address.addAll(filteredList_address);
                filtered_gender.addAll(filteredList_gender);
                filtered_age.addAll(filteredList_age);
                filtered_email.addAll(filteredList_email);
                // ... (add other items to filtered lists)

                notifyDataSetChanged();
            }
        };
    }



    // Add this method to set the filtered lists
    public void setFilteredLists(ArrayList<String> _id, ArrayList<String> first_name, ArrayList<String> last_name,
                                 ArrayList<String> address, ArrayList<String> gender,
                                 ArrayList<String> age, ArrayList<String> email, ArrayList<String> password) {
        this.filtered_id = new ArrayList<>(_id);
        this.filtered_first_name = new ArrayList<>(first_name);
        // ... (initialize other filtered lists)
    }
}

