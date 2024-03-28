package dev.lwnd.interactivegrid.objects.base;

import dev.lwnd.interactivegrid.area.Cell;

public abstract class BaseObject {
    private String name;
    private String description;
    private Cell attachedCell;

    public BaseObject(String name, String description, Cell cell) {
        this.name = name;
        this.description = description;
        this.attachedCell = cell;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Cell getAttachedCell() {
        return attachedCell;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAttachedCell(Cell attachedCell) {
        this.attachedCell = attachedCell;
    }
}
