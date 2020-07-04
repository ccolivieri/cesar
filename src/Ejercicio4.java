/*
Crear un método llamado tipoTriangulo, que dado 3 valores enteros recibidos por parámetro,
imprima en pantalla si es escaleno, si es equilátero o isósceles.
* */

public class Ejercicio4 {

    public static void main(String args[]){

    }

    public static void tipoTriangulo(int l1, int l2, int l3){

        if(l1 == l2 && l1 == l3 && l2 == l3){
            System.out.println("Triángulo equilatero");
        }
    }
}
