package com.androidscanner.pdfscanner.activities;

import static com.androidscanner.pdfscanner.Constants.ADD_WATERMARK;
import static com.androidscanner.pdfscanner.Constants.BUNDLE_DATA;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.androidscanner.pdfscanner.fragment.ExceltoPdfFragment;
import com.androidscanner.pdfscanner.fragment.HistoryFragment;
import com.androidscanner.pdfscanner.fragment.ImageToPdfFragment;
import com.androidscanner.pdfscanner.fragment.QrBarcodeScanFragment;
import com.androidscanner.pdfscanner.fragment.SettingsFragment;
import com.androidscanner.pdfscanner.fragment.ViewFilesFragment;
import com.androidscanner.pdfscanner.fragment.texttopdf.TextToPdfFragment;

import androidmarket.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second);


        Intent intent = getIntent();
        String fragment = intent.getStringExtra("fragment");


        if (fragment.equals("imgToPdf")) {
            ImageToPdfFragment recentFragment = new ImageToPdfFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, recentFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (fragment.equals("textToPdf")) {
            TextToPdfFragment recentFragment = new TextToPdfFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, recentFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (fragment.equals("qrToPdf")) {
            QrBarcodeScanFragment recentFragment = new QrBarcodeScanFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, recentFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (fragment.equals("excelToPdf")) {
            ExceltoPdfFragment recentFragment = new ExceltoPdfFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, recentFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (fragment.equals("watermark")) {
            Fragment fragmentWatermark;
            Bundle bundle = new Bundle();
            fragmentWatermark = new ViewFilesFragment();
            bundle.putInt(BUNDLE_DATA, ADD_WATERMARK);
            fragmentWatermark.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, fragmentWatermark);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (fragment.equals("view")) {
            ViewFilesFragment recentFragment = new ViewFilesFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, recentFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (fragment.equals("settings")) {
            SettingsFragment recentFragment = new SettingsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, recentFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (fragment.equals("history")) {
            HistoryFragment recentFragment = new HistoryFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, recentFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}