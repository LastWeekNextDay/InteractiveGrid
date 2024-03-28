package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;
import dev.lwnd.interactivegrid.objects.base.Interactor;

public class WireHorizontal extends Interactee{
    public WireHorizontal(String name, String description, Cell cell) {
        super(name, description, cell);
    }

    @Override
    public void getActivated(BaseObject interactor) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() + 1, getAttachedCell().getY());
        if (cellRight != null && cellRight.getAttachedObject() != interactor) {
            switch (cellRight.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellRight.getAttachedObject()).getActivated(interactor);
                    break;
            }
        }

        Cell cellLeft = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() - 1, getAttachedCell().getY());
        if (cellLeft != null && cellLeft.getAttachedObject() != interactor) {
            switch (cellLeft.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellLeft.getAttachedObject()).getActivated(interactor);
                    break;
            }
        }
    }
}
