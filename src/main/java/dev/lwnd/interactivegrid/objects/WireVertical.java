package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactee;
import dev.lwnd.interactivegrid.objects.base.Interactor;

public class WireVertical extends Interactee {
    public WireVertical(String name, String description, Cell cell) {
        super(name, description, cell);
    }

    @Override
    public void getActivated(BaseObject interactor) {
        if (getAttachedCell() == null) {
            return;
        }

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() + 1);
        if (cellDown != null && cellDown.getAttachedObject() != interactor) {
            switch (cellDown.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellDown.getAttachedObject()).getActivated(interactor);
                    break;
            }
        }

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() - 1);
        if (cellUp != null && cellUp.getAttachedObject() != interactor) {
            switch (cellUp.getAttachedObject().getClass().getSimpleName()) {
                case "Interactor":
                    break;
                case "Interactee":
                    ((Interactee) cellUp.getAttachedObject()).getActivated(interactor);
                    break;
            }
        }
    }
}
