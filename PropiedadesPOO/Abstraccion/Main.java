package PropiedadesPOO.Abstraccion;

//Clase Main.

//La idea de este ejercicio es poder relacionar una clase "Dueño" con otra llamada perro. Pudiendonos centrar en lo escencial de cada una, y luego relacionarlas.
public class Main { 
    //Declaramos Dueño
    static Dueño franchu = new Dueño("Fran", 22);
    //Declaramos ejemplo de mascota.
    static Perro mascota1 = new Perro("Boby",4,franchu);
    static String DueñoMasc1 = mascota1.getOwner();
    public static void main(String[] args) {
      System.out.println("Hola Abstraccion.");
      System.out.println("Mi Dueño es " + DueñoMasc1);
    }
  
  }