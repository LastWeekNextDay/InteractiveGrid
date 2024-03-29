package dev.lwnd.interactivegrid;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private GridPane objectsGrid;

    @FXML
    private GridPane playGrid;

    @FXML
    public void initialize() {
        // Assuming a 10x10 grid for both objects and play area
        populateGrid(objectsGrid, 2, 10, true);
        populateGrid(playGrid, 10, 10, false);
    }

    private void populateGrid(GridPane grid, int numCols, int numRows, boolean loadImages) {
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                Pane cell = new Pane();
                cell.setMinSize(50, 50);
                cell.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

                // Initialize ImageView only for the objectsGrid if loadImages is true
                if (loadImages) {
                    ImageView imageView = createImageView("/OOP3P1.png");
                    cell.getChildren().add(imageView);
                }

                // Make the cell capable of initiating a drag if it contains an ImageView
                cell.setOnDragDetected(event -> {
                    if (!cell.getChildren().isEmpty()) {
                        initiateDrag(cell, event);
                    }
                });

                setupDropHandling(cell, grid == objectsGrid);

                grid.add(cell, i, j);
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

    private void initiateDrag(Pane cell, MouseEvent event) {
        if (!cell.getChildren().isEmpty() && cell.getChildren().get(0) instanceof ImageView) {
            Dragboard db = cell.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();

            // Unique identifier for the content type
            content.putString("DraggedImage");

            // Optional: Include source information (e.g., a unique ID or reference)
            // Here, using a simple flag as an example
            db.setContent(content);

            // Provide visual feedback
            db.setDragView(((ImageView) cell.getChildren().get(0)).getImage());

            // Attach onDragDone event here, ensuring it knows this cell is the source
            cell.setOnDragDone(eventDone -> {
                // This check ensures the operation was a move
                if (eventDone.getTransferMode() == TransferMode.MOVE) {
                    // Clear the cell's content
                    cell.getChildren().clear();
                }
                eventDone.consume();
            });

            event.consume();
        }
    }


    private void setupDropHandling(Pane cell, boolean isObjectGrid) {
        // Handle drag over to indicate the cell can accept the drag
        cell.setOnDragOver(event -> {
            if (event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        // Handle the drop
        cell.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                // Only move the image if the cell doesn't already contain an ImageView
                if (cell.getChildren().isEmpty()) {
                    ImageView imageView = createImageView("/OOP3P1.png");
                    cell.getChildren().add(imageView);
                    success = true;
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });

        // Handle the completion of the drag
        cell.setOnDragDone(event -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                // Remove the child if it's not the objectsGrid or if the cell is empty now
                if (!isObjectGrid || cell.getChildren().isEmpty()) {
                    cell.getChildren().clear();
                }
            }
            event.consume();
        });
    }



    private void handleCellClick(MouseEvent event) {
        // Get the source of the click, which is the cell pane
        Pane clickedCell = (Pane) event.getSource();
        // Perform the desired action, for example, change the cell's color
        clickedCell.setStyle("-fx-background-color: #ececec;");

        // If you need to find out the coordinates of the cell in the grid
        Integer colIndex = GridPane.getColumnIndex(clickedCell);
        Integer rowIndex = GridPane.getRowIndex(clickedCell);
        welcomeText.setText(String.format("Cell clicked at: (%d, %d)", colIndex, rowIndex));

        // Implement further logic here, e.g., check what object is in the cell, if any, and respond accordingly
    }

    // Additional methods to handle interactions with the grid
}
