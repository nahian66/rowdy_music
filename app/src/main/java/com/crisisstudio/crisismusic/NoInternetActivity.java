package com.crisisstudio.crisismusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class NoInternetActivity extends AppCompatActivity {

    Button tryagain_btn;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);


        tryagain_btn = findViewById(R.id.tryagain_btn);
        progressBar = findViewById(R.id.progressBar);



        // statusbar text color
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(NoInternetActivity.this, R.color.gray));



        // connectivity check
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


        if ( networkInfo!=null && networkInfo.isConnected() ){

            progressBar.setVisibility(View.GONE);
            startActivity(new Intent(NoInternetActivity.this, MainActivity.class));

        } else {


            tryagain_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    // connectivity check again
                    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


                    progressBar.setVisibility(View.VISIBLE);


                    if ( networkInfo!=null && networkInfo.isConnected() ){

                        progressBar.setVisibility(View.GONE);
                        startActivity(new Intent(NoInternetActivity.this, MainActivity.class));

                    } else{

                        Toast.makeText(NoInternetActivity.this, "No Internet", Toast.LENGTH_SHORT).show();

                    }

                    return;

                }
            });


        }









    }
}