package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class WireBottomRight extends Interactee {
    public WireBottomRight(String name, String description, Cell cell) {
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
    }
}
