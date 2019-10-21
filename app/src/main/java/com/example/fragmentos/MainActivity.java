package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        FragmentOne.OnFragmentInteractionListener,
        FragmentTwo.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        FragmentOne fragment = FragmentOne.newInstance("Mensaje", 0);
        fragmentTransaction.add(R.id.fragmentOne, fragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public void onFragmentInteraction(String message, int colorid) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        FragmentTwo fragment = FragmentTwo.newInstance(message, colorid);
        fragmentTransaction.replace(R.id.fragmentTwo, fragment);
        fragmentTransaction.commit();
    }
}