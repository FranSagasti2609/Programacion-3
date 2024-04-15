package PropiedadesPOO.Herencia;

public class Mascota {
    // Atributos de la clase.
    private String nombre;
    private int edad;
    private String dueño;
  
    // Constructor por defecto
    public Mascota() {
    }
    public Mascota(String nom, int age, String owner){
      this.nombre = nom;
      this.edad = age;
      this.dueño = owner;
    }
    // Métodos
    void dormir() {
      System.out.println("zzz.... zzzz...");
    }
  }