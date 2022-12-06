package com.example.thequranapp;

import android.view.View;

public class BtnHandler implements View.OnClickListener {
    MainActivity mainActivity;

    BtnHandler(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnNext)
        {
            mainActivity.fetchNext();
        }
        else if (view.getId() == R.id.btnPrev)
        {
            mainActivity.fetchPrev();
        }
    }
}
