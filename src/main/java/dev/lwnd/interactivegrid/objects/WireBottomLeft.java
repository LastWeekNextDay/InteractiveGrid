package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class WireBottomLeft extends Interactee {
    public WireBottomLeft(String name, String description, Cell cell) {
        super(name, description, cell);
    }

    @Override
    public void getActivatedA(BaseObject interactor) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() + 1);
        if (cellDown != null && cellDown.getAttachedObject() != interactor) {
            switch (cellDown.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellDown.getAttachedObject()).getActivatedA(interactor);
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

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() + 1);
        if (cellDown != null && cellDown.getAttachedObject() != interactor) {
            switch (cellDown.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellDown.getAttachedObject()).getActivatedB(interactor);
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

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() + 1);
        if (cellDown != null && cellDown.getAttachedObject() != interactor) {
            switch (cellDown.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellDown.getAttachedObject()).getActivatedC(interactor);
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
