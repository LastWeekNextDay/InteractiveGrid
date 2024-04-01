package dev.lwnd.interactivegrid.objects;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.objects.base.Interactee;
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
            System.out.println("Switching off switch.");
        } else {
            setImagePath(switchOnImage);
            activated = true;
            System.out.println("Switching on switch.");
        }

        Cell cellRight = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY(), getAttachedCell().getX() + 1);
        if (cellRight != null && cellRight.getAttachedObject() != null) {
            if (cellRight.getAttachedObject().getClass().getSimpleName().equals("WireHorizontal") ||
                    cellRight.getAttachedObject().getClass().getSimpleName().equals("WireTopLeft") ||
                    cellRight.getAttachedObject().getClass().getSimpleName().equals("WireBottomLeft")) {
                if (activated) {
                    ((Interactee) cellRight.getAttachedObject()).getActivatedA(this, this);
                } else {
                    ((Interactee) cellRight.getAttachedObject()).getActivatedC(this, this);
                }
            }
        }

        Cell cellLeft = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY(), getAttachedCell().getX() - 1);
        if (cellLeft != null && cellLeft.getAttachedObject() != null) {
            if (cellLeft.getAttachedObject().getClass().getSimpleName().equals("WireHorizontal") ||
                    cellLeft.getAttachedObject().getClass().getSimpleName().equals("WireTopRight") ||
                    cellLeft.getAttachedObject().getClass().getSimpleName().equals("WireBottomRight") ||
                    cellLeft.getAttachedObject().getClass().getSimpleName().equals("WireVerticalTopBottomRight")) {
                if (activated) {
                    ((Interactee) cellLeft.getAttachedObject()).getActivatedA(this, this);
                } else {
                    ((Interactee) cellLeft.getAttachedObject()).getActivatedC(this, this);
                }
            }
        }

        Cell cellDown = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() + 1, getAttachedCell().getX());
        if (cellDown != null && cellDown.getAttachedObject() != null) {
            if (cellDown.getAttachedObject().getClass().getSimpleName().equals("WireVertical") ||
                    cellDown.getAttachedObject().getClass().getSimpleName().equals("WireTopLeft") ||
                    cellDown.getAttachedObject().getClass().getSimpleName().equals("WireTopRight") ||
                    cellDown.getAttachedObject().getClass().getSimpleName().equals("WireVerticalTopBottomRight")) {
                if (activated) {
                    ((Interactee) cellDown.getAttachedObject()).getActivatedA(this, this);
                } else {
                    ((Interactee) cellDown.getAttachedObject()).getActivatedC(this, this);
                }
            }
        }

        Cell cellUp = getAttachedCell().getBaseGrid().getCell(getAttachedCell().getY() - 1, getAttachedCell().getX());
        if (cellUp != null && cellUp.getAttachedObject() != null) {
            if (cellUp.getAttachedObject().getClass().getSimpleName().equals("WireVertical") ||
                    cellUp.getAttachedObject().getClass().getSimpleName().equals("WireBottomLeft") ||
                    cellUp.getAttachedObject().getClass().getSimpleName().equals("WireBottomRight") ||
                    cellUp.getAttachedObject().getClass().getSimpleName().equals("WireVerticalTopBottomRight")) {
                if (activated) {
                    ((Interactee) cellUp.getAttachedObject()).getActivatedA(this, this);
                } else {
                    ((Interactee) cellUp.getAttachedObject()).getActivatedC(this, this);
                }
            }
        }
    }
}
