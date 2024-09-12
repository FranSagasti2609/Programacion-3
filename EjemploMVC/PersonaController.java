// Clase Controlador
public class PersonaController {
    private Persona persona;

    // Constructor que inicializa el modelo (Persona)
    public PersonaController(Persona persona) {
        this.persona = persona;
    }

    // Método para actualizar el nombre de la persona
    public void actualizarNombre(String nuevoNombre) {
        persona.setNombre(nuevoNombre);
    }

    // Método para actualizar la edad de la persona
    public void actualizarEdad(int nuevaEdad) {
        persona.setEdad(nuevaEdad);
    }

    // Método para obtener el nombre actual
    public String obtenerNombre() {
        return persona.getNombre();
    }

    // Método para obtener la edad actual
    public int obtenerEdad() {
        return persona.getEdad();
    }
}
