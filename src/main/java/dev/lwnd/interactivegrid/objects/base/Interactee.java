package dev.lwnd.interactivegrid.objects.base;

import dev.lwnd.interactivegrid.area.Cell;

public abstract class Interactee extends BaseObject{
    public Interactee(String name, String description, Cell cell) {
        super(name, description, cell);
    }

    public abstract void getActivated(BaseObject interactor);
}
