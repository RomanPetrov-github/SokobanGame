package com.sokoban.view;


import com.sokoban.controller.Controller;

import javax.swing.*;

public class View extends JFrame{
    private Controller controller;

    public View(Controller controller){
        this.controller = controller;
    }
}
