import com.sun.javafx.scene.control.skin.ButtonSkin;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class EventTest extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {


        final int importantNumber = 10;

        GridPane gp = new GridPane();
        gp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                System.out.println("gridpane clicked");
                System.out.println("-----");
            }
        });


        Scene scene = new Scene(gp,600,600);


        Label label = new Label("I am a label");
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("you clicked the label");
                //event.consume();
                System.out.println("value of lable: " + label.getText());

            }
        });


        Button btn = new Button("i am a button");



        btn.setOnMouseClicked( new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("button setOnMouseClicked 1");
                //event.consume();
            }
        } );

        btn.setOnMouseClicked( new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("button setOnMouseClicked 2");
                System.out.println("-----");
                //event.consume();
            }
        } );


        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouseclick event 1");
                //event.consume();
            }
        });

        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouseclick event 2");

            }
        });


        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, egon -> {
            System.out.println("button filter activated");
            //something(1);
            //event.consume();
        });

        TextField tx = new TextField();
        tx.setPrefWidth(200);
        tx.setPrefHeight(200);



        tx.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if( event.getCode().equals(KeyCode.LEFT)){
                    System.out.println("Yes this was left");
                }

                System.out.println("the key pressed was: " + event.getCode().getName());
            }
        });


        HBox hbox = new HBox();
        hbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                System.out.println("hbox clicked");
                //event.consume();
            }
        });


        hbox.getChildren().add(label);

        hbox.getChildren().add(btn);

        hbox.getChildren().add(tx);

        gp.add(hbox,0,0);

        primaryStage.setScene(scene);
        primaryStage.setTitle("event bubble");
        primaryStage.show();


    }

    public void something( int i)
    {
        //do someting with a
        System.out.println(i);
    }

}
