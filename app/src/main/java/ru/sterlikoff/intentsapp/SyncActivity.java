package ru.sterlikoff.intentsapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public abstract class SyncActivity extends AppCompatActivity {

    TextView timeLabel;
    TextView nameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Date currentTime = Calendar.getInstance().getTime();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);

        timeLabel = findViewById(R.id.current_time_label);
        timeLabel.setText(currentTime.toString());

        nameLabel = findViewById(R.id.activity_name);
        nameLabel.setText(this.getClass().getSimpleName());

    }

}