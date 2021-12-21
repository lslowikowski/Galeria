package com.ckuandroid.galeria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int nrObrazu = 1;
    boolean niebieskiKolor = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText wybor = (EditText) findViewById(R.id.wybor);
        wybor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String numerStr = editable.toString();
                if(numerStr.length()>0) {
                    int numerInt = Integer.parseInt(numerStr);
                    ustawKota(numerInt);
                }
            }
        });
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               Integer postep = seekBar.getProgress();
               ustawKota(postep);
            }
        });

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                float ocena = ratingBar.getRating();
                int ocenaInt = (int) ocena;
                ustawKota(ocenaInt);
            }
        });


        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);

        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ustawKota(1);
            }
        });

        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ustawKota(2);
            }
        });

        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ustawKota(3);
            }
        });

        radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ustawKota(4);
            }
        });


    }

    public void prev(View view) {
        nrObrazu --;
        if(nrObrazu==0) nrObrazu = 4;
        ustawKota(nrObrazu);

    }

    public void next(View view) {
        nrObrazu ++;
        if(nrObrazu==5) nrObrazu = 1;
        ustawKota(nrObrazu);
    }

    public void ustawKota(int nrKota){
        ImageView kotek = (ImageView) findViewById(R.id.kotek);
        switch (nrKota) {
            case 1:
                kotek.setImageResource(R.drawable.kot1);
                break;
            case 2:
                kotek.setImageResource(R.drawable.kot2);
                break;
            case 3:
                kotek.setImageResource(R.drawable.kot3);
                break;
            case 4:
                kotek.setImageResource(R.drawable.kot4);
                break;
            default:
//                kotek.setImageResource(R.drawable.kot1);
        }
    }


    @SuppressLint("ResourceAsColor")
    public void zmienTlo(View view) {
        LinearLayout glowne = (LinearLayout) findViewById(R.id.glowne);
        RelativeLayout przyciski = (RelativeLayout) findViewById(R.id.przyciski);
        TextView tytul = (TextView) findViewById(R.id.tytul);
        if(niebieskiKolor){
            //glowne.setBackgroundColor(R.color.zielony);
            glowne.setBackgroundColor(0xFF00796B);
            przyciski.setBackgroundColor(0xFF00796B);
            tytul.setBackgroundColor(0xFF00796B);
            //glowne.setBackgroundColor(Color.RED);
            niebieskiKolor = false;
        }else{

            //glowne.setBackgroundColor(R.color.niebieski);
            glowne.setBackgroundColor(0xFF1565c0);
            przyciski.setBackgroundColor(0xFF1565c0);
            tytul.setBackgroundColor(0xFF1565c0);
            //glowne.setBackgroundColor(Color.BLUE);
            niebieskiKolor = true;
        }

    }
}