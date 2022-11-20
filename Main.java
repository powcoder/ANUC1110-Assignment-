package ANUC1110;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group(), 450, 250);
        stage.setTitle("ANUC Student List");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
//Defining the Name text field
         TextField name = new TextField();
        name.setPromptText("Enter your name.");
        name.setPrefColumnCount(10);
        name.getText();
        GridPane.setConstraints(name, 0, 0);
        grid.getChildren().add(name);
//Defining the Last Name text field

        TextField age = new TextField() {

            public void replaceText(int start, int end, String text) {
                if (!text.matches("[a-z]")) {
                    super.replaceText(start, end, text);
                }
            }

            public void replaceSelection(String text) {
                if (!text.matches("[a-z]")) {
                    super.replaceSelection(text);
                }
            }
        };
        //Defining the age text field

        age.setPromptText("Enter your age.");
        GridPane.setConstraints(age, 0, 1);
        grid.getChildren().add(age);

        //Defining the gender text field
        final TextField gender = new TextField();

        gender.setPrefColumnCount(15);
        gender.setPromptText("Enter your gender.");
        GridPane.setConstraints(gender, 0, 2);
        grid.getChildren().add(gender);

        //Defining the add button
        Button add = new Button("Add");
        GridPane.setConstraints(add, 2, 0);
        grid.getChildren().add(add);

        //Defining the print button
        Button print = new Button("Print");
        GridPane.setConstraints(print, 2, 1);
        grid.getChildren().add(print);


        Button search = new Button("Search");
        GridPane.setConstraints(search, 2, 2);
        grid.getChildren().add(search);

        Button delete = new Button("Delete");
        GridPane.setConstraints(delete, 2, 3);
        grid.getChildren().add(delete);

        final Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

//Setting an action for the print button
        print.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if ((gender.getText() != null && !gender.getText().isEmpty())) {
                    label.setText("There are" + "1 people on the list"+ "\n"+name.getText() + " " + age.getText() + " "+ gender.getText()
                    );
                } else {
                    label.setText("please enter all the information");

                }
            }
        }); //Student.addStudent(name.getText(),Integer.parseInt(age.getText()),gender.getText().charAt(0))

//Setting an action for the add button "1 person has been added to the list"
        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                label.setText("1 person has been added to the list");


            }
        });


        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }
}
