package com.sokoban.view;


import com.sokoban.controller.EventListener;
import com.sokoban.model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class Field extends JPanel{

    private View view;
    private EventListener eventListener;

    //Constructor
    public Field(View view){
        this.view = view;
    }

    // Methods
    public void paint(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 500, 500);

        Set<GameObject> gameObjectSet = view.getGameObjects().getAll();

        for (GameObject x: gameObjectSet){
            x.draw(g);
        }
    }

    //Setters
    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }
}
