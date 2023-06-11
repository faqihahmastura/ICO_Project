/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ico.group.project;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ICO_Project extends Application{
    Integer bin, dec, oct, hex = 0;
    TextField inputTF = new TextField();
    ComboBox<String> startCB = new ComboBox<>();
    ComboBox<String> convertCB = new ComboBox<>();
    TextField resultTF = new TextField();

    @Override
    public void start(Stage primaryStage) {
                
        Stage startScreenStage = new Stage();
        
        Label startLabel = new Label();
        startLabel.setFont(Font.font("Impact", 15));
        startLabel.setText("Hello there, this is base conversion calculator");
        startLabel.setTranslateX(50);
        startLabel.setTranslateY(10);
        
        VBox startBox = new VBox(10);
        startBox.getChildren().addAll(startLabel);
        startBox.setAlignment(Pos.TOP_LEFT);
        
        Label information = new Label();
        information.setText("This system required you to:"
                + "\n1) Enter a whole number"
                + "\n2) Choose the number bases");
        
        Button next = new Button("Next");
        
        VBox root = new VBox(10);
        root.getChildren().addAll(startBox,information, next);
        root.setAlignment(Pos.CENTER);
        
        next.setOnAction(e ->{
            conversionPage(primaryStage);
            startScreenStage.close();
         });
        
        Scene scene = new Scene(root, 350, 250);
        startScreenStage.setTitle("Homepage Window");
        startScreenStage.setScene(scene);
        startScreenStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void conversionPage(Stage primaryStage){
        // create gridPane
        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // create STARTING BASE label
        Label startLabel = new Label("Starting base: ");
        grid.add(startLabel, 0, 0);

        // holds STARTING BASE comboBox
        startCB.getItems().addAll("Decimal", "Binary", "Octal", "Hexadecimal");
        startCB.setPromptText("Choose your starting base");
        startCB.setPrefWidth(220);
        grid.add(startCB, 1, 0);

        // create USER INPUT label
        Label inputLabel = new Label("Your number: ");
        grid.add(inputLabel, 0, 1);

        // holds USER INPUT textField
        grid.add(inputTF, 1, 1);

        // create CONVERTING BASE label
        Label convertLabel = new Label("Conversion base: ");
        grid.add(convertLabel, 0, 2);

        // holds CONVERTING BASE comboBox
        convertCB.getItems().addAll("Decimal", "Binary", "Octal", "Hexadecimal");
        convertCB.setPromptText("Choose your conversion base");
        convertCB.setPrefWidth(220);
        grid.add(convertCB, 1, 2);

        // create CONVERT RESULT label
        Label resultLabel = new Label("The conversion number: ");
        grid.add(resultLabel, 0, 3);

        // holds CONVERT RESULT textField
        resultTF.setEditable(false);
        grid.add(resultTF, 1, 3);

        // create CONVERT button
        Button btnConvert = new Button("Convert");
        btnConvert.setPrefWidth(80);
        btnConvert.setAlignment(Pos.CENTER);
        grid.add(btnConvert, 0, 6);

        // create EXIT button
        Button btnExit = new Button("Exit");
        btnExit.setPrefWidth(80);
        btnExit.setAlignment(Pos.CENTER);
        grid.add(btnExit, 1, 6);

        // action on CONVERT button
        btnConvert.setOnAction(e -> {

            if (startCB.getValue().equals("Binary")) {
                if (convertCB.getValue().equals("Decimal")) {
                    fromBinaryToDecimal();
                } else if (convertCB.getValue().equals("Octal")) {
                    fromBinaryToOctal();
                } else if (convertCB.getValue().equals("Hexadecimal")) {
                    fromBinaryToHexadecimal();
                }
            } else if (startCB.getValue().equals("Decimal")) {
                if (convertCB.getValue().equals("Binary")) {
                    fromDecimalToBinary();
                } else if (convertCB.getValue().equals("Octal")) {
                    fromDecimalToOctal();
                } else if (convertCB.getValue().equals("Hexadecimal")) {
                    fromDecimalToHexadecimal();
                }
            } else if (            startCB.getValue().equals("Octal")) {
                if (convertCB.getValue().equals("Binary")) {
                    fromOctalToBinary();
                } else if (convertCB.getValue().equals("Decimal")) {
                    fromOctalToDecimal();
                } else if (convertCB.getValue().equals("Hexadecimal")) {
                    fromOctalToHex();
                }
            } else if (startCB.getValue().equals("Hexadecimal")) {
                if (convertCB.getValue().equals("Binary")) {
                    fromHexadecimalToBinary();
                } else if (convertCB.getValue().equals("Decimal")) {
                    fromHexadecimalToDecimal();
                } else if (convertCB.getValue().equals("Octal")) {
                    fromHexadecimalToOctal();
                }
            }

        });

        // action on EXIT button
        btnExit.setOnAction(e -> {
            primaryStage.close();
        });

        Scene scene = new Scene(grid, 425, 250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Number Conversion System.");
        primaryStage.show();

    }
    // conversion from BINARY to DECIMAL
    private void fromBinaryToDecimal() {
        try {
            bin = Integer.parseInt(inputTF.getText(), 2);
            resultTF.setText(bin.toString());
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }

    // conversion from BINARY to OCTAL
    private void fromBinaryToOctal() {
        try {
            bin = Integer.parseInt(inputTF.getText(), 2);
            resultTF.setText(Integer.toOctalString(bin));
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }

    // conversion from BINARY to HEXADECIMAL
    private void fromBinaryToHexadecimal() {
        try {
            bin = Integer.parseInt(inputTF.getText(), 2);
            resultTF.setText(Integer.toHexString(bin).toUpperCase());
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }

    // conversion from DECIMAL to BINARY
    private void fromDecimalToBinary() {
        try {
            dec = Integer.parseInt(inputTF.getText(), 10);
            resultTF.setText(Integer.toBinaryString(dec));
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }

    // conversion from DECIMAL to OCTAL
    private void fromDecimalToOctal() {
        try {
            dec = Integer.parseInt(inputTF.getText(), 10);
            resultTF.setText(Integer.toOctalString(dec));
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }

    // conversion from DECIMAL to HEXADECIMAL
    private void fromDecimalToHexadecimal() {
        try {
            dec = Integer.parseInt(inputTF.getText(), 10);
            resultTF.setText(Integer.toHexString(dec).toUpperCase());
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }

    // conversion from OCTAL to BINARY
    private void fromOctalToBinary() {
        try {
            oct = Integer.parseInt(inputTF.getText(), 8);
            resultTF.setText(Integer.toBinaryString(oct));
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }


    // conversion from OCTAL to DECIMAL
    private void fromOctalToDecimal() {
        try {
            oct = Integer.parseInt(inputTF.getText(), 8);
            resultTF.setText(oct.toString());
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }

    // conversion from OCTAL to HEXADECIMAL
    private void fromOctalToHex() {
        try {
            oct = Integer.parseInt(inputTF.getText(), 8);
            resultTF.setText(Integer.toHexString(oct).toUpperCase());
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }


    // conversion from HEXADECIMAL to BINARY
    private void fromHexadecimalToBinary() {
        try {
            hex = Integer.parseInt(inputTF.getText(), 16);
            resultTF.setText(Integer.toBinaryString(hex));
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }

    // conversion from HEXADECIMAL to DECIMAL
    private void fromHexadecimalToDecimal() {
        try {
            hex = Integer.parseInt(inputTF.getText(), 16);
            resultTF.setText(hex.toString());
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }

    // conversion from HEXADECIMAL to OCTAL
    private void fromHexadecimalToOctal() {
        try {
            hex = Integer.parseInt(inputTF.getText(), 16);
            resultTF.setText(Integer.toOctalString(hex));
        } catch (Exception ex) {
            resultTF.setText("INVALID!");
        }
    }
    
}
