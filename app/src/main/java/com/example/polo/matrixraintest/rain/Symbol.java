package com.example.polo.matrixraintest.rain;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

import com.example.polo.matrixraintest.util.StringUtil;

import java.util.Random;

/**
 * Created by polo on 24/08/2018.
 */

public class Symbol {

    private float x;
    private float y;
    private String valor;
    private float speed;
    private int switchInterval;
    private boolean first;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getValor() {
        return valor;
    }

    public float getX() {
        return x;
    }

    public boolean isFirst() {
        return first;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setToRandomCharacter(int frameCount) {
        Random rand = new Random();
        int randNumber = rand.nextInt(97);


        if (frameCount % this.switchInterval == 0) {
            valor = StringUtil.fromCharCode(0x30A0 + Math.round(randNumber));

        }


        Log.i("character->", valor);
    }


    public Symbol(float x, float y,float speed,boolean first) {
        //super(context);
        this.x = x;
        this.y = y;
        this.speed = speed;
        Random random = new Random();
        switchInterval = Math.round(random.nextInt(20 - 2) + 2);
        this.first = first;
        //this.speed = speed;
    }

    public void increaseRainSpeed() {
        this.setY(this.getY() + this.speed);

    }


}
