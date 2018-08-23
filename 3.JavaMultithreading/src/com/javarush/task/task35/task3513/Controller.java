package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private static final int WINNING_TILE = 2048;
    Model model;
    View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public void resetGame() {
        view.isGameLost = false;
        view.isGameWon = false;
        model.score = 0;
        model.resetGameTiles();
    }

    public View getView() {
        return view;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
//            return;
        }
        if (!model.canMove()) view.isGameLost = true;
/*
        if (view.isGameLost || view.isGameWon) return;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                model.left();
                break;
            case KeyEvent.VK_RIGHT:
                model.right();
                break;
            case KeyEvent.VK_UP:
                model.up();
                break;
            case KeyEvent.VK_DOWN:
                model.down();
                break;
        }
*/
        if (!view.isGameLost && !view.isGameWon){
            if (e.getKeyCode() == KeyEvent.VK_LEFT) model.left();
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT) model.right();
            else if(e.getKeyCode() == KeyEvent.VK_UP) model.up();
            else if(e.getKeyCode() == KeyEvent.VK_DOWN) model.down();
            else if(e.getKeyCode() == KeyEvent.VK_Z) model.rollback();
            else if(e.getKeyCode() == KeyEvent.VK_R) model.randomMove();
            else if(e.getKeyCode() == KeyEvent.VK_A     ) model.autoMove();
        }

        if (model.maxTile == WINNING_TILE)
            view.isGameWon = true;

        view.repaint();
    }
}
