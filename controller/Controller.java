package com.sokoban.controller;


import com.sokoban.model.Direction;
import com.sokoban.model.GameObjects;
import com.sokoban.model.Model;
import com.sokoban.view.View;

public class Controller implements EventListener{

    private View view;
    private Model model;

    //Constructor
    public Controller() {
        this.model = new Model();
        this.view = new View(this);
        view.init();
    }

    //Main
    public static void main(String[] args)
    {
        Controller controller = new Controller();
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void restart() {

    }

    @Override
    public void startNextLevel() {

    }

    @Override
    public void levelCompleted(int level) {

    }

    //Getters
    public GameObjects getGameObjects(){
        GameObjects result = model.getGameObjects();
        return result;
    }
}
