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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
                TextView ktory = (TextView) findViewById(R.id.ktory);
                String numerStr = editable.toString();
                if(numerStr.length()>0){
                    int numer = Integer.parseInt(numerStr);
                    ustawKota(numer);
                }
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