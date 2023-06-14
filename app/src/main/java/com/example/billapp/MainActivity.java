package com.example.billapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText data = findViewById(R.id.data);
        EditText callMinutes = findViewById(R.id.Cminutes);
        EditText SMS = findViewById(R.id.sms);
        Button button = findViewById(R.id.button);
        TextView tee = findViewById(R.id.tx);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dataz = Integer.parseInt(data.getText().toString());
                int CMz = Integer.parseInt(callMinutes.getText().toString());
                int SMSz = Integer.parseInt(SMS.getText().toString());

                int SU = SpeakUp(dataz, CMz, SMSz);
                int M = Messenger(dataz, CMz, SMSz);
                int D = Downloader(dataz, CMz, SMSz);
                if (SU < M) {
                    tee.setText("The best contract available to you is SpeakUp");
                }
                if(SU<D){
                    tee.setText("The best contract available to you is SpeakUp");
                }
                if (M < SU) {
                    tee.setText("The best contract available to you is Messenger");
                }
                if (M < D) {
                    tee.setText("The best contract available to you is Messenger");
                }


                if (D< SU && D < M) {
                    tee.setText("The best contract available to you is Download");
                }
            }
        });

    }

    public int SpeakUp(int dataz, int CMz, int SMSz) {
        dataz = dataz * 3;
        CMz = CMz * 1;
        SMSz = SMSz * 2;

        return dataz + CMz + SMSz;

    }

    public int Messenger(int dataz, int CMz, int SMSz) {
        dataz = dataz * 4;
        CMz = CMz * 3;
        SMSz=SMSz*1;


        return dataz + CMz +SMSz;

    }

    public int Downloader(int dataz, int CMz, int SMSz) {

        CMz = CMz * 4;
        SMSz = SMSz * 3;
        dataz=dataz*1;

        return  CMz + SMSz+dataz;
    }
}