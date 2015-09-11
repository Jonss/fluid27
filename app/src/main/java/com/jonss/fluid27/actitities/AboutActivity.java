package com.jonss.fluid27.actitities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jonss.fluid27.R;

public class AboutActivity extends AppCompatActivity {

    private TextView backToMainText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        backToMainText = (TextView) findViewById(R.id.back_to_main);
        backToMainText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
