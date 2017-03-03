package com.sokoban.model;


import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {

    private Path levels;

    //Constructors
    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    //Methods
    public GameObjects getLevel(int level){
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = new Player(Model.FIELD_SELL_SIZE/2, Model.FIELD_SELL_SIZE/2);

        return new GameObjects(walls, boxes, homes,player);
    }
}
