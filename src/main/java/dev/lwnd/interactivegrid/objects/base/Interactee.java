package dev.lwnd.interactivegrid.objects.base;

import dev.lwnd.interactivegrid.area.Cell;

public abstract class Interactee extends BaseObject{
    public Interactee(String name, String description, Cell cell, String imagePath) {
        super(name, description, cell, imagePath);
    }

    public abstract void getActivatedA(BaseObject interactor, BaseObject previousObject);
    public abstract void getActivatedB(BaseObject interactor, BaseObject previousObject);
    public abstract void getActivatedC(BaseObject interactor, BaseObject previousObject);
}
