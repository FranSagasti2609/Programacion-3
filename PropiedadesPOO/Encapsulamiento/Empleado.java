package PropiedadesPOO.Encapsulamiento;

public class Empleado{

    //Atributos Privados: No podran ser modificados ni accedidos desde una clase externa
    private int CI;
    private String Direccion;
  
    //Atributos Publicos: Pueden ser accedidos y modificados desde fuera de la clase "Empleado"
    public int Salario;
    public String Nombre;
  
    //Metodos "get" y "set", sirven para modificar y obtener los atributos privados de clase
    public int getCI(){
      return this.CI;
    }
  
    public String getDir(){
      return this.Direccion;
    }
  
    public void setCI(int Cedula){
      this.CI = Cedula;
    }
    
    public void setDir(String newDir){
      this.Direccion = newDir;
    }
  
    //Constructor
    public Empleado(){}
  
    public Empleado(int Cedula, String Dir, int salario, String nom){
      this.CI = Cedula;
      this.Direccion = Dir;
      this.Salario = salario;
      this.Nombre = nom;
    }
    
  }