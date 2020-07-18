package Practico_6;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej_listas {

    private static Scanner input = new Scanner(System.in);

    public static void main(String args[]){

        ArrayList<Integer> listaEnteros = new ArrayList<Integer>();
        ArrayList<String> listaStrings = new ArrayList<String>();
        ArrayList<Boolean> listaBoleanos = new ArrayList<Boolean>();

        listaEnteros = leerValores();
        cargarListaStrings(listaStrings);
        cargarListaBooleanos(listaBoleanos);

        imprimirListaEnteros(listaEnteros);
        imprimirListaStrings(listaStrings);
        System.out.println("Cantidad de elementos de la lista de enteros: " + contarEnteros(listaEnteros));
        System.out.println("Lista de booleanos: " + estaVacia(listaBoleanos));
        System.out.println("Promedio de lista de enteros: " + promedio(listaEnteros));
        System.out.println("El menor valor de la lista d enteros es: " + menorElemento(listaEnteros));
        System.out.println("El mayor valor de la lista de enteros es: " + mayorElemento(listaEnteros));
        System.out.println("Son todos verdaderos la lista de booleanos?: " + todosVerdaderos(listaBoleanos));
    }

    private static void cargarListaStrings(ArrayList<String> lista){
        String palabra = "";

        System.out.println("Para cargar la lista ingrese cadenas (Si ingresa null o Null terminará la carga)");
        palabra = input.nextLine();

        if(palabra.equals(new String(palabra)) == true){
            lista.add(palabra);
        }else{
            while (palabra.equals(new String(palabra)) != true){
                System.out.println("Cargar palabra (si ingresa null o Null terminará la carga)");
                palabra = input.nextLine();
                lista.add(palabra);
            }
        }
    }

    private static void cargarListaBooleanos(ArrayList<Boolean> lista){
        boolean bol;

        System.out.println("Para cargar la lista ingrese booleanos (Si ingresa null o Null terminará la carga)");
        bol = input.nextBoolean();

        if(bol == true){
            lista.add(bol);
        }else{
            while (bol != true){
                System.out.println("Cargar palabra (si ingresa null o Null terminará la carga)");
                bol = input.nextBoolean();
                lista.add(bol);
            }
        }
    }

    //Crear un método imprimirListaEnteros que reciba una lista de enteros, y los imprima en pantalla.
    private static void imprimirListaEnteros(ArrayList<Integer> lista){
        System.out.println("Imprimir elementos de la lista.");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    //Crear un método imprimirListaStrings que reciba una lista de Strings, y los imprima en pantalla.
    private static void imprimirListaStrings(ArrayList<String> lista){
        System.out.println("Imprimir listado de strings");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    //Método que reciba una lista de enteros, y retorne la cantidad de elementos de la misma.
    private static int contarEnteros(ArrayList<Integer> lista){
        int cantidad = 0;

        for (int i = 0; i < lista.size(); i++) {
            cantidad++;
        }
        return cantidad;
    }

    //Método que reciba una lista de enteros, y retorne verdadero si y sólo si la lista está vacía.
    private static boolean estaVacia(ArrayList<Boolean> lista){
        boolean vacia = false;

        if(lista.isEmpty() == true){
            vacia = true;
        }
        return vacia;
    }

    //Método que reciba una lista de enteros, y retorne la suma.
    private static int sumaEnteros(ArrayList<Integer> lista){
        int suma = 0;

        for (int i = 0; i < lista.size(); i++) {
            suma += lista.get(i);
        }
        return suma;
    }

    //Método que reciba una lista de enteros, y retorne el promedio de los mismos.
    private static float promedio(ArrayList<Integer> lista){
        return sumaEnteros(lista) / lista.size();
    }

    //Método que reciba una lista de enteros, y retorne el menor.
    private static int menorElemento(ArrayList<Integer> lista){
        int menor = Integer.MIN_VALUE;

        for (int i = 0; i < lista.size(); i++) {
            if(menor > lista.get(i)){
                menor = lista.get(i);
            }
        }
        return menor;
    }

    //Método que reciba una lista de enteros, y retorne el mayor.
    private static int mayorElemento(ArrayList<Integer> lista){
        int mayor = Integer.MAX_VALUE;

        for (int i = 0; i < lista.size(); i++) {
            if(mayor < lista.get(i)){
                mayor = lista.get(i);
            }
        }
        return mayor;
    }

    /*
    Método que reciba una lista de booleanos, y retorne verdadero si y sólo si, todos los elementos
    de la lista son true. De lo contrario se debe retornar false. Sugerencia: utilizar cortocircuito.
    * */
    private static boolean todosVerdaderos(ArrayList<Boolean> lista){
        boolean verdaderos = true;

        for (int i = 0; i < lista.size(); i++) {
            if(lista.isEmpty() == false && lista.get(i) == false){
                verdaderos = false;
            }
        }
        return verdaderos;
    }

    /*
    Método leerValores(): pide por teclado los números y los almacena en el ArrayList.
    La lectura acaba cuando se introduce el valor -99. El método devuelve mediante return el ArrayList
    con los valores introducidos.
    * */
    private static ArrayList<Integer> leerValores(){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int valor = 0;

        System.out.println("Ingrese un valor a almacenar en el array:");
        valor = input.nextInt();

        if(valor == -99){
            return lista;
        }else {
            lista.add(valor);
            while (valor != -99){
                System.out.println("Ingrese otro valor a almacenar en el array (-99 finaliza la carga):");
                valor = input.nextInt();
                if(valor == -99){
                    return lista;
                }else {
                    lista.add(valor);
                }
            }
        }
        return lista;
    }
}
