package com.sokoban.controller;


import com.sokoban.model.Direction;

public interface EventListener {

    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);
}
