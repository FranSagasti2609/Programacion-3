package PropiedadesPOO.Polimorfismo;


public class Main {

    public static void main(String[] args) {
      //Creo ave.
  
      Ave miAve = new Ave();
      Gato miGato = new Gato();
  
      //Mismo metodo, distinto corpotamiento.
      miAve.sonido();
      miGato.sonido();
  
    }
  
  }