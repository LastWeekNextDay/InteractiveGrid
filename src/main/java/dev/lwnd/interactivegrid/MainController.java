package dev.lwnd.interactivegrid;

import dev.lwnd.interactivegrid.area.Cell;
import dev.lwnd.interactivegrid.area.InventoryGrid;
import dev.lwnd.interactivegrid.area.PlayGrid;
import dev.lwnd.interactivegrid.objects.*;
import dev.lwnd.interactivegrid.objects.base.BaseObject;
import dev.lwnd.interactivegrid.objects.base.Interactor;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.InputStream;
import java.util.Dictionary;
import java.util.Hashtable;

public class MainController {
    @FXML
    private GridPane invGridUI;
    private InventoryGrid invGrid;

    @FXML
    private GridPane playGridUI;
    private PlayGrid playGrid;

    private Dictionary<Pane, Cell> cellDictionary;
    private BaseObject selectedObject;

    @FXML
    public void initialize() {
        System.out.println("Initializing...");
        cellDictionary = new Hashtable<>();
        populateGrid(invGridUI, 2, 10, true);
        populateGrid(playGridUI, 10, 10, false);
    }

    private void populateGrid(GridPane gridUI, int numCols, int numRows, boolean isInventory) {
        System.out.println("Populating grid..." + (isInventory ? "Inventory Grid" : "Play Grid"));
        if (isInventory && invGrid == null) {
            invGrid = new InventoryGrid(numRows, numCols);
        } else if (!isInventory && playGrid == null) {
            playGrid = new PlayGrid(numRows, numCols);
        }

        BaseObject[] objects = new BaseObject[14];
        if (isInventory) {
            objects[0] = new Light("Light 1", "A light", null, "/LightOff.png", "/LightOn.png", "/LightBroken.png");
            objects[1] = new Switch("Switch 1", "A switch", null, "/SwitchOff.png", "/SwitchOn.png");
            objects[2] = new WireBottomLeft("WireBottomLeft 1", "A wire going bottom to left", null, "/WireBottomLeft.png");
            objects[3] = new WireBottomRight("WireBottomRight 1", "A wire going bottom to right", null, "/WireBottomRight.png");
            objects[4] = new WireTopLeft("WireTopLeft 1", "A wire going top to left", null, "/WireTopLeft.png");
            objects[5] = new WireTopRight("WireTopRight 1", "A wire going top to right", null, "/WireTopRight.png");
            objects[6] = new WireHorizontal("WireHorizontal 1", "A horizontal wire", null, "/WireHorizontal.png");
            objects[7] = new WireVertical("WireVertical 1", "A vertical wire", null, "/WireVertical.png");
            objects[8] = new WireVertical("WireVertical 1", "A vertical wire", null, "/WireVertical.png");
            objects[9] = new WireVertical("WireVertical 1", "A vertical wire", null, "/WireVertical.png");
            objects[10] = new Switch("Switch 2", "A switch", null, "/SwitchOff.png", "/SwitchOn.png");
            objects[11] = new WireVerticalTopBottomRight("WireVerticalTopBottomRight 1", "A wire going top to bottom to right", null, "/WireVerticalTopBottomRight.png");
            objects[12] = new Light("Light 2", "A light", null, "/LightOff.png", "/LightOn.png", "/LightBroken.png");
            objects[13] = new WireVerticalTopBottomRight("WireVerticalTopBottomRight 2", "A wire going top to bottom to right", null, "/WireVerticalTopBottomRight.png");
        }
        int oIndex = 0;

        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                Pane cellUI = new Pane();
                cellUI.setMinSize(50, 50);
                cellUI.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

                Cell cell = new Cell(i, j, null);

                if (isInventory) {
                    cell.attachToGrid(invGrid);

                    if (oIndex < objects.length) {
                        cell.attachObject(objects[oIndex]);

                        ImageView imageView = createImageView(cell.getAttachedObject().getImagePath());
                        cellUI.getChildren().add(imageView);

                        oIndex++;
                    }
                } else {
                    cell.attachToGrid(playGrid);
                }

                cellDictionary.put(cellUI, cell);

                cellUI.setOnDragDetected(event -> {
                    if (!cellUI.getChildren().isEmpty()) {
                        initiateDrag(cellUI, event);
                    }
                });

                setupDropHandling(cellUI, gridUI == invGridUI);

                cellUI.setOnMouseReleased(this::handleCellClick);

                gridUI.add(cellUI, i, j);
            }
        }
    }
    private ImageView createImageView(String imagePath) {
        InputStream is = getClass().getResourceAsStream(imagePath);
        if (is == null) {
            throw new IllegalArgumentException("Image not found: " + imagePath);
        }
        Image image = new Image(is);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        return imageView;
    }

    private void initiateDrag(Pane cellUI, MouseEvent event) {
        System.out.println("Initiating drag...");
        if (!cellUI.getChildren().isEmpty() && cellUI.getChildren().get(0) instanceof ImageView) {
            Dragboard db = cellUI.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();

            Cell cell = cellDictionary.get(cellUI);
            content.putString(cell.getAttachedObject().getImagePath());
            selectedObject = cell.getAttachedObject();

            db.setContent(content);
            db.setDragView(((ImageView) cellUI.getChildren().get(0)).getImage());

            cellUI.setOnDragDone(eventDone -> {
                System.out.println("On drag done...");
                if (eventDone.getTransferMode() == TransferMode.MOVE) {
                    cellUI.getChildren().clear();
                }
                selectedObject = null;
                eventDone.consume();
            });

            event.consume();
        }
    }


    private void setupDropHandling(Pane cellUI, boolean isObjectGrid) {
        cellUI.setOnDragOver(event -> {
            System.out.println("On drag over...");
            if (event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        cellUI.setOnDragDropped(event -> {
            System.out.println("On drag dropped...");
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                if (cellUI.getChildren().isEmpty()) {
                    ImageView imageView = createImageView(db.getString());
                    cellUI.getChildren().add(imageView);
                    success = true;
                    selectedObject.getAttachedCell().detach();
                    cellDictionary.get(cellUI).attachObject(selectedObject);
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });

        cellUI.setOnDragDone(event -> {
            System.out.println("On drag done...");
            if (event.getTransferMode() == TransferMode.MOVE) {
                if (!isObjectGrid || cellUI.getChildren().isEmpty()) {
                    cellUI.getChildren().clear();
                }
            }
            event.consume();
        });
    }

    private void handleCellClick(MouseEvent event) {
        System.out.println("Handling cell click...");
        if (!event.isSecondaryButtonDown()) {
            return;
        }

        Pane clickedCell = (Pane) event.getSource();

        if (clickedCell == null){
            ImageView imageView = (ImageView) event.getSource();
            clickedCell = (Pane) imageView.getParent();
        }

        System.out.println("Clicked cell: " + clickedCell);

        if (clickedCell.getChildren().isEmpty()) {
            return;
        }

        if (playGridUI.getChildren().contains(clickedCell)) {
            Cell cell = cellDictionary.get(clickedCell);
            BaseObject object = cell.getAttachedObject();

            if (object instanceof Interactor) {
                ((Interactor) object).interact();
            }

            for (int i = 0; i < playGridUI.getChildren().size(); i++) {
                Pane cellUI = (Pane) playGridUI.getChildren().get(i);

                if (!cellUI.getChildren().isEmpty()) {
                    cellUI.getChildren().clear();
                    Cell cellObj = cellDictionary.get(cellUI);
                    ImageView imageView = createImageView(cellObj.getAttachedObject().getImagePath());
                    cellUI.getChildren().add(imageView);
                    System.out.println("Cell updated with new image: " + cellObj.getAttachedObject().getImagePath());
                }
            }
        }
    }
}
