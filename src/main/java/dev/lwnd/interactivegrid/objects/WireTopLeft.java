package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class WireTopLeft extends Interactee {
    public WireTopLeft(String name, String description, Cell cell, String imagePath) {
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

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() - 1, getAttachedCell().getX());
        if (cellUp != null && previousObject.getAttachedCell() != cellUp) {
            if (cellUp.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellUp.getAttachedObject()).getActivatedB(interactor, this);
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

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() - 1, getAttachedCell().getX());
        if (cellUp != null && previousObject.getAttachedCell() != cellUp) {
            if (cellUp.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellUp.getAttachedObject()).getActivatedC(interactor, this);
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
