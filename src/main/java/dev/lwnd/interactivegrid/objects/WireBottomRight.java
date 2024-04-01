package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class WireBottomRight extends Interactee {
    public WireBottomRight(String name, String description, Cell cell, String imagePath) {
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

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() + 1, getAttachedCell().getX());
        if (cellDown != null && previousObject.getAttachedCell() != cellDown) {
            if (cellDown.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellDown.getAttachedObject()).getActivatedB(interactor, this);
            }
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell( getAttachedCell().getY(), getAttachedCell().getX() + 1);
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

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() + 1, getAttachedCell().getX());
        if (cellDown != null && previousObject.getAttachedCell() != cellDown) {
            if (cellDown.getAttachedObject() instanceof Interactee) {
                ((Interactee) cellDown.getAttachedObject()).getActivatedC(interactor, this);
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
