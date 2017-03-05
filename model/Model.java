package com.sokoban.model;


import com.sokoban.controller.EventListener;

import java.nio.file.Paths;

public class Model {

    public static final int FIELD_SELL_SIZE = 20;

    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader =
            new LevelLoader(Paths.get("C:\\Developer\\MyProjects\\Java\\Sokoban\\src\\com\\sokoban\\res\\levels.txt"));

    //Methods
    public void move(Direction direction){
        //TODO
    }

    public void restart(){
        restartLevel(currentLevel);
    }

    public void restartLevel(int level){
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void startNextLevel(){
        restartLevel(++currentLevel);
    }

    //Setters
    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    //Getters
    public GameObjects getGameObjects(){
        return gameObjects;
    }
}
