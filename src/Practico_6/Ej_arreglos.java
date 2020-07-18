package Practico_6;

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
        System.out.println("Cantidad de elementos del arreglo asientosLibres: " + contarElementos(asientosLibres));
        System.out.println("Promedio arreglo double: " + promedio(arr_double));
        System.out.println("Mínimo valor de un arreglo de enteros: " + menor(arr_enteros));
        System.out.println("Máximo valor de un arreglo de enteros: " + mayor(arr_enteros));
        System.out.println("Hay vacantes?: " + hayVacantes(asientosLibres));

        if(existeValor(arr_enteros) == true){
            System.out.println("El valor ingresado existe en el arreglo de enteros!");
        }else {
            System.out.println("No existe el valor ingresado en el arreglo de enteros");
        }

        if(todosVerdaderos(arr_boolean) == true){
            System.out.println("Elementos de arreglo de booleanos son todos verdaderos!");
        }else {
            System.out.println("Existen elementos del arreglo de booleanos falsos");
        }
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

    //Crear un método que reciba un arreglo, y retorne la suma.
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

    /*
    Crear un array de booleanos con 10 posiciones llamado asientosLibres y colocar todos sus elementos en true.
    * */
    private static void cargararregloAsientosLibres(boolean[] arr){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = true;
        }
    }

    private static void cargarArregloEnteros(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            if(i%2 == 0){
                arr[i] = (int)(Math.random()*10);//Convierto tipo double a int
            }else{
                arr[i] = (int)(Math.random()*(-10));
            }
        }
    }

    /*
    Contar el número de elementos positivos, negativos y ceros en un array de 5 enteros.
    Mostrar la cantidad de números positivos, negativos y ceros:
    Ej. “Se ingresaron 2 números positivos, 1 número negativo y 1 cero”
    * */
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

    //Crear un método que reciba un arreglo, y retorne la cantidad de elementos de la misma.
    public static int contarElementos(boolean[] arr){
        int cant_elementos = 0;

        for (int i = 0; i < arr.length; i++) {
            cant_elementos++;
        }
        return cant_elementos;
    }

    /*
    Crear un método llamado crearArregloBooleano que retorne un arreglo de 10 posiciones de tipo
    booleanos donde todas sus posiciones tengan valor false.
    * */
    public static boolean[] crearArregloBooleano(){
        boolean[] arr = new boolean[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }
        return arr;
    }

    /*
    Crear un método llamado imprimirArreglo que imprima en pantalla todos los elementos de un array
    de enteros el cual es recibido por parámetro.
    * */
    public static void imprimirArreglo(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /*
    * Crear un método llamado imprimirArreglo que imprima en pantalla todos los elementos de un
    * array de booleanos el cual es recibido por parámetro.
    * */
    public static void imprimirArreglo(boolean[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //Crear un método que muestre en pantalla todos los elementos de un array de float.
    public static void imprimirArreglo(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //Crear un método que reciba una arreglo, y retorne el promedio de los mismos.
    public static double promedio(double[] arr){
        double suma = 0;

        for (int i = 0; i < arr.length; i++) {
            suma += arr[i];
        }
        return suma / arr.length;
    }

    //Crear un método que reciba un arreglo de enteros, y retorne el menor.
    private static int menor(int[] arr){
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    //Crear un método que reciba un arreglo de enteros, y retorne el mayor.
    private static int mayor(int[] arr){
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    /*
    Crear un método llamado hayVacantes que reciba un arreglo de booleanos y retorne verdadero si
    alguna de sus posiciones esta en true, de lo contrario, deberá retornar false.
    * */
    private static boolean hayVacantes(boolean[] arr){
        boolean hay = false;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == true){
                hay = true;
            }
        }
        return hay;
    }
    /*
    Crear un método reciba un arreglo de enteros por parámetro y que solicite el ingreso de un valor.
    Debe retornar true si y sólo si el valor ingresado por el usuario se encuentra en el arreglo.
    * */
    private static boolean existeValor(int[] arr){
        boolean existe = false;
        Scanner input = new Scanner(System.in);
        int valor = 0;

        System.out.println("Ingrese el valor a buscar: ");
        valor = input.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if(valor == arr[i]){
                existe = true;
            }
        }
        return existe;
    }

    /*
    Crear un método que reciba un arreglo de booleanos y retorne true si y sólo si,
    todos los elementos son verdaderos.
    * */
    private static boolean todosVerdaderos(boolean[] arr){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == false){
                return false;
            }
        }
        return true;
    }
}
