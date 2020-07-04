/*
Crear un método llamado tipoTriangulo, que dado 3 valores enteros recibidos por parámetro,
imprima en pantalla si es escaleno, si es equilátero o isósceles.
* */

public class Ejercicio4 {

    public static void main(String args[]){
        int lado1 = 0;
        int lado2 = 0;
        int lado3 = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el valor de un lado del triángulo:");
        lado1 = input.nextInt();
        System.out.println("Ingrese el valor del otro lado del triángulo:");
        lado2 = input.nextInt();
        System.out.println("Ingrese el valor del otro lado del triángulo:");
        lado3 = input.nextInt();

        tipoTriangulo(lado1, lado2, lado3);
    }

    public static void tipoTriangulo(int l1, int l2, int l3){

        if(l1 == l2 && l1 == l3 && l2 == l3){
            System.out.println("Triángulo equilatero");
        }else if(l1 == l2 && l1 != l3){
            System.out.println("Triángulo isósceles");
        }else{
            System.out.println("Triángulo escaleno");
        }
    }
}
