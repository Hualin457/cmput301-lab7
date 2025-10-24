package com.example.androiduitesting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowActivity extends AppCompatActivity {
    private static final String KEY_CITY_NAME = "CityName";

    public static Intent newIntent(Context context, String cityName) {
        Intent intent = new Intent(context, ShowActivity.class);
        intent.putExtra(KEY_CITY_NAME, cityName);
        return intent;
    }

    Button backBtn;
    TextView cityNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.show_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backBtn = findViewById(R.id.back_button);
        backBtn.setOnClickListener(v -> finish());
        cityNameView = findViewById(R.id.city_name_view);
        cityNameView.setText(getIntent().getStringExtra(KEY_CITY_NAME));
    }
}