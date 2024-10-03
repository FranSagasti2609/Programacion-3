import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Tateti extends Application {

    private char currentPlayer = 'X';  // Empieza el jugador de las X
    private Button[][] board = new Button[3][3];  // Botones del tablero
    private boolean gameActive = true;  // Controla si el juego sigue activo

    public static void main(String[] args) {
        launch(args);  // Iniciar la aplicación JavaFX
    }

    @Override
    public void start(Stage primaryStage) {
        //Aqui establecemos el titulo de la ventana
        primaryStage.setTitle("TaTeTi Master!");

        // Crear el tablero usando GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);

        // Crear los botones del tablero
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button btn = new Button("");
                btn.setFont(Font.font(36));  // Fuente grande para X y O
                btn.setPrefSize(100, 100);
                final int r = row;
                final int c = col;
                
                // Acción del botón
                btn.setOnAction(e -> handleButtonClick(r, c));
                
                board[row][col] = btn;  // Guardar botón en la matriz
                grid.add(btn, col, row);  // Agregar botón al grid
            }
        }

        // Crear la escena y agregarla al escenario
        Scene scene = new Scene(grid, 350, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Manejar el clic en un botón
    private void handleButtonClick(int row, int col) {
        if (!gameActive || !board[row][col].getText().equals("")) {
            return;  // Si el juego terminó o el botón ya está ocupado, no hacer nada
        }

        // Colocar el símbolo del jugador actual
        board[row][col].setText(String.valueOf(currentPlayer));

        // Verificar si alguien ha ganado
        if (checkWin()) {
            showAlert("El jugador " + currentPlayer + " gano!");
            gameActive = false;
        } else if (isBoardFull()) {
            showAlert("Esto es un empate! Bien jugado.");
            gameActive = false;
        } else {
            // Cambiar al siguiente jugador
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Verificar si el tablero está lleno
    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col].getText().equals("")) {
                    return false;  // Aún hay espacio
                }
            }
        }
        return true;  // El tablero está lleno
    }

    // Verificar si hay un ganador
    private boolean checkWin() {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) return true;  // Filas
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) return true;  // Columnas
        }
        // Verificar diagonales
        return checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0]);
    }

    // Verificar si tres botones tienen el mismo texto y no están vacíos
    private boolean checkRowCol(Button b1, Button b2, Button b3) {
        return !b1.getText().equals("") && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText());
    }

    // Mostrar un mensaje cuando alguien gana o hay un empate
    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("¡Juego Finalizado!");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
