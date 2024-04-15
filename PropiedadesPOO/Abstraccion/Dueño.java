package PropiedadesPOO.Abstraccion;


public class Dueño{
    public String nombre;
    private int edad;  
  
    //Constructores
    //Default.
    public Dueño(){}
  
    public Dueño(String nom, int age){
      this.nombre = nom;
      this.edad = age;
    }
  }