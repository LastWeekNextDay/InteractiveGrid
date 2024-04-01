package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class WireBottomLeft extends Interactee {
    public WireBottomLeft(String name, String description, Cell cell, String imagePath) {
        super(name, description, cell, imagePath);
    }

    @Override
    public void getActivatedA(BaseObject interactor, BaseObject previousObject) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() + 1, getAttachedCell().getX());
        if (cellDown != null && previousObject.getAttachedCell() != cellDown) {
            if (cellDown.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellDown.getAttachedObject()).getActivatedA(interactor, this);
            }
        }

        Cell cellLeft = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY(), getAttachedCell().getX() - 1);
        if (cellLeft != null && previousObject.getAttachedCell() != cellLeft) {
            if (cellLeft.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellLeft.getAttachedObject()).getActivatedA(interactor, this);
            }
        }
    }

    @Override
    public void getActivatedB(BaseObject interactor, BaseObject previousObject) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() + 1, getAttachedCell().getX());
        if (cellDown != null && previousObject.getAttachedCell() != cellDown) {
            if (cellDown.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellDown.getAttachedObject()).getActivatedB(interactor, this);
            }
        }

        Cell cellLeft = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY(), getAttachedCell().getX() - 1);
        if (cellLeft != null && previousObject.getAttachedCell() != cellLeft) {
            if (cellLeft.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellLeft.getAttachedObject()).getActivatedB(interactor, this);
            }
        }
    }

    @Override
    public void getActivatedC(BaseObject interactor, BaseObject previousObject) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() + 1, getAttachedCell().getX());
        if (cellDown != null && previousObject.getAttachedCell() != cellDown) {
            if (cellDown.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellDown.getAttachedObject()).getActivatedC(interactor, this);
            }
        }

        Cell cellLeft = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY(), getAttachedCell().getX() - 1);
        if (cellLeft != null && previousObject.getAttachedCell() != cellLeft) {
            if (cellLeft.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellLeft.getAttachedObject()).getActivatedC(interactor, this);
            }
        }
    }
}
