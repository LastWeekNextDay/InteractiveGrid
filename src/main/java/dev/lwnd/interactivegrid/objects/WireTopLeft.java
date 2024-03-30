package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;

public class WireTopLeft extends Interactee {
    public WireTopLeft(String name, String description, Cell cell, String imagePath) {
        super(name, description, cell, imagePath);
    }

    @Override
    public void getActivatedA(BaseObject interactor) {
        if (getAttachedCell() == null) {
            return;
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
