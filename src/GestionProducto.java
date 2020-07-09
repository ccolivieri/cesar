import java.util.Scanner;

public class GestionProducto {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        String nombre;
        int codigo;
        int importado;
        String nroLote;
        Producto p1 = new Producto();
        Producto p2 = new Producto();
        Producto p3 = new Producto();

        System.out.println("Ingrese el nombre del primer producto: ");
        nombre = input.nextLine();
        System.out.println("Ingrese el código del primer producto: ");
        codigo = input.nextInt();
        System.out.println("¿El producto es importado? Ingrese 1 = Importado, 2 = Nacional");
        importado = input.nextInt();
        System.out.println("Ingrese número de lote: ");
        nroLote = input.nextLine();

        if(importado == 1){
            p1 = new Producto(nombre, codigo, true, nroLote);
        }else {
            p1 = new Producto(nombre, codigo, false, nroLote);
        }

        System.out.println("Ingrese el nombre del segundo producto: ");
        nombre = input.nextLine();
        System.out.println("Ingrese el código del segundo producto: ");
        codigo = input.nextInt();
        System.out.println("¿El producto es importado? Ingrese 1 = Importado, 2 = Nacional");
        importado = input.nextInt();
        System.out.println("Ingrese número de lote: ");
        nroLote = input.nextLine();

        if(importado == 1){
            p2 = new Producto(nombre, codigo, true, nroLote);
        }else {
            p2 = new Producto(nombre, codigo, false, nroLote);
        }

        System.out.println("Ingrese el nombre del tercer producto: ");
        nombre = input.nextLine();
        System.out.println("Ingrese el código del tercer producto: ");
        codigo = input.nextInt();
        System.out.println("¿El producto es importado? Ingrese 1 = Importado, 2 = Nacional");
        importado = input.nextInt();
        System.out.println("Ingrese número de lote: ");
        nroLote = input.nextLine();

        if(importado == 1){
            p3 = new Producto(nombre, codigo, true, nroLote);
        }else {
            p3 = new Producto(nombre, codigo, false, nroLote);
        }

        System.out.println("Info de todos los productos cargados:");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}
