import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un label con el texto "Hello, World!"
        Label helloLabel = new Label("Hello, World!");
        
        // Crear un layout y agregar el label
        StackPane root = new StackPane();
        root.getChildren().add(helloLabel);
        
        // Crear la escena con el layout
        Scene scene = new Scene(root, 300, 200);
        
        // Configurar el escenario (ventana)
        primaryStage.setTitle("Hello World Window");
        primaryStage.setScene(scene);
        
        // Mostrar la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Iniciar la aplicación JavaFX
    }
}
