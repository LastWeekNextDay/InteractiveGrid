package dev.lwnd.interactivegrid.objects.base;

import dev.lwnd.interactivegrid.area.Cell;

public abstract class Interactor extends BaseObject {

    public Interactor(String name, String description, Cell cell) {
        super(name, description, cell);
    }

    public abstract void interact();
}
