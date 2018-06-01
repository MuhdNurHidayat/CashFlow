package com.fish.cashflow;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Splash extends AppCompatActivity {

    private static String TAG = "Splash";

    private GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.d(TAG, "onCreate: starting splash");

        initComponent();

        //Set GIFImageView resource
        try{
            InputStream inputStream = getAssets().open("cash_flow_logo.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex)
        {
            Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
        }

        //Wait for 2 seconds and start next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //intent to BudgetPieChart activity
                Splash.this.startActivity(new Intent(Splash.this,BudgetPieChart.class));
                // bila tekan back dia tk pergi splash screen balik
                Splash.this.finish();
            }
        },2000);
    }

    /* Creating object */
    private void initComponent()
    {
        Log.d(TAG, "initComponent: Initialise all components");
        gifImageView = findViewById(R.id.splashLogo);
    }
}
