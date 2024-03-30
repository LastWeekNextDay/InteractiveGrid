package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.Interactor;

public class Switch extends Interactor {
    private boolean activated;
    private String switchOffImage;
    private String switchOnImage;

    public Switch(String name, String description, Cell cell, String offImage, String onImage) {
        super(name, description, cell, offImage);
        activated = false;
        this.switchOffImage = offImage;
        this.switchOnImage = onImage;
    }

    @Override
    public void interact() {
        if (getAttachedCell() == null){
            return;
        }

        if (activated) {
            setImagePath(switchOffImage);
            activated = false;
        } else {
            setImagePath(switchOnImage);
            activated = true;
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() + 1, getAttachedCell().getY());
        if (cellRight != null && cellRight.getAttachedObject() != null) {
            if (cellRight.getAttachedObject().getClass().getSimpleName().equals("WireHorizontal") ||
                    cellRight.getAttachedObject().getClass().getSimpleName().equals("WireTopLeft") ||
                    cellRight.getAttachedObject().getClass().getSimpleName().equals("WireBottomLeft")) {
                if (activated) {
                    ((WireHorizontal) cellRight.getAttachedObject()).getActivatedC(this);
                } else {
                    ((WireHorizontal) cellRight.getAttachedObject()).getActivatedA(this);
                }
            }
        }

        Cell cellLeft = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX() - 1, getAttachedCell().getY());
        if (cellLeft != null && cellLeft.getAttachedObject() != null) {
            if (cellLeft.getAttachedObject().getClass().getSimpleName().equals("WireHorizontal") ||
                    cellLeft.getAttachedObject().getClass().getSimpleName().equals("WireTopRight") ||
                    cellLeft.getAttachedObject().getClass().getSimpleName().equals("WireBottomRight")){
                if (activated) {
                    ((WireHorizontal) cellLeft.getAttachedObject()).getActivatedC(this);
                } else {
                    ((WireHorizontal) cellLeft.getAttachedObject()).getActivatedA(this);
                }
            }
        }

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() + 1);
        if (cellDown != null && cellDown.getAttachedObject() != null) {
            if (cellDown.getAttachedObject().getClass().getSimpleName().equals("WireVertical") ||
                    cellDown.getAttachedObject().getClass().getSimpleName().equals("WireTopLeft") ||
                    cellDown.getAttachedObject().getClass().getSimpleName().equals("WireTopRight")) {
                if (activated) {
                    ((WireVertical) cellDown.getAttachedObject()).getActivatedC(this);
                } else {
                    ((WireVertical) cellDown.getAttachedObject()).getActivatedA(this);
                }
            }
        }

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getX(), getAttachedCell().getY() - 1);
        if (cellUp != null && cellUp.getAttachedObject() != null) {
            if (cellUp.getAttachedObject().getClass().getSimpleName().equals("WireVertical") ||
                    cellUp.getAttachedObject().getClass().getSimpleName().equals("WireBottomLeft") ||
                    cellUp.getAttachedObject().getClass().getSimpleName().equals("WireBottomRight")){
                if (activated) {
                    ((WireVertical) cellUp.getAttachedObject()).getActivatedC(this);
                } else {
                    ((WireVertical) cellUp.getAttachedObject()).getActivatedA(this);
                }
            }
        }
    }
}
