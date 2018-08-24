package com.example.polo.matrixraintest.rain;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by polo on 24/08/2018.
 */

public class Stream {

    private List<Symbol> symbols;
    private int totalSymbols;
    private int speed;
    private float x;
    private float y;
    private float symbolSize;
    private float opacity;


    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public int getTotalSymbols() {
        return totalSymbols;
    }

    public void setTotalSymbols(int totalSymbols) {
        this.totalSymbols = totalSymbols;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getOpacity() {
        return opacity;
    }

    public Stream(int frameCount, float x, float y, float symbolSize){

        Random random = new Random();
        this.totalSymbols = Math.round(random.nextInt(30 - 5) + 5);

        this.speed = Math.round(random.nextInt(20 - 5) + 5);
        this.x = x;
        this.y = y;
        this.symbolSize = symbolSize;
        this.opacity = Math.round(random.nextInt(5 - 0));


        generateSymbols(this.x,this.y,frameCount);

    }

    public void generateSymbols(float x,float y,int frameCount) {

        Random random = new Random();

        boolean first = Math.round(random.nextInt(4 - 0) + 0) == 1;

        symbols = new ArrayList<>();
        float decrement = this.y;
        for(int i=0;i<=totalSymbols;i++){

            Symbol symbol = new Symbol(x,decrement,this.speed,first);
            symbol.setToRandomCharacter(frameCount);
            symbols.add(symbol);
            decrement -=this.symbolSize;
            first = false;


        }


    }
}
