package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.Interactor;

public class Switch extends Interactor {
    public Switch(String name, String description, Cell cell) {
        super(name, description, cell);
    }

    @Override
    public void interact() {
        if (getAttachedCell() == null){
            return;
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() + 1, getAttachedCell().getY());
        if (cellRight != null && cellRight.getAttachedObject() != null) {
            if (cellRight.getAttachedObject().getClass().getSimpleName().equals("WireHorizontal")) {
                ((WireHorizontal) cellRight.getAttachedObject()).getActivated(this);
            }
        }

        Cell cellLeft = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() - 1, getAttachedCell().getY());
        if (cellLeft != null && cellLeft.getAttachedObject() != null) {
            if (cellLeft.getAttachedObject().getClass().getSimpleName().equals("WireHorizontal")) {
                ((WireHorizontal) cellLeft.getAttachedObject()).getActivated(this);
            }
        }

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() + 1);
        if (cellDown != null && cellDown.getAttachedObject() != null) {
            if (cellDown.getAttachedObject().getClass().getSimpleName().equals("WireVertical")) {
                ((WireVertical) cellDown.getAttachedObject()).getActivated(this);
            }
        }

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() - 1);
        if (cellUp != null && cellUp.getAttachedObject() != null) {
            if (cellUp.getAttachedObject().getClass().getSimpleName().equals("WireVertical")) {
                ((WireVertical) cellUp.getAttachedObject()).getActivated(this);
            }
        }
    }
}
