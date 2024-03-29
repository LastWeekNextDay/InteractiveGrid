package dev.lwnd.interactivegrid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final int NUM_COLS = 10; // number of columns
    private static final int NUM_ROWS = 10; // number of rows
    private static final int CELL_SIZE = 50; // size for each cell
    private static final int PADDING = 20; // padding around the grid
    private static final int SPACING = 10; // spacing between cells

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // The total width is calculated by taking the width of all columns plus spacing and padding
        int totalWidth = NUM_COLS * CELL_SIZE + (NUM_COLS * 2) * SPACING + 2 * PADDING;

        // The total height is calculated similarly, taking into account rows, spacing, and padding
        int totalHeight = NUM_ROWS * CELL_SIZE + (NUM_ROWS -1) * SPACING + 2 * PADDING;

        Scene scene = new Scene(fxmlLoader.load(), totalWidth, totalHeight);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
