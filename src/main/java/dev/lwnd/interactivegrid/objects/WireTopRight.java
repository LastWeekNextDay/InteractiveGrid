package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class WireTopRight extends Interactee {
    public WireTopRight(String name, String description, Cell cell, String imagePath) {
        super(name, description, cell, imagePath);
    }

    @Override
    public void getActivatedA(BaseObject interactor, BaseObject previousObject) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() - 1, getAttachedCell().getX());
        if (cellUp != null && previousObject.getAttachedCell() != cellUp) {
            if (cellUp.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellUp.getAttachedObject()).getActivatedA(interactor, this);
            }
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY(), getAttachedCell().getX() + 1);
        if (cellRight != null && previousObject.getAttachedCell() != cellRight) {
            if (cellRight.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellRight.getAttachedObject()).getActivatedA(interactor, this);
            }
        }
    }

    @Override
    public void getActivatedB(BaseObject interactor, BaseObject previousObject) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() - 1, getAttachedCell().getX());
        if (cellUp != null && previousObject.getAttachedCell() != cellUp) {
            if (cellUp.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellUp.getAttachedObject()).getActivatedB(interactor, this);
            }
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY(), getAttachedCell().getX() + 1);
        if (cellRight != null && previousObject.getAttachedCell() != cellRight) {
            if (cellRight.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellRight.getAttachedObject()).getActivatedB(interactor, this);
            }
        }
    }

    @Override
    public void getActivatedC(BaseObject interactor, BaseObject previousObject) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() - 1, getAttachedCell().getX());
        if (cellUp != null && previousObject.getAttachedCell() != cellUp) {
            if (cellUp.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellUp.getAttachedObject()).getActivatedC(interactor, this);
            }
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY(), getAttachedCell().getX() + 1);
        if (cellRight != null && previousObject.getAttachedCell() != cellRight) {
            if (cellRight.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellRight.getAttachedObject()).getActivatedC(interactor, this);
            }
        }
    }
}
