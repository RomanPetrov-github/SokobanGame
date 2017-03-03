package com.sokoban.view;


import com.sokoban.controller.EventListener;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel{

    private View view;
    private EventListener eventListener;

    public Field(View view){
        this.view = view;
    }

    public void paint(Graphics g){

    }

    //Setters
    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }
}
