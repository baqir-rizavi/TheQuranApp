package com.example.thequranapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thequranapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // Views
    EditText surahNum, ayatNum;
    TextView quranText;
    Button btnNext, btnPrev;

    // handlers
    TextHandler textHandler;
    BtnHandler btnHandler;

    // others
    QuranArabicText quranArabicText;
    QDH quranHelper;
    int currentAyat = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // new objects
        textHandler = new TextHandler(this);
        btnHandler = new BtnHandler(this);

        quranArabicText = new QuranArabicText();
        quranHelper = new QDH();

        // setting ids
        surahNum = findViewById(R.id.surahNum);
        ayatNum = findViewById(R.id.ayatNum);
        quranText = findViewById(R.id.quranText);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);

        // setting event listeners/handlers
        surahNum.addTextChangedListener(textHandler);
        ayatNum.addTextChangedListener(textHandler);
        btnNext.setOnClickListener(btnHandler);
        btnPrev.setOnClickListener(btnHandler);
    }

    void fetchAyat()
    {
        // getting input
        String s = surahNum.getText().toString();
        String a = ayatNum.getText().toString();
        int surah = s.equals("") ? 1 : Integer.parseInt(s);
        int ayat = a.equals("") ? 1 : Integer.parseInt(a);
        currentAyat = ayat;

        // validating
        if (surah > quranHelper.SSP.length || surah < 1)
        {
            quranText.setText("there are only 114 surah in Quran plz enter valid surah Number");
        }
        else if (ayat > quranHelper.surahAyatCount[surah - 1] || ayat < 1)
        {
            quranText.setText(quranHelper.englishSurahNames[surah - 1] + " has only " +
                    quranHelper.surahAyatCount[surah - 1] + " ayaat plz enter" +
                    " a valid ayat number");
        }
        else
        {
            // finally setting text
            quranText.setText(
                    quranArabicText.QuranArabicText[quranHelper.SSP[surah - 1] + ayat - 1]);
        }
    }

    void fetchAyat(int surah, int ayat)
    {
        currentAyat = ayat;

        // validating
        if (surah > quranHelper.SSP.length || surah < 1)
        {
            quranText.setText("there are only 114 surah in Quran plz enter valid surah Number");
        }
        else if (ayat > quranHelper.surahAyatCount[surah - 1] || ayat < 1)
        {
            quranText.setText(quranHelper.englishSurahNames[surah - 1] + " has only " +
                    quranHelper.surahAyatCount[surah - 1] + " ayaat plz enter" +
                    " a valid ayat number");
        }
        else
        {
            // finally setting text
            quranText.setText(
                    quranArabicText.QuranArabicText[quranHelper.SSP[surah - 1] + ayat - 1]);
        }
    }

    public void fetchNext() {
        // getting input
        String s = surahNum.getText().toString();
        int surah = s.equals("") ? 1 : Integer.parseInt(s);
        fetchAyat(surah, currentAyat + 1);
    }

    public void fetchPrev() {
        String s = surahNum.getText().toString();
        int surah = s.equals("") ? 1 : Integer.parseInt(s);
        fetchAyat(surah, currentAyat - 1);
    }
}