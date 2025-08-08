package com.example.myapplication;

import android.content.Context;
import android.content.Intent;

public class ShortCutClasses {

    public void openExercisesActivity(Context context) {
        Intent intent = new Intent(context, ExercisesActivity.class);
        context.startActivity(intent);
    }

    public void openMembershipActivity(Context context){
        Intent intent = new Intent(context, MembershipActivity.class);
        context.startActivity(intent);
    }

    public void openScheduleActivity(Context context){
        Intent intent = new Intent(context, ScheduleActivity.class);
        context.startActivity(intent);
    }

    public void openSupplementsActivity(Context context) {
        Intent intent = new Intent(context, SupplementsActivity.class);
        context.startActivity(intent);
    }
}
