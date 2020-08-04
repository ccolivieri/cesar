import java.util.ArrayList;
import java.util.Scanner;

public class Principal {


    private static ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    public static void main(String args[]){
        int opcion;
        int nroProducto;
        int cantidad;

        JavaUtils.ingresoMenu();
        opcion = JavaUtils.ingresoOpcion();

        while (opcion != 7){

            if(opcion == 1){
                cargarPerecedero();

            }else if(opcion == 2){
                cargarNoPerecedero();

            }else if (opcion == 3){
                ArrayListUtils.mostrarProductosPerecederos(listaProductos);

            }else if(opcion == 4){
                ArrayListUtils.mostrarProductosNoPerecederos(listaProductos);

            }else if(opcion == 5){
                ArrayListUtils.mostrarProductos(listaProductos);
                nroProducto = JavaUtils.ingresarNumeroProducto();
                System.out.println(ArrayListUtils.calcularIva(listaProductos.get(nroProducto--)));

            }else if(opcion == 6){
                ArrayListUtils.mostrarProductos(listaProductos);
                nroProducto = JavaUtils.ingresarNumeroProducto();
                cantidad = JavaUtils.ingresarCantidad("Ingresar la cantidad de productos:");
                System.out.println("Precio final: " + listaProductos.get(nroProducto--).calcular(cantidad));

            }else if(opcion == 7){
                JavaUtils.salidaMenu();
                break;

            }else {
                System.out.println("Opción incorrecta, ingrese nuevamente!");
            }
            opcion = JavaUtils.ingresoOpcion();
        }
    }

    private static void cargarPerecedero(){
        String nombre;
        float precio;
        int diasCaducar;

        JavaUtils.presentacionCargaProducto("***Carga de un Producto Perecedero***");
        nombre = JavaUtils.ingresarNombre("Ingrese el nombre: ");
        precio = JavaUtils.ingresarPrecio("\nIngrese el precio: ");
        diasCaducar = JavaUtils.ingresarDiaCaducar("\nIngrese la cantidad de días a caducar: ");

        Perecedero unPerecedero = new Perecedero(nombre, precio, diasCaducar);
        listaProductos.add(unPerecedero);
        System.out.println("\nProducto cargado!!");
    }

    private static void cargarNoPerecedero(){
        String nombre;
        float precio;
        String tipo;

        JavaUtils.presentacionCargaProducto("***Carga de un Producto No Perecedero***");
        nombre = JavaUtils.ingresarNombre("Ingrese el nombre: ");
        precio = JavaUtils.ingresarPrecio("\nIngrese el precio: ");
        tipo = JavaUtils.ingresarTipo("\nIngrese el tipo: ");

        NoPerecedero unNoPerecedero = new NoPerecedero(nombre, precio, tipo);
        listaProductos.add(unNoPerecedero);
        System.out.println("\nProducto cargado!!");
    }
}
