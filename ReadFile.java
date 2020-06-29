import java.io.File;  // Importamos la clase File para manejar nuestro archivo
import java.io.FileNotFoundException;  // Importamos esta clase para manejar errores
import java.util.Scanner; // Importamos esto para leer archivos de texto línea por línea
import java.util.LinkedList; // Importamos para hacer una lista de cuentas bancarias.
import java.util.Iterator; // Importamos esto para poder hacer algo tipo 'for cuenta in cuentas:'

public class ReadFile {
  static LinkedList<Cuenta> cuentas;
  static LinkedList<FormaDeAhorro> ahorros;
  
  // getCuenta recibe un número de cuenta y retorna la cuenta correspondiente, suponiendo que está en la lista.
  public static Cuenta getCuenta(Integer númeroDeCuenta) {
    Iterator<Cuenta> iterator = cuentas.iterator();
    while(iterator.hasNext()){
      Cuenta cuenta = iterator.next();
      if(cuenta.getNúmeroDeCuenta() == númeroDeCuenta) {
        return(cuenta);
      }
    }
    return(null);
  }

  // getFondoMutuo recibe un ID y retorna el fondo correspondiente, suponiendo que está en la lista.
  public static FondoMutuo getFondoMutuo(String ID) {
    Iterator<FormaDeAhorro> iterator = ahorros.iterator();
    while(iterator.hasNext()){
      FormaDeAhorro ahorro = iterator.next();
      if((ahorro instanceof FondoMutuo) && ((FondoMutuo)ahorro).getID().equals(ID)) {
        return((FondoMutuo) ahorro);
      }
    }
    return(null);
  }

  // Debe implementar este método
  public static void transferir(Integer monto, Integer origen, Integer destino, String comando) {
    /* Rellenar aquí */
  }

  public static void main(String[] args) {
    cuentas = new LinkedList<Cuenta>();
    ahorros = new LinkedList<FormaDeAhorro>();
    FondoMutuo.setCrecimiento(1f);
    try {
      File myObj = new File(args[0]);
      Scanner myReader = new Scanner(myObj, "UTF8");
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] command = data.split("\\s+");
        if(command[0].equals("crearCuentaVista")) {
          cuentas.add( new CuentaVista(Integer.parseInt(command[1]))); // Crea una nueva cuenta vista, indicando monto inicial
        } else if(command[0].equals("crearCuentaDeAhorro")) {
          CuentaDeAhorro cuenta;
          if(command.length > 2) {
            cuenta = new CuentaDeAhorro(Integer.parseInt(command[1]), Float.parseFloat(command[2])); // Crea una nueva cuenta de ahorro, indicando monto inicial y tasa
          } else {
            cuenta = new CuentaDeAhorro(Integer.parseInt(command[1])); // Crea una nueva cuenta de ahorro, indicando monto inicial. La tasa queda implicita como 1.0001
          }
          cuentas.add(cuenta);
          ahorros.add(cuenta);
        } else if(command[0].equals("crearCuentaCorriente")) {
          cuentas.add( new CuentaCorriente(Integer.parseInt(command[1]))); // Crea una nueva cuenta vista, indicando monto inicial
        } else if(command[0].equals("crearDepósitoAPlazo")) {
          Cuenta cuenta = getCuenta(Integer.parseInt(command[2]));
          ahorros.add( new DepósitoAPlazo(Integer.parseInt(command[1]), cuenta, Integer.parseInt(command[3]))); // Crea un nuevo depósito a plazo, indicando monto inicial, cuenta y duración en días.
        } else if(command[0].equals("crearFondoMutuo")) {
          Cuenta cuenta = getCuenta(Integer.parseInt(command[2]));
          ahorros.add( new FondoMutuo(Integer.parseInt(command[1]), cuenta, command[3])); // Crea un nuevo fondo mutuo, indicando monto inicial, cuenta e ID.
        } else if(command[0].equals("cobrarFondoMutuo")) {
          FondoMutuo fondo = getFondoMutuo(command[1]);
          fondo.cobrar(); // Transfiere todo el dinero de cierto fondo mutuo a su cuenta asociada
        } else if (command[0].equals("abonar")) {
          Cuenta cuenta = getCuenta(Integer.parseInt(command[2]));
          cuenta.abonar(Integer.parseInt(command[1])); // Le agrega dinero a una cuenta
        } else if (command[0].equals("retirar")) {
          Cuenta cuenta = getCuenta(Integer.parseInt(command[2]));
          try {
            cuenta.retirar(Integer.parseInt(command[1])); // Le quita dinero a una cuenta
          } catch(Exception e) { 
            System.out.println("Ha habido un problema al hacer este retiro.");
            System.out.println(data);
          }
        } else if (command[0].equals("transferir")) {
          transferir(Integer.parseInt(command[1]), Integer.parseInt(command[2]), Integer.parseInt(command[3]), data);
        } else if(command[0].equals("actualizarDía")) {
          Iterator<FormaDeAhorro> iterator = ahorros.iterator();
          while(iterator.hasNext()) { // Por cada forma de ahorro de la lista, aplica el interés correspondiente
            FormaDeAhorro ahorro = iterator.next();
            ahorro.actualizar();
          }
        } else if(command[0].equals("actualizarPIB")) {
          FondoMutuo.setCrecimiento(Float.parseFloat(command[1]));
        } else if(command[0].equals("verTotal")) {
          Integer suma = 0; // Sumamos los montos de todos los elementos listados
          Iterator<FormaDeAhorro> iterator = ahorros.iterator();
          while(iterator.hasNext()) {
            FormaDeAhorro ahorro = iterator.next();
            suma += ahorro.getMonto();
          }
          Iterator<Cuenta> iteratorCuentas = cuentas.iterator();
          while(iteratorCuentas.hasNext()) {
            Cuenta cuenta = iteratorCuentas.next();
            if(!(cuenta instanceof FormaDeAhorro)) {
              suma += cuenta.getSaldo();
            }
          }
          System.out.print("En total el cliente tiene: ");
          System.out.println(suma);
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
