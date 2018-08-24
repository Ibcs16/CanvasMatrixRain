package com.example.polo.matrixraintest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import com.example.polo.matrixraintest.rain.Stream;
import com.example.polo.matrixraintest.rain.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by polo on 24/08/2018.
 */

public class MatrixRain extends View {

    //tamanho da tela do dispositivo
    private int wArea;
    private int hArea;

    //private Symbol symbol;
    private List<Stream> streams;
    private int frameCount = 0;
    private int symbolSize = 65;
    private float fadeInterval = 1.2f;

    private Paint mPaint = new Paint();

    private Rect rect = new Rect();

    private Random rand;


    public MatrixRain(Context context,int width,int height,Random rand) {
        super(context);

        //Sets width and height
        this.wArea = width;
        this.hArea = height;

        streams = new ArrayList<>();
        this.rand = rand;

        //x coordinate of each stream (increases by every created stream)
        float x=0;

        //randomically picks a start point for y coordinate
        //giving a striking effect
        float y= Math.round(rand.nextInt(0 - (-1000)) + (-1000));


        //creates streams based on how many of them fits screen width
        //and pass them to a stream array
        for(int i =0;i<=this.wArea/this.symbolSize;i++){

            Stream stream = new Stream(frameCount,x, y,symbolSize);
            streams.add(stream);
            x+=symbolSize;

        }



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        rect.set(0, 0, wArea, hArea * 2);

        rect.centerX();
        rect.centerY();

        mPaint.setAntiAlias(true);

        //fundo do contagiro gráfico
        mPaint.setColor(Color.BLACK);

        canvas.drawRect(rect, mPaint);

        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        mPaint.setTextSize(symbolSize);


        for(int i = 0;i<streams.size();i++) {

            for(int z =0;z<=streams.get(i).getTotalSymbols();z++){

                Log.i("simbolo",streams.get(i).getSymbols().get(z).getValor());
                if(streams.get(i).getSymbols().get(z).isFirst()){

                    mPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccentFirst));

                }else {
                    mPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                }

                int paintAlpha=Math.round(((float)(255/streams.get(i).getTotalSymbols()*streams.get(i).getOpacity())/fadeInterval)/100*255);

                mPaint.setAlpha(paintAlpha);

                canvas.drawText(streams.get(i).getSymbols().get(z).getValor(),
                        streams.get(i).getSymbols().get(z).getX(), streams.get(i).getSymbols().get(z).getY(), mPaint);

                if (streams.get(i).getSymbols().get(z).getY() >= hArea) {
                    streams.get(i).getSymbols().get(z).setY(0);
                } else {
                    streams.get(i).getSymbols().get(z).increaseRainSpeed();
                }
                streams.get(i).getSymbols().get(z).setToRandomCharacter(frameCount);
           }

        }

        frameCount++;
        invalidate();




    }



}
