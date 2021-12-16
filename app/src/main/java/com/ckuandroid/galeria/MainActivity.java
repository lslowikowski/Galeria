package com.ckuandroid.galeria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
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
                kotek.setImageResource(R.drawable.kot1);
        }
    }

    public void wybor(View view) {
        //EditText wybor = (EditText) findViewById(R.id.wybor);
        EditText wybor = (EditText) view;
        String wyborStr = wybor.getText().toString();
        if(wyborStr.length()>0) {
            int wyborInt = Integer.parseInt(wyborStr);
            if (wyborInt > 0 && wyborInt < 5) ustawKota(wyborInt);
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