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
        Player player = getGameObjects().getPlayer();
        if((checkWallCollision(player, direction)) || (checkBoxCollision(direction))){
            return;
        }
        switch (direction){
            case LEFT:
                player.move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_SELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_SELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_SELL_SIZE);
                break;
        }
        checkCompletion();
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

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for(Wall wall: gameObjects.getWalls()){
            if(gameObject.isCollision(wall, direction)){
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction){
        Player player = gameObjects.getPlayer();
        GameObject tmp = null;
        for(GameObject x: getGameObjects().getAll()){
            if(!(x instanceof Player) && !(x instanceof Home) && player.isCollision(x, direction)){
                tmp = x;
            }
        }
        if(tmp == null){
            return false;
        }
        if(tmp instanceof Box){
            Box box = (Box) tmp;
            if(checkWallCollision(box, direction)){
                return true;
            }
            for(Box x: getGameObjects().getBoxes()){
                if (box.isCollision(x, direction)) {
                    return true;
                }
            }
            switch (direction)
            {
                case LEFT:
                    box.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    box.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    box.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    box.move(0, FIELD_SELL_SIZE);
            }
        }
        return  false;
    }

    public void checkCompletion(){
        boolean levelComplete = true;
        for(Home home: getGameObjects().getHomes()){
            boolean currentHome = false;
            for(Box box: getGameObjects().getBoxes()){
                if((box.getX() == home.getX()) && (box.getY() == home.getY())){
                    currentHome = true;
                }
            }
            if(!currentHome){
                levelComplete = false;
            }
        }
        if(levelComplete){
            eventListener.levelCompleted(currentLevel);
        }
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
