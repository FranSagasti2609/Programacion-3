package PropiedadesPOO.Abstraccion;

//clase perro

public class Perro {
    // Atributos de la clase.
    private String nombre;
    private int edad;
    private Dueño Dueño;
  
    // Metodos
    void ladrar() {
      System.out.println("Guaf!");
    }

    String getOwner(){
        return this.Dueño.nombre;
    }
  
    //Constructor
    public Perro(String nom, int age, Dueño owner){
      this.nombre = nom;
      this.edad = age;
      this.Dueño = owner;
    }
  
    //Default
    public Perro(){}
    
  
  };
  
