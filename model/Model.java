package com.sokoban.model;


import com.sokoban.controller.EventListener;

public class Model {

    public static final int FIELD_SELL_SIZE = 20;

    private EventListener eventListener;

    //Setters
    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }
}
