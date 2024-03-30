package dev.lwnd.interactivegrid.objects.base;

import dev.lwnd.interactivegrid.area.Cell;

public abstract class Interactor extends BaseObject {

    public Interactor(String name, String description, Cell cell, String imagePath) {
        super(name, description, cell, imagePath);
    }

    public abstract void interact();
}
