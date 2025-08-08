package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AfterAfterExerciseActivity extends AppCompatActivity {
    private String videoPath;
    private String highVolumeText, lowVolumeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_after_exercise);

        // GET THE TITLE
        Intent intent = getIntent();
        String getTheTitle = intent.getStringExtra("title");

        if (getTheTitle.equals("Barbell Press")){ //TO PASS AND OPEN THE CONTENT OF BARBELL PRESS
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.barbellpress;
            TextView exercisesTxt3 = findViewById(R.id.exercisesTxt3);
            exercisesTxt3.setText(getTheTitle);
            exercisesTxt3.setTextSize(35);

            highVolumeText = "•5 Sets\n" +
                    "•12 repetitions per set\n" +
                    "•Total Volume: 5 sets x 12 reps = 60 repetitions";

            lowVolumeText = "•3 Sets\n" +
                    "•6 repetitions per set\n" +
                    "•Total Volume: 3 sets x 6 reps = 18 repetitions";

            //pass the media to VIDEOVIEW
            initializeMedia();
            setVolume();

        }else if(getTheTitle.equals("Dumbbell Press")){ //to pass and open the content of dumbell press
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.dumbellpress;
            TextView exercisesTxt3 = findViewById(R.id.exercisesTxt3);
            exercisesTxt3.setText(getTheTitle);
            exercisesTxt3.setTextSize(35);

            highVolumeText = "•4 Sets\n" +
                    "•12 repetitions per set\n" +
                    "•Total Volume: 4 sets × 12 reps = 48 repetitions";

            lowVolumeText = "•2 Sets\n" +
                    "•6 repetitions per set\n" +
                    "•Total Volume: 2 sets x 6 reps = 12 repetitions";

            //pass the media to VIDEOVIEW
            initializeMedia();
            setVolume();
        }else if (getTheTitle.equals("Incline Barbell Press")) { //INCLINE BARBELL PRESS
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.inclinebarbellpress;
            TextView exercisesTxt3 = findViewById(R.id.exercisesTxt3);
            exercisesTxt3.setText(getTheTitle);
            exercisesTxt3.setTextSize(35);

            highVolumeText = "•5 Sets\n" +
                    "•12 repetitions per set\n" +
                    "•Total Volume: 5 sets × 12 reps = 60 repetitions";

            lowVolumeText = "•3 Sets\n" +
                    "•6 repetitions per set\n" +
                    "•Total Volume: 3 sets x 6 reps = 18 repetitions";

            //pass the media to VIDEOVIEW
            initializeMedia();
            setVolume();
        }else if(getTheTitle.equals("Incline Dumbbell Press")){ //INCLINE DUMBBELL PRESS
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.dumbellinclinepress;
            TextView exercisesTxt3 = findViewById(R.id.exercisesTxt3);
            exercisesTxt3.setText(getTheTitle);
            exercisesTxt3.setTextSize(35);

            highVolumeText = "•5 Sets\n" +
                    "•12 repetitions per set\n" +
                    "•Total Volume: 5 sets × 12 reps = 60 repetitions";

            lowVolumeText = "•3 Sets\n" +
                    "•6 repetitions per set\n" +
                    "•Total Volume: 3 sets x 6 reps = 18 repetitions";

            //pass the media to VIDEOVIEW
            initializeMedia();
            setVolume();
        } else if (getTheTitle.equals("Peck Deck Flies")) { //PECK DECK FLIES
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.peckdeckmahinefly;
            TextView exercisesTxt3 = findViewById(R.id.exercisesTxt3);
            exercisesTxt3.setText(getTheTitle);
            exercisesTxt3.setTextSize(35);

            highVolumeText = "•5 Sets\n" +
                    "•15 repetitions per set\n" +
                    "•Total Volume: 5 sets × 15 reps = 75 repetitions";

            lowVolumeText = "•3 Sets\n" +
                    "•8 repetitions per set\n" +
                    "•Total Volume: 3 sets x 8 reps = 24 repetitions";

            //pass the media to VIDEOVIEW
            initializeMedia();
            setVolume();
        }

        switch (getTheTitle){
            case "Deadlift": //DEADLIFTS
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.deadlift;
                TextView exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•5 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•5 repetitions per set\n" +
                        "•Rest between sets: 2-3 minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Chinups":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.chinup;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 30-60 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•6-8 repetitions per set\n" +
                        "•Rest between sets: 1-2 minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Bent Over":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.bentover;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 30-60 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 1-2 minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Lat Pulldown":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.latpulldown;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Seated Cable Row":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.seatedcable;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Military Press":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.militarypress;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Seated Dumbell Press":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.seateddumbellpress;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Cable Side Lateral Raises":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.cabelsidelateral;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Bench Dip":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.benchdip;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Seated Dumbbell Curl":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.seateddumbbellcurl;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Preacher Curl":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.preachercurl;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Cable Curl":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.cablecurl;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Ez Bar Curl":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ezbar;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Tricep Dips":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.tricepdips;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Tricep Overhead":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.overhead;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Tricep Kicback":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.kickback;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                TextView exercisesTxt8 = findViewById(R.id.exercisesTxt8);
                exercisesTxt8.setText("Note: This may vary depending on how much weight you lift.\n" +
                        "Note: You can also do the same with Dumbbells.");

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Tricep Pushdown":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.pushdown;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Barbell Squat":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.barbellsquat;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Leg Press":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.legpress;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;


            case "Leg Kickback":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.legkickbacks;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;

            case "Barbell Calf Raises":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.calfraises;
                exercisesTxt3 = findViewById(R.id.exercisesTxt3);
                exercisesTxt3.setText(getTheTitle);
                exercisesTxt3.setTextSize(35);

                highVolumeText = "•4 Sets\n" +
                        "•12 repetitions per set\n" +
                        "•Rest between sets: 60-90 seconds";

                lowVolumeText = "•3 Sets\n" +
                        "•8-10 repetitions per set\n" +
                        "•Rest between sets: 2-3m minutes";

                //pass the media to VIDEOVIEW
                initializeMedia();
                setVolume();
                break;
        }
        Button backbutton4 = findViewById(R.id.backbutton4);
        backbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void initializeMedia() {
        ScalableVideoView videoView = findViewById(R.id.videoView);

        // Assuming you have a video file named "video.mp4" in the "res/raw" directory
        Uri uri = Uri.parse(videoPath);

        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        //mediaController.setAnchorView(videoView);
        //videoView.setMediaController(mediaController);

        // Start playing the video
        videoView.start();
    }

    public void setVolume() {
        TextView exercisesTxt6 = findViewById(R.id.exercisesTxt6);
        exercisesTxt6.setText(highVolumeText);
        exercisesTxt6.setTextSize(23);

        TextView exercisesTxt7 = findViewById(R.id.exercisesTxt7);
        exercisesTxt7.setText(lowVolumeText);
        exercisesTxt6.setTextSize(23);
    }
}