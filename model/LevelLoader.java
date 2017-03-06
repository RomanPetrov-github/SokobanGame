package com.sokoban.model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        if(level > 60){
            level = level % 60;
        }
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(levels.toString()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line.equals("Maze: " + level)) {
                    break;
                }
            }
            bufferedReader.readLine();
            String[] sizeX = bufferedReader.readLine().split(" ");
            String[] sizeY = bufferedReader.readLine().split(" ");

            int weight = Integer.parseInt(sizeX[2]);
            int height = Integer.parseInt(sizeY[2]);

            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();

            for (int y = 0; y < height; y++)
            {
                String line = bufferedReader.readLine();
                char[] chars = line.toCharArray();

                for (int x = 0; x < weight; x++)
                {
                    char sumbol = chars[x];

                    switch (sumbol) {
                        case ' ':
                            break;
                        case 'X':
                            walls.add(new Wall(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
                            break;
                        case '*':
                            boxes.add(new Box(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
                            break;
                        case '.':
                            homes.add(new Home(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
                            break;
                        case '&':
                            boxes.add(new Box(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
                            homes.add(new Home(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
                            break;
                        case '@':
                            player = new Player(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2);
                            break;
                    }

                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return new GameObjects(walls, boxes, homes, player);
    }
}
