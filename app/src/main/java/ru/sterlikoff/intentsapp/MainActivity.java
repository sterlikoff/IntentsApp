package ru.sterlikoff.intentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button syncButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    protected void initViews() {

        syncButton = findViewById(R.id.sync_button);
        syncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String host;

                Date currentTime = Calendar.getInstance().getTime();
                int h = currentTime.getHours();

                if ((h >= 6) && (h < 14)) {
                    host = "morning";
                } else if ((h >= 14) && (h < 16)) {
                    host = "afternoon";
                } else {
                    host = "evening";
                }

                Intent intent = new Intent(Intent.ACTION_SYNC);
                intent.setData(Uri.parse("http://" + host));

                startActivity(intent);

            }

        });

    }

}
