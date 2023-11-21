package com.example.all2module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.all2module.databinding.ActivityMainBinding;
import com.example.all2module.databinding.LoginBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginBinding binding = LoginBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        SharedPreferences mPref = getPreferences(MODE_PRIVATE);

        loginPresenter presenter = new loginPresenter(this, binding, mPref);

        if (presenter.signInPref()) {
            Intent intent = new Intent(MainActivity.this, Person.class);
            startActivity(intent);
        }

        binding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (presenter.signIn()) {
                    Intent intent = new Intent(MainActivity.this, Person.class);
                    startActivity(intent);
                };
            }
        });
    }
}