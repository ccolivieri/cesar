import java.util.Scanner;

public class Libreria {

    private static Libro l1;
    private static Libro l2;

    public static void main(String args[]){
        int isbn = 0;
        String titulo = null;
        String autor = null;
        int nroPaginas = 0;
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 2 ; i++) {
            crearLibro(i, titulo, autor, isbn, nroPaginas, input);
        }
        System.out.println(l1.toString());
        System.out.println(l2.toString());
    }

    public static void crearLibro(int i, String titulo, String autor, int isbn, int nroPaginas, Scanner input){

        System.out.println("Ingrese el título:");
        titulo = input.nextLine();
        System.out.println("Ingrese el autor (Ingrese null sino va a ingresar el nombre del autor):");
        autor = input.nextLine();
        System.out.println("Ingrese el ISBN:");
        isbn = input.nextInt();
        System.out.println("Ingrese el número de páginas:");
        nroPaginas = input.nextInt();

        if(i==1){
            l1 = new Libro(isbn, titulo, autor, nroPaginas);
            if(l1.tieneAutor("null") == true){
                l1.setAutor("Desconocido");
            }
        }else {
            l2 = new Libro(isbn, titulo, autor, nroPaginas);
            if(l2.tieneAutor("null") == true){
                l2.setAutor("Desconocido");
            }
        }
    }
}
