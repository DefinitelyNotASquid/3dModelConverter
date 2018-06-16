import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;

/**
 *   Permission is hereby granted, free of charge, to any person obtaining a copy of this
 *   software and associated documentation files (the "Software"), to deal in the Software
 *   without restriction, including without limitation the rights to use, copy, modify,
 *   merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 *   permit persons to whom the Software is furnished to do so, subject to the following
 *   conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all copies
 *   or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 *   INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 *   PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *   HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 *   CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 *   OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
public class Main extends Application {

    public String openFile;

    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;

        window.setTitle("3d Model Converter");


        BorderPane MainBorderPane = new BorderPane();
        BorderPane TopBorderPane = new BorderPane();
        BorderPane BottomBorderPane = new BorderPane();
        MainBorderPane.setTop(TopBorderPane);
        MainBorderPane.setBottom(BottomBorderPane);

        GridPane TopGrid = new GridPane();

        TopBorderPane.setCenter(TopGrid);

        Button Open = new Button("Open");
        Button Convert = new Button("Convert");



        TextField FileLocationTop = new TextField();
        FileLocationTop.setEditable(false);



        ObservableList<String> topfile =
                FXCollections.observableArrayList(
                        ".fbx",
                        ".obj",
                        ".wav",
                        ".3ds",
                        ".stla",
                        ".stlb",
                        ".dae",
                        ".collada",
                        ".max"
                );
        final ComboBox<String> topFileCombo = new ComboBox<String>(topfile);




        Open.setOnAction(e ->{

            openFile = UtilMethods.displayOpen(window);
            FileLocationTop.setText(openFile);



        });

        FileLocationTop.setMinWidth(250);
        Open.setMinWidth(100);

        Convert.setMinWidth(100);
        topFileCombo.setMinWidth(100);


        TopGrid.add(Open , 0, 0, 1, 1);
        TopGrid.add(FileLocationTop , 1, 0, 1, 1);
        TopGrid.add(topFileCombo, 2,0,1,1);

        TopGrid.add(Convert, 2,2,1,1);


        Scene MainScene = new Scene(MainBorderPane, 460, 100);

        window.setScene(MainScene);


        window.setResizable(true);
        window.show();


    }

}
