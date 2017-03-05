package com.sokoban.view;


import com.sokoban.controller.EventListener;
import com.sokoban.model.Direction;
import com.sokoban.model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Field extends JPanel{

    private View view;
    private EventListener eventListener;

    //Constructor
    public Field(View view){
        this.view = view;
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
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

    //InnerClass
    public class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode()){
                case (KeyEvent.VK_LEFT):
                    eventListener.move(Direction.LEFT);
                    break;
                case (KeyEvent.VK_RIGHT):
                    eventListener.move(Direction.RIGHT);
                    break;
                case (KeyEvent.VK_DOWN):
                    eventListener.move(Direction.DOWN);
                    break;
                case (KeyEvent.VK_UP):
                    eventListener.move(Direction.UP);
                    break;
                case (KeyEvent.VK_R):
                    eventListener.restart();
                    break;
            }
        }
    }
}
