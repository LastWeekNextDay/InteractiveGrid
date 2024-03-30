package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class WireHorizontal extends Interactee{
    public WireHorizontal(String name, String description, Cell cell, String imagePath) {
        super(name, description, cell, imagePath);
    }

    @Override
    public void getActivatedA(BaseObject interactor) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() + 1, getAttachedCell().getY());
        if (cellRight != null && cellRight.getAttachedObject() != interactor) {
            switch (cellRight.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellRight.getAttachedObject()).getActivatedA(interactor);
                    break;
            }
        }

        Cell cellLeft = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() - 1, getAttachedCell().getY());
        if (cellLeft != null && cellLeft.getAttachedObject() != interactor) {
            switch (cellLeft.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellLeft.getAttachedObject()).getActivatedA(interactor);
                    break;
            }
        }
    }

    @Override
    public void getActivatedB(BaseObject interactor) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() + 1, getAttachedCell().getY());
        if (cellRight != null && cellRight.getAttachedObject() != interactor) {
            switch (cellRight.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellRight.getAttachedObject()).getActivatedB(interactor);
                    break;
            }
        }

        Cell cellLeft = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() - 1, getAttachedCell().getY());
        if (cellLeft != null && cellLeft.getAttachedObject() != interactor) {
            switch (cellLeft.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellLeft.getAttachedObject()).getActivatedB(interactor);
                    break;
            }
        }
    }

    @Override
    public void getActivatedC(BaseObject interactor) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() + 1, getAttachedCell().getY());
        if (cellRight != null && cellRight.getAttachedObject() != interactor) {
            switch (cellRight.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellRight.getAttachedObject()).getActivatedC(interactor);
                    break;
            }
        }

        Cell cellLeft = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() - 1, getAttachedCell().getY());
        if (cellLeft != null && cellLeft.getAttachedObject() != interactor) {
            switch (cellLeft.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellLeft.getAttachedObject()).getActivatedC(interactor);
                    break;
            }
        }
    }
}
