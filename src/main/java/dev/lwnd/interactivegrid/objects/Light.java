package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class Light extends Interactee {
    public Light(String name, String description, Cell cell) {
        super(name, description, cell);
    }

    @Override
    public void getActivatedA(BaseObject interactor) {
        System.out.println("Light activated");
    }

    @Override
    public void getActivatedB(BaseObject interactor) {
        
    }

    @Override
    public void getActivatedC(BaseObject interactor) {

    }
}
