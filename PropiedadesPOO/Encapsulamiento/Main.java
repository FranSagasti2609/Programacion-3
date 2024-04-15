package PropiedadesPOO.Encapsulamiento;

public class Main {
    public static void main(String[] args) {

        // Ejemplo de clase Empleado
        Empleado empEjemplar = new Empleado(12345678, "Av Artigas 541", 25000, "Pepe");
    
        // Intentamos imprimir y modificar atributos privados
        // empEjemplar.CI = 00000;
        // System.out.println(empEjemplar.CI);
    
        // Saldran errores!, comenta estas lineas y mira como se resuelve...
    
        empEjemplar.setCI(987);
        // System.out.println(empEjemplar.CI);
        int newCI = empEjemplar.getCI();
        System.out.println(newCI);
    
      }
}
