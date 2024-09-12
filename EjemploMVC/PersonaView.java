// Clase Vista
import java.util.Scanner;

public class PersonaView {
    private PersonaController controlador;
    private Scanner scanner;

    // Constructor que recibe el controlador y configura el scanner para la entrada del usuario
    public PersonaView(PersonaController controlador) {
        this.controlador = controlador;
        scanner = new Scanner(System.in);
    }

    // Mostrar los datos actuales de la persona
    public void mostrarDetallesPersona() {
        System.out.println("Nombre: " + controlador.obtenerNombre());
        System.out.println("Edad: " + controlador.obtenerEdad());
    }

    // Actualizar el nombre basado en la entrada del usuario
    public void cambiarNombre() {
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        controlador.actualizarNombre(nuevoNombre);
        System.out.println("Nombre actualizado exitosamente.");
    }

    // Actualizar la edad basado en la entrada del usuario
    public void cambiarEdad() {
        System.out.print("Ingrese la nueva edad: ");
        int nuevaEdad = scanner.nextInt();
        controlador.actualizarEdad(nuevaEdad);
        System.out.println("Edad actualizada exitosamente.");
    }
}
