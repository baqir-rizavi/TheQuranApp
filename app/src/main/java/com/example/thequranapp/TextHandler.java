package com.example.thequranapp;


import android.text.Editable;
import android.text.TextWatcher;

public class TextHandler implements TextWatcher {
    MainActivity mainActivity;

    TextHandler(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        mainActivity.fetchAyat();
    }
}
