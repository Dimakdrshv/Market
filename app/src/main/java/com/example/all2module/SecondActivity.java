package com.example.all2module;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.all2module.databinding.LoginBinding;
import com.example.all2module.databinding.ShopBinding;

import java.lang.ref.Cleaner;

public class SecondActivity extends AppCompatActivity {
    public String text = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        ShopBinding binding = ShopBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+binding.phone.getText().toString()));
                startActivity(intent);
            }
        });
        binding.cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text += "Вы заказали фрукты\n";
            }
        });
        binding.cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text += "Вы заказали овощи\n";
            }
        });
        binding.cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text += "Вы заказали бакалею\n";
            }
        });
        binding.cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text += "Вы заказали молочное\n";
            }
        });
        binding.cb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text += "Вы заказали мясное\n";
            }
        });
        binding.cb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text += "Вы заказали замороженное\n";
            }
        });
        binding.RB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text += "Вы выбрали доставку\n";
            }
        });
        binding.RB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.isEnabled()) {
                    text += "Вы выбрали самовывоз\n";
                }
            }
        });
        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dimakudrashov13@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Напоминание о доставке");
                intent.putExtra(Intent.EXTRA_TEXT, text + binding.ET.getText().toString());
                startActivity(intent);
            }
        });
    }
}
