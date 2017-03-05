package com.sokoban.view;


import com.sokoban.controller.Controller;
import com.sokoban.controller.EventListener;
import com.sokoban.model.GameObjects;

import javax.swing.*;

public class View extends JFrame{

    private Controller controller;
    private Field field;

    //Constructor
    public View(Controller controller){
        this.controller = controller;
    }

    //Methods
    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }

    public void update(){
        field.repaint();
    }

    public void completed(int level){
        update();
        JOptionPane.showMessageDialog(null, level + " Completed ", " Level ", JOptionPane.INFORMATION_MESSAGE);
        controller.startNextLevel();
    }

    //Getters
    public GameObjects getGameObjects(){
        GameObjects result = controller.getGameObjects();
        return result;
    }

    //Setters
    public void setEventListener(EventListener eventListener){
        this.field.setEventListener(eventListener);
    }
}
