package application;

//Main.java
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

 TableView<Student> tableView;
 TextField nameField, idField, emailField;
 RadioButton maleRadio, femaleRadio;
 CheckBox termsCheckbox;

 @Override
 public void start(Stage primaryStage) {
     // Creating form components
     Label nameLabel = new Label("Name:");
     nameField = new TextField();

     Label idLabel = new Label("ID:");
     idField = new TextField();

     Label emailLabel = new Label("Email:");
     emailField = new TextField();

     ToggleGroup genderGroup = new ToggleGroup();
     Label genderLabel = new Label("Gender:");
     maleRadio = new RadioButton("Male");
     maleRadio.setToggleGroup(genderGroup);
     femaleRadio = new RadioButton("Female");
     femaleRadio.setToggleGroup(genderGroup);

     Label termsLabel = new Label("Agree to Terms and Conditions:");
     termsCheckbox = new CheckBox();

     Button submitButton = new Button("Submit");
     submitButton.setOnAction(e -> addStudent());

     // Creating table view
     tableView = new TableView<>();
     TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
     nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
     TableColumn<Student, String> idColumn = new TableColumn<>("ID");
     idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
     TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
     emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
     TableColumn<Student, String> genderColumn = new TableColumn<>("Gender");
     genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

     tableView.getColumns().addAll(nameColumn, idColumn, emailColumn, genderColumn);

     // Creating layout
     VBox formLayout = new VBox(10);
     formLayout.getChildren().addAll(
             nameLabel, nameField,
             idLabel, idField,
             emailLabel, emailField,
             genderLabel, maleRadio, femaleRadio,
             termsLabel, termsCheckbox,
             submitButton
     );

     BorderPane root = new BorderPane();
     root.setTop(formLayout);
     root.setCenter(tableView);

     Scene scene = new Scene(root, 600, 400);
     scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

     primaryStage.setTitle("Student Registration Form");
     primaryStage.setScene(scene);
     primaryStage.show();
 }

 private void addStudent() {
     String name = nameField.getText();
     String id = idField.getText();
     String email = emailField.getText();
     String gender = maleRadio.isSelected() ? "Male" : "Female";

     if (!name.isEmpty() && !id.isEmpty() && !email.isEmpty() && (maleRadio.isSelected() || femaleRadio.isSelected())) {
         tableView.getItems().add(new Student(name, id, email, gender));
         clearFields();
     } else {
         Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle("Incomplete Form");
         alert.setHeaderText(null);
         alert.setContentText("Please fill out all fields and select a gender.");
         alert.showAndWait();
     }
 }

 private void clearFields() {
     nameField.clear();
     idField.clear();
     emailField.clear();
     maleRadio.setSelected(false);
     femaleRadio.setSelected(false);
     termsCheckbox.setSelected(false);
 }

 public static void main(String[] args) {
     launch(args);
 }
}
