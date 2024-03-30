package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class Light extends Interactee {
    private String lightOffImage;
    private String lightOnImage;
    private String lightBrokenImage;

    public Light(String name, String description, Cell cell, String offImage, String onImage, String brokenImage) {
        super(name, description, cell, offImage);
        this.lightOffImage = offImage;
        this.lightOnImage = onImage;
        this.lightBrokenImage = brokenImage;
    }

    @Override
    public void getActivatedA(BaseObject interactor) {
        System.out.println("Light activated");
        setImagePath(lightOnImage);
    }

    @Override
    public void getActivatedB(BaseObject interactor) {
        System.out.println("Light broke");
        setImagePath(lightBrokenImage);
    }

    @Override
    public void getActivatedC(BaseObject interactor) {
        System.out.println("Light diaactivated");
        setImagePath(lightOffImage);
    }
}
