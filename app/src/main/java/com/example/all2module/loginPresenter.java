package com.example.all2module;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.all2module.databinding.LoginBinding;

public class loginPresenter {
    private static String TRUELOGIN = "1234";
    private static String TRUEPASSWORD = "1234";
    private Context context;
    private static SharedPreferences mPref;
    private LoginBinding binding;

    public loginPresenter(Context context, LoginBinding binding, SharedPreferences mPref) {
        this.binding = binding;
        this.context = context;
        this.mPref = mPref;
    }

    public boolean signInPref(){
        String loginPref = mPref.getString("LOGIN", "");
        String passwordPref = mPref.getString("PASSWORD", "");

        if (loginPref.equals(TRUELOGIN) && passwordPref.equals(TRUEPASSWORD)) {
            return true;
        }
        return false;
    }

    public boolean signIn(){

        SharedPreferences.Editor edit = mPref.edit();

        String login = binding.login.getText().toString();
        String password = binding.password.getText().toString();
        if (login.equals(TRUELOGIN) && password.equals(TRUEPASSWORD)) {
            edit.putString("LOGIN", login);
            edit.putString("PASSWORD", password);
            edit.commit();
            return true;
        }
        return false;
    }
    public static void deleteAllSharedPrefs(){
        mPref.edit().clear().commit();
    }
}
