package com.example.all2module;

import static com.example.all2module.loginPresenter.deleteAllSharedPrefs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.all2module.databinding.LoginBinding;
import com.example.all2module.databinding.PersonBinding;

public class Person extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PersonBinding binding = PersonBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Person.this, SecondActivity.class);
                PersonInfo user = new PersonInfo(binding.name.getText().toString(), binding.username.getText().toString());
                intent.putExtra("info", user);
                startActivity(intent);
            }
        });
        binding.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAllSharedPrefs();
                Intent intent = new Intent(Person.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
