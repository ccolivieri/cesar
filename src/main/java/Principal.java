import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    private static Scanner input = new Scanner(System.in);
    private static int opcion = 0;
    private static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

    public static void main(String args[]){
        System.out.println("Ingrese un valor en el siguiente menú de opciones.");

        while (opcion != 5){
            System.out.println("1. Agregar profesor");
            System.out.println("2. Agregar alumno");
            System.out.println("3. Ver alumnos");
            System.out.println("4. Ver profesores");
            System.out.println("5. Salir");
            opcion = input.nextInt();

            if(opcion == 1){
                agregarProfesor();
            }else if(opcion == 2){
                agregarAlumno();
            }else if(opcion == 3){
                verAlumnos();
            }else if(opcion == 4){
                verProfesores();
            }
        }
    }

    private static void agregarProfesor(){
        String nombre;
        String ci;
        int edad;
        String materia;
        float salario;

        System.out.print("Ingrese el nombre (obligatorio): ");
        nombre = input.next();
        System.out.print("\nIngrese cédula de identidad (obligatorio): ");
        ci = input.next();
        System.out.print("\nIngrese su edad (opcional): ");
        edad = input.nextInt();
        System.out.print("\nIngrese materia (obligatorio): ");
        materia = input.next();
        System.out.print("\nIngrese su salario (obligatorio): ");
        salario = input.nextFloat();

        Profesor profesor = new Profesor(nombre, ci, edad, materia, salario);
        listaPersonas.add(profesor);
    }

    private static void agregarAlumno(){
        String nombre;
        String ci;
        int edad;
        int nroEstudiante;
        String grupo;

        System.out.print("Ingrese el nombre (obligatorio): ");
        nombre = input.next();
        System.out.print("\nIngrese cédula de identidad (obligatorio): ");
        ci = input.next();
        System.out.print("\nIngrese su edad (opcional): ");
        edad = input.nextInt();
        System.out.print("\nIngrese su número de estudiante (obligatorio): ");
        nroEstudiante = input.nextInt();

        Alumno alumno = new Alumno(nombre, ci, edad, nroEstudiante);
        listaPersonas.add(alumno);
    }

    private static void verProfesores(){

        System.out.println("******Listado de Profesores******");

        for(Persona p: listaPersonas){
            if(p instanceof Profesor){
                System.out.println(p.toString());
            }
        }
    }

    private static void verAlumnos(){
        System.out.println("******Listado de Alumnos******");

        for(Persona p: listaPersonas){
            if(p instanceof Alumno){
                System.out.println(p.toString());
            }
        }
    }
}
