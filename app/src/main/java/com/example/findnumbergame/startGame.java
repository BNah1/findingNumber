package com.example.findnumbergame;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class startGame extends AppCompatActivity {
    private TextView mTextField;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        mTextField = findViewById(R.id.textTime);
        countDownTimer = new CountDownTimer(300000, 1000) {
            public void onTick(long millisUntilFinished) {
                mTextField.setText("Time:  " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                mTextField.setText("End Game");
            }
        }.start();
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new CustomAdapter(startGame.this));
    }
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
    private static class CustomAdapter extends BaseAdapter {
        private final Context mContext;
        private final int[] mNumbers;
        private final int[] mColors;

        public CustomAdapter(Context context) {
            mContext = context;
            mNumbers = new int[100];
            mColors = new int[100];

            Random random = new Random();
            Set<Integer> uniqueNumbers = new HashSet<>();

            for (int i = 0; i < 100; i++) {
                int randomNumber;
                do {
                    randomNumber = random.nextInt(100) + 1;
                } while (!uniqueNumbers.add(randomNumber));

                mNumbers[i] = randomNumber;
                mColors[i] = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            }
        }

        @Override
        public int getCount() {
            return mNumbers.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (convertView == null) {
                textView = new TextView(mContext);
                textView.setLayoutParams(new GridView.LayoutParams(200, 200)); // Kích thước ô vuông
                textView.setPadding(8, 8, 8, 8);
            } else {
                textView = (TextView) convertView;
            }

            textView.setText(String.valueOf(mNumbers[position]));
            textView.setBackgroundColor(mColors[position]);
            textView.setTextColor(Color.WHITE);

            return textView;
        }
    }
    }