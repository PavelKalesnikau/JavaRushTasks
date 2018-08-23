package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;   // размер игрового поля
    private Tile[][] gameTiles;                 // игровое поле
    int score;                          // текущий счет
    int maxTile;                        // максимальный вес плитки на игровом поле

    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    boolean isSaveNeeded = true;

    public static void main(String[] args) {
        // test 1
        Tile tile1 = new Tile();
        tile1.value = 0;
        Tile tile2 = new Tile();
        tile2.value = 0;
        Tile tile3 = new Tile();
        tile3.value = 4;
        Tile tile4 = new Tile();
        tile4.value = 2;

        Tile[] tiles = new Tile[]{tile1, tile2, tile3, tile4};
        Model model = new Model();
        model.compressTiles(tiles);
        model.mergeTiles(tiles);
// test 2
        Tile tile5 = new Tile();
        Tile tile6 = new Tile();
        Tile tile7 = new Tile();
        Tile tile8 = new Tile();

        tile5.value = 4;
        tile6.value = 4;
        tile7.value = 4;
        tile8.value = 4;

        Tile[] tiles2 = new Tile[]{tile5, tile6, tile7, tile8};
        Model model2 = new Model();
        model2.compressTiles(tiles2);
        model2.mergeTiles(tiles2);

        //test3
        Model model3 = new Model();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile tile = new Tile();
                tile.value = (int) (Math.random() * 10) < 5 ? 2 : 4;
                model3.gameTiles[i][j] = tile;
            }
        }

        model3.left();
    }

    public Model() {
        resetGameTiles();
        previousStates = new Stack();
        previousScores = new Stack();
    }

    void resetGameTiles() {
        // initialize the field
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        // add two Tiles on start
        addTile();
        addTile();

        score = 0;
        maxTile = 2;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles != null && emptyTiles.size() != 0) {
            Tile randomTile = emptyTiles.get((int) (emptyTiles.size() * Math.random()));
            randomTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<Tile>();

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile tile = gameTiles[i][j];
                if (tile.isEmpty()) emptyTiles.add(tile);
            }
        }
        return emptyTiles;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isCompressed = false;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value == 0) {
                for (int j = i + 1; j < tiles.length; j++) {
                    if (tiles[j].value != 0) {
                        // i-плитка = 0, если j-плитка !=0, то меняем их местами, т.е. переносим 0 в крайнее положение массива
                        Tile temp = tiles[i];
                        tiles[i] = tiles[j];
                        tiles[j] = temp;
                        isCompressed = true;
                        break;
                    }
                }
            }
        }
        return isCompressed;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isMerged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value != 0) { // если значение плиток равно,
                tiles[i].value *= 2;     // то складываем их (умножаем на 2)
                score += tiles[i].value; // Увеличиваем значение поля на величину веса плитки образовавшейся в результате слияния.
                if (maxTile < tiles[i].value)
                    maxTile = tiles[i].value; // обновляем максимальное значение, если новое слияние больше.

                for (int j = i + 1; j < tiles.length - 1; j++) { // остальные плитки сдвигаем к сложенной
                    tiles[j] = tiles[j + 1];
                }
                tiles[FIELD_WIDTH - 1] = new Tile(); // записываем в последнюю, добавившуюся позицию новую плитку со значением 0
                isMerged = true;
            }
        }
        return isMerged;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            boolean isCompressed = compressTiles(gameTiles[i]);
            boolean isMerged = mergeTiles(gameTiles[i]);
            if (isCompressed || isMerged)
                isChanged = true;
        }
        if (isChanged) {
            addTile();
            isSaveNeeded = true;
        }
    }

    public void right() {
        saveState(gameTiles);
        // to move right, we need turn the gameTiles 180 clockwise,
        // move it left, and back it to initial state (rotate it 180 counterclockwise).
        gameTiles = rotateMatrix(rotateMatrix(gameTiles)); // rotate it 180 degrees
        left();
        gameTiles = rotateMatrix(rotateMatrix(gameTiles)); // rotate it back 180 degrees
    }

    public void up() {
        saveState(gameTiles);
        // to move up, we need turn the gameTiles 270 clockwise,
        // move it left, and back it to initial state (rotate it 90 counterclockwise).
        gameTiles = rotateMatrix(rotateMatrix(rotateMatrix(gameTiles))); // turn it 270 degrees
        left();
        gameTiles = rotateMatrix(gameTiles); // rotate it back 90 degrees
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public void down() {
        saveState(gameTiles);
        // to move down, we need turn the gameTiles 90 clockwise,
        // move it left, and back it to initial state (rotate it 270 counterclockwise).
        gameTiles = rotateMatrix(gameTiles); // rotate it 90 degrees
        left();
        gameTiles = rotateMatrix(rotateMatrix(rotateMatrix(gameTiles))); // rotate it 270 degrees back

    }

    /**
     * It rotates the matrix 90 degrees clockwise
     *
     * @param array - matrix to rotate
     * @return rotated matrix
     */
    public Tile[][] rotateMatrix(Tile[][] array) {
        Tile[][] rotated = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; ++i) {
            for (int j = 0; j < FIELD_WIDTH; ++j) {
                rotated[i][j] = array[FIELD_WIDTH - j - 1][i];
            }
        }
        return rotated;
    }

    public boolean canMove() {
        boolean canMove = false;
        if (!getEmptyTiles().isEmpty())
            return true;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 1; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true; // проверяем две смежные части по строке
            }
        }
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == gameTiles[i + 1][j].value)
                    return true; // проверяем две смежные части по столбцу
            }
        }
        return canMove;
    }

    private void saveState(Tile[][] currentState) {
        Tile[][] stateToSave = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                stateToSave[i][j] = new Tile(currentState[i][j].value);

            }
        }
        previousStates.push(stateToSave);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (previousStates == null || previousScores == null || previousStates.empty() || previousScores.empty())
            return;

        gameTiles = previousStates.pop();
        score = previousScores.pop();
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 1:
                right();
                break;
            case 2:
                left();
                break;
            case 3:
                up();
                break;
            case 4:
                down();
                break;
        }
    }

    public boolean hasBoardChanged(){
        int currentWeightTiles = getWeightTiles(gameTiles);

        int previousWeightTiles = 0;
        if (!previousStates.empty())
         previousWeightTiles = getWeightTiles(previousStates.peek());

        if (currentWeightTiles != previousWeightTiles ) return true;
        else return false;
    }

    private int getWeightTiles(Tile[][] tiles){
        int sumValue = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                sumValue += tiles[i][j].value;
            }
        }
        return sumValue;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency moveEfficiency;
        move.move();

        if (hasBoardChanged())
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move );
        else
            moveEfficiency = new MoveEfficiency(-1, 0, move);

        rollback();
        return moveEfficiency;
    }
    public void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<MoveEfficiency>(4, Collections.reverseOrder());
/*
        priorityQueue.offer(new MoveEfficiency(getEmptyTiles().size(), score, new Move() {
            @Override
            public void move() {
                left();
            }
        }));
*/
        priorityQueue.offer(new MoveEfficiency(getEmptyTiles().size(), score, this::left));
        priorityQueue.offer(new MoveEfficiency(getEmptyTiles().size(), score, this::right));
        priorityQueue.offer(new MoveEfficiency(getEmptyTiles().size(), score, this::up));
        priorityQueue.offer(new MoveEfficiency(getEmptyTiles().size(), score, this::down));

        priorityQueue.peek().getMove().move();
    }
}
