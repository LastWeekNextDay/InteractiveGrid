package dev.lwnd.interactivegrid.area;

import dev.lwnd.interactivegrid.area.base.BaseGrid;
import dev.lwnd.interactivegrid.objects.base.BaseObject;

public class Cell {
    private int x;
    private int y;
    private boolean isOccupied;
    private BaseObject attachedObject;
    private BaseGrid baseGrid;

    public Cell(int x, int y, BaseGrid baseGrid) {
        this.x = x;
        this.y = y;
        this.baseGrid = baseGrid;
        this.isOccupied = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public BaseObject getAttachedObject() {
        return attachedObject;
    }

    public BaseGrid getBaseGrid() {
        return baseGrid;
    }
    public void setBaseGrid(BaseGrid baseGrid) {
        this.baseGrid = baseGrid;
    }

    public void attachToGrid(BaseGrid grid) {
        this.baseGrid = grid;
        grid.setCell(this.y, this.x, this);
    }

    public void attachObject(BaseObject object) {
        object.setAttachedCell(this);
        isOccupied = true;
        attachedObject = object;
    }

    public void detach() {
        attachedObject.setAttachedCell(null);
        isOccupied = false;
        attachedObject = null;
    }
}
