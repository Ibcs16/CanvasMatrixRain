package com.example.polo.matrixraintest;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;

import com.example.polo.matrixraintest.rain.Symbol;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MatrixRain matrixRain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        //Gets device display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        //gets device height
        int largura = size.x;
        //gets device width
        int altura = size.y;

        Random rand = new Random();

        matrixRain = new MatrixRain(this,largura,altura,rand);


        Log.i("Medidas->","x:"+largura+" - y:"+altura);


        setContentView(matrixRain);




    }
}
