package no.ntnu.filipbv.cardgame;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


/**
 * Lager GUI og starter applikasjonen
 *
 */
public class Main extends App {

    /**
     * Starter programmet
     *
     */
    public static void main(String[] args) {
        launch(args);
    }

    static DeckOfCards deck;
    static Hand hand = null;

    @Override
    public void start(Stage primaryStage) {
        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 500, 500);
        TextArea area = new TextArea();
        area.setDisable(true);

        layout.setBackground(new Background(new BackgroundFill(Color.rgb(5,170,70),CornerRadii.EMPTY,Insets.EMPTY)));

        deck = new DeckOfCards();
        Button button2 = new Button("Check Hand");
        button2.setDisable(true);
        Button button = new Button("Deal Hand");
        button.setOnAction((event) -> {
            hand = deck.dealHand(5);
            area.setText(hand.toString());
            button2.setDisable(false);
        });


        button2.setOnAction((event) -> {
            if (hand != null) {
                area.appendText("\n");
                area.appendText("Sum of Hand: " + hand.calculateSum() + "\n");
                area.appendText(hand.getHearts() + "\n");
                area.appendText("Has Queen of Spades: " + hand.hasQueenOfSpades() + "\n");
                area.appendText("5-Flush: " + hand.fiveFlush() + "\n");
                button2.setDisable(true);
            }
        });

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);

        vbox.getChildren().addAll(area, button, button2);
        layout.getChildren().addAll(vbox);

        primaryStage.setTitle("Card-Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

