package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private static final String EMPTY = "";

    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private int countClosedTiles = SIDE * SIDE;
    private int score;

    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        boolean mine;
//        countMinesOnField = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellValue(i, j, EMPTY);
            }
        }

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                int rn = getRandomNumber(10);
                if (rn == 1) {
                    mine = true;
                    countMinesOnField++;
                } else mine = false;
                gameField[i][j] = new GameObject(j, i, mine);
                setCellColor(gameField[i][j].x, gameField[i][j].y, Color.LIME);
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> neighbors = new ArrayList<>();
        int x = gameObject.x;
        int y = gameObject.y;

        addNeighbor(y + 1, x, neighbors);
        addNeighbor(y - 1, x, neighbors);
        addNeighbor(y, x + 1, neighbors);
        addNeighbor(y, x - 1, neighbors);
        addNeighbor(y + 1, x + 1, neighbors);
        addNeighbor(y - 1, x + 1, neighbors);
        addNeighbor(y + 1, x - 1, neighbors);
        addNeighbor(y - 1, x - 1, neighbors);
/*
        if (x == 0 && y == 0) {
            neighbors.add(gameField[y + 1][x]);
            neighbors.add(gameField[y][x + 1]);
            neighbors.add(gameField[y + 1][x + 1]);
        } else if (x == 0 && y == SIDE-1) {
            neighbors.add(gameField[y - 1][x]);
            neighbors.add(gameField[y][x + 1]);
            neighbors.add(gameField[y + 1][x + 1]);
        } else if (x == SIDE-1 && y == 0) {
            neighbors.add(gameField[y + 1][x]);
            neighbors.add(gameField[y][x - 1]);
            neighbors.add(gameField[y + 1][x - 1]);
        } else if (y == SIDE - 1 && x == SIDE - 1) {
            neighbors.add(gameField[y - 1][x]);
            neighbors.add(gameField[y][x - 1]);
            neighbors.add(gameField[y - 1][x - 1]);
        } else if (x == 0 && y > 0) {
            neighbors.add(gameField[y + 1][x]);
            neighbors.add(gameField[y][x + 1]);
            neighbors.add(gameField[y + 1][x + 1]);
            neighbors.add(gameField[y - 1][x]);
            neighbors.add(gameField[y - 1][x + 1]);
        } else if (y == 0 && x > 0) {
            neighbors.add(gameField[y + 1][x]);
            neighbors.add(gameField[y][x + 1]);
            neighbors.add(gameField[y + 1][x + 1]);
            neighbors.add(gameField[y][x - 1]);
            neighbors.add(gameField[y + 1][x - 1]);
        } else if (y == SIDE - 1 && x < SIDE - 1) {
            neighbors.add(gameField[y - 1][x]);
            neighbors.add(gameField[y][x + 1]);
            neighbors.add(gameField[y][x - 1]);
            neighbors.add(gameField[y - 1][x + 1]);
            neighbors.add(gameField[y - 1][x - 1]);
        } else if (x == SIDE - 1 && y < SIDE - 1) {
            neighbors.add(gameField[y + 1][x]);
            neighbors.add(gameField[y - 1][x]);
            neighbors.add(gameField[y][x - 1]);
            neighbors.add(gameField[y + 1][x - 1]);
            neighbors.add(gameField[y - 1][x - 1]);
        } else {
            neighbors.add(gameField[y + 1][x]);
            neighbors.add(gameField[y - 1][x]);
            neighbors.add(gameField[y][x + 1]);
            neighbors.add(gameField[y][x - 1]);
            neighbors.add(gameField[y + 1][x + 1]);
            neighbors.add(gameField[y - 1][x + 1]);
            neighbors.add(gameField[y + 1][x - 1]);
            neighbors.add(gameField[y - 1][x - 1]);
        }
*/
        return neighbors;
    }

    private void addNeighbor(int y, int x, List<GameObject> neighbors) {
        try {
            neighbors.add(gameField[y][x]);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    private void countMineNeighbors() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                GameObject cell = gameField[i][j];
                if (cell.isMine) continue;

                List<GameObject> neighbors = getNeighbors(cell);
                int countMineNeighbors = 0;
                for (GameObject neighbor : neighbors) {
                    if (neighbor.isMine) countMineNeighbors++;
                }
                cell.countMineNeighbors = countMineNeighbors;
            }
        }
    }

    private void openTile(int x, int y) {
        GameObject cell = gameField[y][x];
        if (cell.isOpen || cell.isFlag || isGameStopped) return;

        cell.isOpen = true;
        countClosedTiles--;
        setCellColor(x, y, Color.ORANGE);

        if (cell.isMine) {
//            setCellValue(x, y, MINE);
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else if (!cell.isMine && cell.countMineNeighbors == 0) {
            List<GameObject> neighbors = getNeighbors(cell);
            setCellValue(cell.x, cell.y, EMPTY);
            for (GameObject neighbor : neighbors) {
                if (!neighbor.isOpen)
                    openTile(neighbor.x, neighbor.y);
            }
        } else setCellNumber(x, y, cell.countMineNeighbors);

        if (!cell.isMine && countClosedTiles == countMinesOnField) win();
        if (!cell.isMine) {
            score += 5;
            setScore(score);
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped)
            restart();
        else
            openTile(x, y);
    }

    private void markTile(int x, int y) {

        GameObject cell = gameField[y][x];

        if (cell.isOpen || (countFlags == 0 && !cell.isFlag) || isGameStopped) return;

        if (!cell.isFlag) {
            cell.isFlag = true;
            countFlags--;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        } else {
            cell.isFlag = false;
            countFlags++;
            setCellValue(x, y, EMPTY);
            setCellColor(x, y, Color.LIME);
        }

    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "Game over!", Color.BLACK, 15);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.LIGHTGRAY, "You win!", Color.GOLD, 25);
    }

    private void restart() {
        isGameStopped = false;
        countMinesOnField = 0;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        setScore(score);
        createGame();

    }
}
