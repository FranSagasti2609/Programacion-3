public class Main {
    public static void main(String[] args) {
        // Crear el modelo
        Persona persona = new Persona("Juan", 25);
        
        // Crear el controlador
        PersonaController controlador = new PersonaController(persona);
        
        // Crear la vista
        PersonaView vista = new PersonaView(controlador);
        
        // Mostrar los datos actuales
        vista.mostrarDetallesPersona();
        
        // Cambiar el nombre
        vista.cambiarNombre();
        
        // Cambiar la edad
        vista.cambiarEdad();
        
        // Mostrar los datos actualizados
        vista.mostrarDetallesPersona();
    }
}
