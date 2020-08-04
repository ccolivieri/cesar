import java.util.Scanner;

public class JavaUtils {

    private static Scanner input = new Scanner(System.in);
    private static int opcion = 0;

    public static void ingresoMenu(){
        System.out.println("---MENU DE OPCIONES---");
        System.out.println("Seleccione una opción:");
    }

    public static void salidaMenu(){
        System.out.println("Hasta pronto!");
    }

    public static int ingresoOpcion(){

        System.out.println("1- Agregar un producto perecedero.");
        System.out.println("2- Agregar un producto no perecedero.");
        System.out.println("3- Ver productos perecederos.");
        System.out.println("4- Ver productos no perecederos.");
        System.out.println("5- Calcular IVA de un producto");
        System.out.println("6- Calcular precio final de un producto");
        System.out.println("7- Salir del menú.");
        opcion = input.nextInt();

        return opcion;
    }

    public static int ingresarNumeroProducto(){
        System.out.println("Ingrese un número de producto:");
        opcion = input.nextInt();
        return opcion;
    }

    public static void presentacionCargaProducto(String mensaje){
        System.out.println(mensaje);
    }

    public static String ingresarNombre(String mensaje){
        String nombre;

        System.out.println(mensaje);
        nombre = input.next();
        return nombre;
    }

    public static Float ingresarPrecio(String mensaje){
        float precio;

        System.out.println(mensaje);
        precio = input.nextFloat();
        return precio;
    }

    public static int ingresarDiaCaducar(String mensaje){
        int diaCaducar;

        System.out.println(mensaje);
        diaCaducar = input.nextInt();
        return diaCaducar;
    }

    public static String ingresarTipo(String mensaje){
        String tipo;

        System.out.println(mensaje);
        tipo = input.next();
        return tipo;
    }

    public static int ingresarCantidad(String mensaje){
        int cantidad = 0;

        System.out.println(mensaje);
        cantidad = input.nextInt();
        return cantidad;
    }
}
