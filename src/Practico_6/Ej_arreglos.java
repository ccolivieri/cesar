package Practico_6;

import javax.naming.PartialResultException;
import java.util.Scanner;

public class Ej_arreglos {

    public static void main(String args[]){

        double[] arr_double = new double[16];
        boolean[] arr_boolean = new boolean[9];
        int[] arr_numeros = new int[100];
        double[] arr_aleatoreos = new double[50];
        boolean[] asientosLibres = new boolean[10];
        int[] arr_enteros = new int[5];

        //cargarArregloDouble(arr_double);
        cargarArregloBoolean(arr_boolean);
        cargarArregloNumeros(arr_numeros);
        cargarArregloAleatoreo(arr_aleatoreos);
        cargararregloAsientosLibres(asientosLibres);
        cargarArregloEnteros(arr_enteros);

        /*System.out.println("Imprimir arreglo double:");
        imprimirArregloDouble(arr_double);*/
        System.out.println("Imprimir arreglo boolean:");
        imprimirArregloBoolean(arr_boolean);
        System.out.println("Promedio de aareglo de números: " + promedio(arr_numeros));
        System.out.println("Imprimir arreglo aleatoreo:");
        imprimirArregloAleatoreo(arr_aleatoreos);
        System.out.println("Imprimir cantidad de positivos, negativos y ceros:");
        contarElementos(arr_enteros);
    }

    private static void cargarArregloDouble(double[] arr){
        double valor;
        Scanner input = new Scanner(System.in);

        System.out.println("Cargar arreglo de doubles:");

        for (int i = 0; i < arr.length ; i++) {
            System.out.println("Ingrese valor en posición " + i);
            valor = input.nextDouble();
            arr[i] = valor;
        }
    }

    private static void imprimirArregloDouble(double[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void cargarArregloBoolean(boolean[] arr){
        for (int i = 0; i < arr.length ; i++) {
            if(i % 2 == 0){
                arr[i] = true;
            }else{
                arr[i] = false;
            }
        }
    }

    private static void imprimirArregloBoolean(boolean[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void cargarArregloNumeros(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = i * 2;
        }
    }

    private static int suma(int[] arr){
        int suma = 0;

        for (int i = 0; i < arr.length ; i++) {
            suma = suma + arr[i];
        }
        return suma;
    }

    private static int promedio(int[] arr){
        return suma(arr) / arr.length;
    }

    private static void cargarArregloAleatoreo(double[] arr){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = Math.random() * 100 + 1;//Genera valor aleatoreo entre 1 y 100.
        }
    }

    private static void imprimirArregloAleatoreo(double[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void cargararregloAsientosLibres(boolean[] arr){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = true;
        }
    }

    private static void cargarArregloEnteros(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (int)Math.random()*(-10)+1;//Convierto tipo double a int
        }
    }

    private static void contarElementos(int[] arr){
        int c_positivos= 0;
        int c_negativo = 0;
        int c_ceros = 0;

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == 0){
                c_ceros++;
            }else if(arr[i] < 0){
                c_negativo++;
            }else {
                c_positivos++;
            }
        }

        System.out.println("Cantidad de números positivos: " + c_positivos);
        System.out.println("Cantidad de números negativos: " + c_negativo);
        System.out.println("Cantidad de ceros: " + c_ceros);
    }
}
