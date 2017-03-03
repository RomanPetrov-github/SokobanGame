package com.sokoban.view;


import com.sokoban.controller.Controller;
import com.sokoban.controller.EventListener;

import javax.swing.*;

public class View extends JFrame{

    private Controller controller;
    private Field field;

    public View(Controller controller){
        this.controller = controller;
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }

    public void setEventListener(EventListener eventListener){
        this.field.setEventListener(eventListener);
    }
}
