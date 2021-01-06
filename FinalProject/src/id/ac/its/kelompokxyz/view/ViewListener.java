package id.ac.its.kelompokxyz.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import id.ac.its.kelompokxyz.controller.Controller;

public class ViewListener{

    boolean isGameOver;
    static Controller controller = new Controller();

    public ViewListener() {
        isGameOver = false;
    }

}
