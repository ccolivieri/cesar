import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    public static void main(String args[]){
        int opcion = 0;

        System.out.println("---MENU DE OPCIONES---");
        System.out.println("Seleccione una opción:");

        while (opcion != 5){
            System.out.println("1- Agregar un producto perecedero.");
            System.out.println("2- Agregar un producto no perecedero.");
            System.out.println("3- Ver productos perecederos.");
            System.out.println("4- Ver productos no perecederos.");
            System.out.println("5- Salir del menú.");
            opcion = input.nextInt();

            if(opcion == 1){
                cargarPerecedero();
            }else if(opcion == 2){
                cargarNoPerecedero();
            }else if (opcion == 3){
                mostrarProductosPerecederos();
            }else if(opcion == 4){
                mostrarProductosNoPerecederos();
            }else if(opcion == 5){
                System.out.println("Hasta pronto!");
            }else {
                System.out.println("Opción incorrecta, ingrese nuevamente!");
            }
        }
    }

    private static void cargarPerecedero(){
        String nombre;
        float precio;
        int diasCaducar;

        System.out.println("***Carga de un Producto Perecedero***");
        System.out.print("Ingrese el nombre: ");
        nombre = input.next();
        System.out.print("\nIngrese el precio: ");
        precio = input.nextFloat();
        System.out.print("\nIngrese la cantidad de días a caducar: ");
        diasCaducar = input.nextInt();

        Perecedero unPrerecedero = new Perecedero(nombre, precio, diasCaducar);
        listaProductos.add(unPrerecedero);
    }

    private static void cargarNoPerecedero(){
        String nombre;
        float precio;
        String tipo;

        System.out.println("***Carga de un Producto No Perecedero***");
        System.out.print("Ingrese el nombre: ");
        nombre = input.next();
        System.out.print("\nIngrese el precio: ");
        precio = input.nextFloat();
        System.out.print("\nIngrese el tipo: ");
        tipo = input.next();

        NoPerecedero unNoPrerecedero = new NoPerecedero(nombre, precio, tipo);
        listaProductos.add(unNoPrerecedero);
    }

    private static void mostrarProductosPerecederos(){

        for(Producto p: listaProductos){
            if(p instanceof Perecedero){
                System.out.println(p.toString() + " - Precio final: " + p.calcular(((Perecedero) p).getDiasCaducar()));
            }
        }
    }

    private static void mostrarProductosNoPerecederos(){

        for (Producto p: listaProductos){
            if(p instanceof NoPerecedero){
                System.out.println(p.toString() + " - Precio final: " + p.calcular(1));
            }
        }
    }
}
