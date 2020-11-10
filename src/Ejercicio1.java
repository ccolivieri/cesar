/*
Método que reciba dos números y retorne verdadero si el primer numero es mayor que el segundo.
De lo contrario, retornar debe retornar falso.
* */
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n1;
        int n2;

        System.out.println("Ingrese el primer número.");
        n1 = input.nextInt();
        System.out.println("Ingrese el segundo número.");
        n2 = input.nextInt();

        if(esMayor(n1, n2) == true){
            System.out.println("El primer número es mayor que el segundo.");
        }else {
            System.out.println("El primer numero es menor o igual al segundo.");
        }
    }

    public static boolean esMayor(int n1, int n2){

        if(n1 > n2){
            return true;
        }
        return false;
    }
}
