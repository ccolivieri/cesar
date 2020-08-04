import java.util.ArrayList;

public class ArrayListUtils {

    public static void mostrarProductosPerecederos(ArrayList<Producto> listaProductos){

        for(Producto p: listaProductos){
            if(p instanceof Perecedero){
                System.out.println(p.toString() + " - Precio final: " + p.calcular(((Perecedero) p).getDiasCaducar()));
            }
        }
    }

    public static void mostrarProductosNoPerecederos(ArrayList<Producto> listaProductos){

        for (Producto p: listaProductos){
            if(p instanceof NoPerecedero){
                System.out.println(p.toString() + " - Precio final: " + p.calcular(1));
            }
        }
    }

    public static double calcularIva(Producto unProducto){
        return (unProducto.getPrecio() * Constantes.IVA_2020)/100;
    }

    public static void mostrarProductos(ArrayList<Producto> listaProductos){

        int opcion = 1;
        for(Producto p: listaProductos){
            System.out.println(opcion + " " + p.getNombre());
            opcion++;
        }
    }
}
