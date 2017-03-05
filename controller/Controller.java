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
        model.restart();
        model.setEventListener(this);
        this.view = new View(this);
        view.init();
        view.setEventListener(this);
    }

    //Main
    public static void main(String[] args)
    {
        Controller controller = new Controller();
    }

    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }

    //Getters
    public GameObjects getGameObjects(){
        GameObjects result = model.getGameObjects();
        return result;
    }
}
