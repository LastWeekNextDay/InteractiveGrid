package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class Light extends Interactee {
    private String lightOffImage;
    private String lightOnImage;
    private String lightBrokenImage;
    private BaseObject previousInteractor;
    private boolean isBroken;

    public Light(String name, String description, Cell cell, String offImage, String onImage, String brokenImage) {
        super(name, description, cell, offImage);
        this.lightOffImage = offImage;
        this.lightOnImage = onImage;
        this.lightBrokenImage = brokenImage;
        this.isBroken = false;
    }

    @Override
    public void getActivatedA(BaseObject interactor, BaseObject previousObject) {
        if (isBroken) {
            return;
        }

        if (previousInteractor == null) {
            previousInteractor = interactor;
        } else if (previousInteractor != interactor) {
            getActivatedB(interactor, previousObject);
            return;
        }

        System.out.println("Light activated");
        setImagePath(lightOnImage);
    }

    @Override
    public void getActivatedB(BaseObject interactor, BaseObject previousObject) {
        if (isBroken) {
            return;
        }

        System.out.println("Light broke");
        setImagePath(lightBrokenImage);
        isBroken = true;
    }

    @Override
    public void getActivatedC(BaseObject interactor, BaseObject previousObject) {
        if (isBroken) {
            return;
        }

        System.out.println("Light deactivated");
        setImagePath(lightOffImage);
        previousInteractor = null;
    }
}
