package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class WireVertical extends Interactee {
    public WireVertical(String name, String description, Cell cell, String imagePath) {
        super(name, description, cell, imagePath);
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

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() - 1);
        if (cellUp != null && cellUp.getAttachedObject() != interactor) {
            switch (cellUp.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellUp.getAttachedObject()).getActivatedA(interactor);
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

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() - 1);
        if (cellUp != null && cellUp.getAttachedObject() != interactor) {
            switch (cellUp.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellUp.getAttachedObject()).getActivatedB(interactor);
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

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() - 1);
        if (cellUp != null && cellUp.getAttachedObject() != interactor) {
            switch (cellUp.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellUp.getAttachedObject()).getActivatedC(interactor);
                    break;
            }
        }
    }
}
