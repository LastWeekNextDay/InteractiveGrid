package dev.lwnd.interactivegrid.area.base;

import dev.lwnd.interactivegrid.area.Cell;

public abstract class BaseGrid {
    private Cell[][] cells;

    public BaseGrid(int rows, int cols) {
        cells = new Cell[rows][cols];
    }

    public Cell getCell(int row, int col) {
        if (row < 0 || row >= cells.length || col < 0 || col >= cells[0].length) {
            return null;
        }

        return cells[row][col];
    }

    public void setCell(int row, int col, Cell cell) {
        if (row < 0 || row >= cells.length || col < 0 || col >= cells[0].length) {
            return;
        }

        cells[row][col] = cell;
    }
}
