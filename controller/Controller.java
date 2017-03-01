package com.sokoban.controller;


import com.sokoban.model.Model;
import com.sokoban.view.View;

public class Controller {

    private View view;
    private Model model;

    public Controller() {
        this.model = new Model();
        this.view = new View(this);
    }
}
